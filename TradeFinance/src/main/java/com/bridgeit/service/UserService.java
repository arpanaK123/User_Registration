package com.bridgeit.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.DAO.UserDAO;
import com.bridgeit.model.UserModel;

@Service
public class UserService {
	private DataSource dataSource;
	@Autowired
	UserDAO userDao;	

	public void callToUserdDAO(UserModel userModel)
	
	{
		userDao.inserData(userModel);
	}
//	public void callToUserdDAO(UserModel userModel)
//	{
//		System.out.println("usermodel: "+userModel);
//			if(userDao.checkEmailPresent(userModel)) {
//				System.out.println("already exit");	
//			}
//			else {
//				userDao.inserData(userModel);
//			}
//	}
//
//	public void callToDaoForLogin(UserModel userModel)
//	{
//		userDao.insertLoginData(userModel);
//	}


}
