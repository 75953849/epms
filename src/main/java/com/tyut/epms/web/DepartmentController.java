package com.tyut.epms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Department;
import com.tyut.epms.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/findAllDep")
	@ResponseBody
	public List<Department> findAllDep() {
		List<Department> deps = departmentService.findAllDep();
		return deps;
	}
	
	@RequestMapping("/toDepList")
	public String toDepList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="2") int rows,HttpServletRequest req) {
		
		PageInfo<Department> deps = departmentService.findAllDepByPage(page, rows);
		req.setAttribute("page", deps);
		return "dep/depList";
	}
	
	@RequestMapping("/toChangeDep")
	public String toChangeDep(Long id,HttpServletRequest req) {
		
		Department dep = departmentService.findDepById(id);
		req.setAttribute("dep", dep);
		return "dep/changeDep";
	}
	
	@RequestMapping("/changeDep")
	public String changeDep(Department dep,HttpServletRequest req) {
		departmentService.updateDepById(dep);
		return "redirect:toDepList";
	}
	
	@RequestMapping("/toAddDep")
	public String toAddDep() {
		return "dep/addDep";
	}
	
	@RequestMapping("/addDep")
	public String addDep(Department dep) {
		departmentService.addDep(dep);
		return "redirect:toDepList";
	}
	
	
}
