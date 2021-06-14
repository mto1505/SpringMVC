package com.mycompany.springmvctest.service;

import com.mycompany.springmvctest.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
