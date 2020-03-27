package com.tyut.epms.service;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Employee;

public interface EmployeeService {
	public Employee findEmpById(long id);
	
	public PageInfo<Employee> findAllEmpByPage(int curPage,int size);
	public PageInfo<Employee> findEmpByPage(int curPage,int size,Employee emp);
	
	public void updateEmployeeById(Employee emp);
	
	public void addEmp(Employee emp);
	
	
}
