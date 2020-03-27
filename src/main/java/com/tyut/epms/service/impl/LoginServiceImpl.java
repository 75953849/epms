package com.tyut.epms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyut.epms.bean.Login;
import com.tyut.epms.bean.LoginExample;
import com.tyut.epms.dao.LoginMapper;
import com.tyut.epms.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public Login validate(Login info) throws Exception {

		LoginExample example = new LoginExample();
		example.createCriteria().andLoginNameEqualTo(info.getLoginName()).andLoginPasswordEqualTo(info.getLoginPassword());
		List<Login> list = loginMapper.selectByExample(example);
		if(list.isEmpty()) {
			throw new Exception("用户名或密码错误");
		}else {
			return list.get(0);
		}
	}

	@Override
	public Login findLoginById(long id) {

		Login login = loginMapper.selectByPrimaryKey(id);
		
		return login;
	}
	

	@Override
	public void changePass(long id, String oldPassword, String newPassword) throws Exception {

		Login login = findLoginById(id);
		if(login.getLoginPassword().equals(oldPassword)) {
			if(newPassword==null||newPassword.isEmpty()) {
				throw new Exception("新密码不能为空");
			}else {
				Login record = new Login();
				record.setId(id);
				record.setLoginPassword(newPassword);
				loginMapper.updateByPrimaryKeySelective(record );
			}
			
		}else {
			throw new Exception("旧密码错误");
		}
	}
	
	

}
