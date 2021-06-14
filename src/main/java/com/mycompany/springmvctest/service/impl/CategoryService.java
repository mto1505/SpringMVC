package com.mycompany.springmvctest.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.mycompany.springmvctest.dao.ICategoryDAO;
import com.mycompany.springmvctest.model.CategoryModel;
import com.mycompany.springmvctest.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
