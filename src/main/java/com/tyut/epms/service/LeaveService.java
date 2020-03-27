package com.tyut.epms.service;

import com.github.pagehelper.PageInfo;
import com.tyut.epms.bean.Leave;

public interface LeaveService {
	public void addLeave(Leave leave);
	
	public PageInfo<Leave> findLeaveByPage(int curPage,int size,Leave leave);

	public void updateOpinionById(long id,String opinion);
}
