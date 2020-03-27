package com.tyut.epms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Employee;
import com.tyut.epms.bean.EmployeeExample;
import com.tyut.epms.bean.EmployeeExample.Criteria;
import com.tyut.epms.dao.EmployeeMapper;
import com.tyut.epms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeMapper employeeMapeer;
	
	
	@Override
	public Employee findEmpById(long id) {

		Employee emp = employeeMapeer.selectByPrimaryKey(id);
		
		return emp;
	}


	@Override
	public PageInfo<Employee> findAllEmpByPage(int curPage, int size) {

		PageHelper.startPage(curPage, size);
		List<Employee> list = employeeMapeer.selectByExample(null);
		PageInfo<Employee> empInfo = new PageInfo<>(list);
		return empInfo;
	}


	@Override
	public void updateEmployeeById(Employee emp) {
		employeeMapeer.updateByPrimaryKey(emp);
	}


	@Override
	public PageInfo<Employee> findEmpByPage(int curPage, int size, Employee emp) {

		PageHelper.startPage(curPage, size);
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
	
		System.out.println(emp);
		
		if(emp.getEmpName()!=null&&!emp.getEmpName().equals("")) {
			criteria.andEmpNameLike("%"+emp.getEmpName()+"%");
		}
		if(emp.getDepName()!=null&&!emp.getDepName().equals("")) {
			criteria.andDepNameLike("%"+emp.getDepName()+"%");
		}
		if(emp.getId()!=null) {
			
			criteria.andIdEqualTo(emp.getId());
		}
		if(emp.getRoleName()!=null&&!emp.getRoleName().equals("")) {
			criteria.andRoleNameLike("%"+emp.getRoleName()+"%");
		}
		
		List<Employee> list = employeeMapeer.selectByExample(example);
		System.out.println("list----"+list);
		PageInfo<Employee> empInfo = new PageInfo<>(list);
		return empInfo;
	}


	@Override
	public void addEmp(Employee emp) {
		employeeMapeer.insertSelective(emp);
	}


}
