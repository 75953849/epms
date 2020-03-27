package com.tyut.epms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Role;
import com.tyut.epms.service.DepartmentService;
import com.tyut.epms.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/toRoleList")
	public String toRoleList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="2") int rows,Role role,HttpServletRequest req) {
		PageInfo<Role> roles = roleService.findAllRoleByPage(page, rows, role);
		req.setAttribute("page", roles);
		return "role/roleList";
		
	}
	
	@RequestMapping("/toAddRole")
	public String toAddRole() {
		return "role/addRole";
	}
	
	@RequestMapping("/addRole")
	public String addRole(Role role) {
		roleService.insertRole(role);
		System.out.println(role.getRoleName());
		return "redirect:toRoleList";
	}
	
	
	@RequestMapping("/findAllRole")
	@ResponseBody
	public List<Role> findAllRole(long depId) {
		return roleService.findAllRoleByDepId(depId);
	}
}
