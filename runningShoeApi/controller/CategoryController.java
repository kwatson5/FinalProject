package com.promineotech.runningShoeApi.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.runningShoeApi.entity.Category;
import com.promineotech.runningShoeApi.service.CategoryService;

@RestController
@RequestMapping("/shoes/{shoeId}/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	//public ResponseEntity<Object> getCategories() {
	//	return new ResponseEntity<Object>(service.getCategories(), HttpStatus.OK);
	//}
	
	//@RequestMapping(value="/{shoeId}/users/{userId}", method=RequestMethod.POST)
	//public ResponseEntity<Object> addCategory(@RequestBody Category category) {
	//	try {
	//		return new ResponseEntity<Object>(service.addCategory(category), HttpStatus.CREATED);
	//	} catch (Exception e) {
	//		return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
	//	}
	//}
	
	@RequestMapping(value="/user/{userId}", method=RequestMethod.POST)
	public ResponseEntity<Object> createCategory(@RequestBody Category category, @PathVariable Long userId, 
			@PathVariable Iterable<Long> shoeId) {
		try {
			return new ResponseEntity<Object>(service.createCategory(category, userId, shoeId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateCategory(@RequestBody Category category, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateCategory(category, id), HttpStatus.OK);
		} catch (Exception e ) {
			return new ResponseEntity<Object>("Unable to update category.", HttpStatus.BAD_REQUEST);
		}
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	//public ResponseEntity<Object> deleteCategory(@PathVariable Long id) {
	//	try {
	//		service.removeCategory(id);
	//		return new ResponseEntity<Object>("Successfully deleted category with id: " + id, HttpStatus.OK);
	//	} catch (Exception e) {
	//		return new ResponseEntity<Object>("Unable to delete category", HttpStatus.BAD_REQUEST);
	//	}
	//}

}
