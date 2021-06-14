package com.mycompany.springmvctest.dao;

import java.util.List;
import com.mycompany.springmvctest.model.CategoryModel;



public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findOne(long id);
	CategoryModel findOneByCode(String code);
}
