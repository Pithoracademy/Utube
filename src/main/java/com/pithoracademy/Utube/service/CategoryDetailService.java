package com.pithoracademy.Utube.service;

import java.util.List;

import com.pithoracademy.Utube.model.CategoryDetail;

public interface CategoryDetailService {
	
	// get all
	List<CategoryDetail> getAll();
	
	// get by id
	CategoryDetail get(Integer id);
	
	// save or update
	CategoryDetail save(CategoryDetail categoryDetail);
	
	// delete
	void delete(Integer id);

}
