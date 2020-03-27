package com.tyut.epms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Department;
import com.tyut.epms.dao.DepartmentMapper;
import com.tyut.epms.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public PageInfo<Department> findAllDepByPage(int curPage, int size) {

		PageHelper.startPage(curPage, size);
		List<Department> list = departmentMapper.selectByExample(null);
		PageInfo<Department> deps = new PageInfo<>(list);
		return deps;
	}

	@Override
	public Department findDepById(long id) {
		Department dep = departmentMapper.selectByPrimaryKey(id);
		return dep;
	}

	@Override
	public void updateDepById(Department dep) {

		departmentMapper.updateByPrimaryKeySelective(dep);
	}
	
	@Override
	public void addDep(Department dep) {

		departmentMapper.insertSelective(dep);
	}

	@Override
	public List<Department> findAllDep() {

		List<Department> deps = departmentMapper.selectByExample(null);
		return deps;
	}
}
