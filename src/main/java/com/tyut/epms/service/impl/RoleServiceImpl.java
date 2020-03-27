package com.tyut.epms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Role;
import com.tyut.epms.bean.RoleExample;
import com.tyut.epms.bean.RoleExample.Criteria;
import com.tyut.epms.dao.RoleMapper;
import com.tyut.epms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public PageInfo<Role> findAllRoleByPage(int curPage, int size, Role role) {

		PageHelper.startPage(curPage, size);
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		if(role.getId()!=null){
			criteria.andIdEqualTo(role.getId());
		}
		if(role.getDepName()!=null&&!role.getDepName().equals("")) {
			criteria.andDepNameLike("%"+role.getDepName()+"%");
		}
		if(role.getRoleName()!=null&&!role.getRoleName().equals("")) {
			criteria.andRoleNameLike("%"+role.getRoleName()+"%");
		}
		
		List<Role> list = roleMapper.selectByExample(example );
		PageInfo<Role> roleInfo = new PageInfo<>(list);
		
		return roleInfo;
	}
	
	@Override
	public void insertRole(Role role) {

		roleMapper.insertSelective(role);
	}
	@Override
	public List<Role> findAllRoleByDepId(long depId) {
		
		RoleExample example = new RoleExample();
		example.createCriteria().andDepIdEqualTo(depId);
		return roleMapper.selectByExample(example);
	}
}
