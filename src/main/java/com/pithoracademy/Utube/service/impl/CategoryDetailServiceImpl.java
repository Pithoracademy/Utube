package com.pithoracademy.Utube.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pithoracademy.Utube.model.CategoryDetail;
import com.pithoracademy.Utube.repo.CategoryDetailRepo;
import com.pithoracademy.Utube.service.CategoryDetailService;

@Service
public class CategoryDetailServiceImpl implements CategoryDetailService{

	
	@Autowired
	private CategoryDetailRepo categoryDetailRepo;
	
	@Override
	public List<CategoryDetail> getAll() {
		return categoryDetailRepo.findAll();
	}

	@Override
	public CategoryDetail get(Integer id) {
		Optional<CategoryDetail> cat = categoryDetailRepo.findById(id);
		return cat.isPresent() ? cat.get() : null;
	}

	@Override
	public CategoryDetail save(CategoryDetail categoryDetail) {
		return categoryDetailRepo.save(categoryDetail);
	}

	@Override
	public void delete(Integer id) {
		categoryDetailRepo.deleteById(id);
	}
	

}
