package com.tyut.epms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Employee;
import com.tyut.epms.bean.Leave;
import com.tyut.epms.bean.Login;
import com.tyut.epms.service.EmployeeService;
import com.tyut.epms.service.LeaveService;

@Controller
public class LeaveController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LeaveService leaveService;

	@RequestMapping("/toApplyHoliday")
	public String toApplyHoliday(HttpServletRequest req,HttpSession session) {
		Login l = (Login)session.getAttribute("login");
		Employee emp = employeeService.findEmpById(l.getEmpId());
		req.setAttribute("emp", emp);
		return "leave/applyHoliday";
	}
	
	@RequestMapping("/applyHoliday")
	public String applyHoliday(Leave leave) {
		System.out.println(leave);
		leaveService.addLeave(leave);
		return "success";
	}
	
	@RequestMapping("/toApproval")
	public String toApproval(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="2") int rows,Leave leave,HttpServletRequest req) {
		System.out.println(leave);
		PageInfo<Leave> leaves = leaveService.findLeaveByPage(page, rows, leave);
		req.setAttribute("page", leaves);
		if(leave.getState()==null) {
			return "leave/leaveList2";
		}
		return "leave/leaveList";
		
	}
	@RequestMapping("/approval")
	public String approval(long id,String opinion) {
		leaveService.updateOpinionById(id, opinion);
		return "success";
	}
}
