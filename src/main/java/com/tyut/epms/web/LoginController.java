package com.tyut.epms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tyut.epms.bean.Employee;
import com.tyut.epms.bean.Login;
import com.tyut.epms.service.EmployeeService;
import com.tyut.epms.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping({"/","/toLogin"})
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String validate(Login info,HttpSession session,HttpServletRequest req) {
		
		try {
			Login login = loginService.validate(info);
			Employee emp = employeeService.findEmpById(login.getEmpId());
			session.setAttribute("e", emp);
			session.setAttribute("login", login);
			return "main";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			req.setAttribute("msg", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping("/toChangePass")
	public String toChangePass() {
		return "personal/changePassword";
	}
	
	@RequestMapping("/changePass")
	public String changePass(long id,String oldPassword,String newPassword,HttpServletRequest req) {
		
		try {
			loginService.changePass(id, oldPassword, newPassword);
			req.setAttribute("msg", "修改密码成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			req.setAttribute("msg", e.getMessage());
		}
		
		return "personal/changePassword";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session,HttpServletRequest req) {
		session.removeAttribute("login");
		req.setAttribute("msg", "已退出系统");
		return "login";
	}

}
