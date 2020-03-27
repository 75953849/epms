package com.tyut.epms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Employee;
import com.tyut.epms.bean.Login;
import com.tyut.epms.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	@RequestMapping("/toPersonalPage")
	public String toPersonalPage(HttpSession session,HttpServletRequest req) {
		 Login login = (Login)session.getAttribute("login");
		 Employee emp = employeeService.findEmpById(login.getEmpId());
		 req.setAttribute("emp", emp);
		 return "personal/personalPage";
	}
	
	@RequestMapping("/toEmpList")
	public String toEmpList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="2") int rows,Employee emp,HttpServletRequest req) {
		
		PageInfo<Employee> emps = employeeService.findEmpByPage(page, rows, emp);
		req.setAttribute("page", emps);
		return "emp/empList";
	}
	
	@RequestMapping("/toModifyPI")
	public String toModifyPI(HttpSession session,HttpServletRequest req) {
		Login login = (Login)session.getAttribute("login");
		Employee emp = employeeService.findEmpById(login.getEmpId());
		req.setAttribute("emp", emp);
		return "personal/modifyPI";
	}
	
	@RequestMapping("/modifyPI")
	public String modifyPI(Employee emp) {
		
		employeeService.updateEmployeeById(emp);
		//return "redirect:/toPersonalPage";
		return "success";
	}
	@RequestMapping("/toAddEmp")
	public String toAddEmp() {
		return "emp/addEmp";
	}
	
	@RequestMapping("/addEmp")
	public String addEmp(Employee emp) {
		employeeService.addEmp(emp);
		return "redirect:/toEmpList?empId="+emp.getId();
	}
	
	@RequestMapping("/showEmp")
	public String showEmp(long id,HttpServletRequest req) {
		Employee emp = employeeService.findEmpById(id);
		req.setAttribute("emp", emp);
		return "personal/personalPage";
	}
	
	@RequestMapping("/modifyEmp")
	public String modifyEmp(long id,HttpServletRequest req) {
		Employee emp = employeeService.findEmpById(id);
		req.setAttribute("emp", emp);
		return "personal/modifyPI";
	}
}
