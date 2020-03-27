package com.tyut.epms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Leave;
import com.tyut.epms.bean.LeaveExample;
import com.tyut.epms.bean.LeaveExample.Criteria;
import com.tyut.epms.dao.LeaveMapper;
import com.tyut.epms.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveMapper leaveMapper;
	
	@Override
	public void addLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveMapper.insertSelective(leave);
	}

	@Override
	public PageInfo<Leave> findLeaveByPage(int curPage, int size,Leave leave) {
		PageHelper.startPage(curPage, size);
		LeaveExample example = new LeaveExample();
		Criteria criteria = example.createCriteria();
		if(leave.getState()!=null&&!leave.getState().equals(""))
			criteria.andStateEqualTo(leave.getState());
		if(leave.getEmpId()!=null) {
			criteria.andEmpIdEqualTo(leave.getEmpId());
		}
		List<Leave> list = leaveMapper.selectByExample(example);
		PageInfo<Leave> ls = new PageInfo<>(list);
		return ls;
	}
	
	@Override
	public void updateOpinionById(long id, String opinion) {
		// TODO Auto-generated method stub
		Leave l = new Leave();
		l.setId(id);
		l.setOpinion(opinion);
		l.setState("1");
		leaveMapper.updateByPrimaryKeySelective(l);
	}

}
