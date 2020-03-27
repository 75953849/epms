package com.tyut.epms.service;

import com.tyut.epms.bean.Login;

public interface LoginService {
	public Login validate(Login info) throws Exception;
	
	public Login findLoginById(long id);
	
	public void changePass(long id,String oldPassword,String newPassword) throws Exception;;


}
