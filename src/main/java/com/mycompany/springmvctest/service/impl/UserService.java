package com.mycompany.springmvctest.service.impl;

import com.mycompany.springmvctest.dao.IUserDAO;
import com.mycompany.springmvctest.dao.impl.UserDAO;
import com.mycompany.springmvctest.model.UserModel;
import com.mycompany.springmvctest.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
