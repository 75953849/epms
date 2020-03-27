package com.tyut.epms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Role;

public interface RoleService {
	public PageInfo<Role> findAllRoleByPage(int curPage,int size,Role role);
	
	public void insertRole(Role role);
	
	public List<Role> findAllRoleByDepId(long depId);
}
