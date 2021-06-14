package com.mycompany.springmvctest.dao.impl;

import java.util.List;

import com.mycompany.springmvctest.dao.IUserDAO;
import com.mycompany.springmvctest.mapper.UserMapper;
import com.mycompany.springmvctest.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM \"user\" AS u");
		sql.append(" INNER JOIN role_user AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}
	
}
