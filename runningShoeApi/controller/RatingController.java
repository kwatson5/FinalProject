package com.promineotech.runningShoeApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.runningShoeApi.entity.Rating;
import com.promineotech.runningShoeApi.service.RatingService;

@RestController
@RequestMapping("/shoes/{shoeId}/ratings")
public class RatingController {

	@Autowired
	private RatingService service;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public ResponseEntity<Object> createRating(@RequestBody Rating rating, @PathVariable Long userId, @PathVariable Long shoeId) {
		try {
			return new ResponseEntity<Object>(service.createRating(rating, userId, shoeId), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}
			
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteRating(@PathVariable Long ratingId) {
			service.deleteRating(ratingId);
			return new ResponseEntity<Object>("Successfully deleted rating with id: " + ratingId, HttpStatus.OK);
		} 
	}

