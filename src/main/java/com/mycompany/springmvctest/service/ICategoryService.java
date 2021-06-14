package com.mycompany.springmvctest.service;

import java.util.List;

import com.mycompany.springmvctest.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
