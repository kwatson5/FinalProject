package com.promineotech.runningShoeApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.runningShoeApi.entity.Shoe;
import com.promineotech.runningShoeApi.service.ShoeService;


@RestController
@RequestMapping("/shoes")
public class ShoeController {
	
	@Autowired
	private ShoeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllShoes() {
		return new ResponseEntity<Object>(service.getAllShoes(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{shoeId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getShoe(@PathVariable Long shoeId) {
		return new ResponseEntity<Object>(service.getShoe(shoeId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{shoeId}/users/{userId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateShoe(@RequestBody Shoe shoe, @PathVariable Long shoeId, @PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.updateShoe(shoe, shoeId, userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.POST)
	public ResponseEntity<Object> createShoe(@RequestBody Shoe shoe, @PathVariable Long userId) {
		try {
		return new ResponseEntity<Object>(service.createShoe(shoe, userId), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	@RequestMapping(value="/{shoeId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteShoe(@PathVariable Long shoeId) {
		service.deleteShoe(shoeId);
		return new ResponseEntity<Object>("Successfully deleted shoe with id: " +shoeId, HttpStatus.OK);
		} 
	}
	

