package com.tyut.epms.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Attendance;
import com.tyut.epms.service.AttendanceService;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@RequestMapping("/toAttendance")
	public String toAttendance() {
		
		return "att/attendance";
	}
	
	@RequestMapping("/attendance")
	public String attendance(Attendance att,HttpServletRequest req) {
		System.out.println(att);
		try {
			attendanceService.attman(att);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			req.setAttribute("msg", e.getMessage());
			return "att/attendance";
		}
		return "success";
	}
	
	@RequestMapping("/toAttendanceList")
	public String toAttendanceList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="2") int rows,Attendance att,HttpServletRequest req) {
		PageInfo<Attendance> atts = attendanceService.findAttByPage(page, rows, att);
		req.setAttribute("page", atts);
		return "att/attendanceList";
	}
	@RequestMapping("/toPersonalAttendanceList")
	public String toPersonalAttendanceList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="2") int rows,Attendance att,HttpServletRequest req) {
		PageInfo<Attendance> atts = attendanceService.findAttByPage(page, rows, att);
		req.setAttribute("page", atts);
		return "att/personalAttendanceList";
	}
	
	
}
