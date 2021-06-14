package com.mycompany.springmvctest.dao;

import com.mycompany.springmvctest.mapper.RowMapper;
import com.mycompany.springmvctest.model.UserModel;
import java.util.List;



public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void update (String sql, Object... parameters);
	Long insert (String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
