package com.mycompany.springmvctest.service;

import java.util.List;

import com.mycompany.springmvctest.model.NewModel;
import com.mycompany.springmvctest.paging.Pageble;

public interface INewService {
	/*List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long[] ids);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	NewModel findOne(long id);*/
    List<NewModel> findAll();
}
