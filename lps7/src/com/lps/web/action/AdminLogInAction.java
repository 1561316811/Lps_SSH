package com.lps.web.action;



import java.sql.Date;

import com.lps.model.Admin;
import com.lps.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLogInAction extends ActionSupport{

	private static final long serialVersionUID = -8272027747829678377L;
	
	private AdminService adminServiceImpl;
	
	
	public AdminService getAdminServiceImpl() {
		return adminServiceImpl;
	}

	public void setAdminServiceImpl(AdminService adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String execute() throws Exception {
		adminServiceImpl.save(new Admin("0001","0001", new java.sql.Timestamp(System.currentTimeMillis())));
//		System.out.println("success");
		return SUCCESS;
	}
	
	
}
