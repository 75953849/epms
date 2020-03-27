package com.tyut.epms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Department;

public interface DepartmentService {

	public PageInfo<Department> findAllDepByPage(int curPage, int size);

	public Department findDepById(long id);
	
	public void updateDepById(Department dep);
	
	public void addDep(Department dep);
	
	public List<Department> findAllDep();
}
