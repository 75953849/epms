package com.tyut.epms.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Attendance;
import com.tyut.epms.bean.AttendanceExample;
import com.tyut.epms.bean.AttendanceExample.Criteria;
import com.tyut.epms.bean.Subatt;
import com.tyut.epms.dao.AttendanceMapper;
import com.tyut.epms.dao.SubattMapper;
import com.tyut.epms.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceMapper attendanceMapper;
	@Autowired
	private SubattMapper subattMapper;

	@Override
	public void attman(Attendance att) throws Exception {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		//cal.set(Calendar.HOUR_OF_DAY, 12);
		Date time = cal.getTime();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		
		Subatt subatt = new Subatt();
		
		
		if(hour>=8&&hour<9) {
			//8-9
			att.setAmDate1(time);
			if(min>30) {
				att.setAmState1("迟到");
				subatt.setAttState("迟到");
			}else {
				att.setAmState1("正常");
				subatt.setAttState("正常");
			}
		}else if(hour>=12&&hour<13) {
			//12-13
			att.setAmDate2(time);
			if(min>=30) {
				att.setAmState2("正常");
				subatt.setAttState("正常");
			}else {
				att.setAmState2("早退");
				subatt.setAttState("早退");
			}
		}else if(hour>=13&&hour<14) {
			//13-14
			att.setPmDate1(time);
			if(min>30) {
				att.setAmState1("迟到");
				subatt.setAttState("迟到");
			}else {
				att.setAmState1("正常");
				subatt.setAttState("正常");
			}
		}else if(hour>=17&&hour<18) {
			//17-18
			att.setPmDate2(time);
			if(min>=30) {
				att.setAmState2("正常");
				subatt.setAttState("正常");
			}else {
				att.setAmState2("早退");
				subatt.setAttState("早退");
			}
		}else {
			//不在签到时间异常
			throw new Exception("不在签到时间内");
		}
		
	
		AttendanceExample example = new AttendanceExample();
		example.createCriteria().andAttDateEqualTo(cal.getTime()).andEmpIdEqualTo(att.getEmpId());
		//List<Attendance> list = attendanceMapper.selectByExample(example );
		int i = attendanceMapper.updateByExampleSelective(att, example);
		if(i==0) {
			//更新失败，需要插入
			att.setAttDate(cal.getTime());
			attendanceMapper.insertSelective(att);
			
		}
		
		
		subatt.setAttDate(time);
		subatt.setEmpId(att.getEmpId());
		subatt.setEmpName(att.getEmpName());
		subattMapper.insertSelective(subatt);
	
	}

	@Override
	public PageInfo<Attendance> findAttByPage(int curPage, int size, Attendance att) {
		PageHelper.startPage(curPage, size);
	
		AttendanceExample example = new AttendanceExample();
		Criteria c = example.createCriteria();
		if(att.getEmpId()!=null) {
			c.andEmpIdEqualTo(att.getEmpId());
		}
		if(att.getAttDate()!=null) {
			c.andAttDateEqualTo(att.getAttDate());
		}
		if(att.getEmpName()!=null&&att.getEmpName()!="") {
			c.andEmpNameLike("%"+att.getEmpName()+"%");
		}
		
		List<Attendance> list = attendanceMapper.selectByExample(example );
		PageInfo<Attendance> attInfo = new PageInfo<>(list);
		return attInfo;
	}

}
