package com.tyut.epms.service;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Attendance;

public interface AttendanceService {
	public void attman(Attendance att) throws Exception;
	
	public PageInfo<Attendance> findAttByPage(int curPage, int size,Attendance att);
}
