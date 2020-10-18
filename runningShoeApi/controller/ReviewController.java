package com.promineotech.runningShoeApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.runningShoeApi.entity.Review;
import com.promineotech.runningShoeApi.service.ReviewService;


@RestController
@RequestMapping("/shoes/{shoeId}/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public ResponseEntity<Object> createReview(@RequestBody Review review, 
			@PathVariable Long userId, @PathVariable Long shoeId) {
		try {
			return new ResponseEntity<Object>(service.createReview(review, userId, shoeId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{reviewId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteReview(@PathVariable Long reviewId) {
		service.deleteReview(reviewId);
		return new ResponseEntity<Object>("Deleted review with id:" + reviewId, HttpStatus.OK);
	}
	
}
