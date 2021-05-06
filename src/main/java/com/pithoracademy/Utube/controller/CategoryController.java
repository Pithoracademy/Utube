package com.pithoracademy.Utube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pithoracademy.Utube.model.CategoryDetail;
import com.pithoracademy.Utube.service.CategoryDetailService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryDetailService categoryService;

	@GetMapping
	public ResponseEntity<List<CategoryDetail>> getAllCategory() {
		return ResponseEntity.ok(categoryService.getAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<CategoryDetail> getCategoryById(@PathVariable Integer id) {
		CategoryDetail cat = categoryService.get(id);
		return cat != null ? ResponseEntity.ok(cat) : new ResponseEntity<CategoryDetail>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDetail> saveCategory(@RequestBody CategoryDetail catDetail) {
		CategoryDetail cat = categoryService.save(catDetail);
		return cat != null && cat.getId() != null ? ResponseEntity.ok(cat) 
				: new ResponseEntity<CategoryDetail>(HttpStatus.NOT_MODIFIED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<CategoryDetail> updateCategory(@PathVariable Integer id, @RequestBody CategoryDetail catDetail) {
		if (id != null && catDetail.getId() != null && catDetail.getId() == id) {
			CategoryDetail cat = categoryService.save(catDetail);
			return cat != null && cat.getId() != null ? ResponseEntity.ok(cat) 
					: new ResponseEntity<CategoryDetail>(HttpStatus.NOT_MODIFIED);
		}
		else {			
			return new ResponseEntity<CategoryDetail>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
		if (id != null && categoryService.get(id) != null) {
			categoryService.delete(id);
			return ResponseEntity.ok("Deleted");
		}
		
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		
	}

}
