package com.mycompany.springmvctest.dao;

import com.mycompany.springmvctest.model.UserModel;



public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
