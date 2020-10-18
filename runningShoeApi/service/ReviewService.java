package com.promineotech.runningShoeApi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.runningShoeApi.entity.Review;
import com.promineotech.runningShoeApi.entity.Shoe;
import com.promineotech.runningShoeApi.entity.User;
import com.promineotech.runningShoeApi.repository.ReviewRepository;
import com.promineotech.runningShoeApi.repository.ShoeRepository;
import com.promineotech.runningShoeApi.repository.UserRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repo;
	
	@Autowired
	private ShoeRepository shoeRepo;
	
	@Autowired
	private UserRepository userRepo;

	
	public Review createReview(Review review, Long userId, Long shoeId) {
		User user = userRepo.findById(userId).orElseThrow();
		Shoe shoe = shoeRepo.findById(shoeId).orElseThrow();
		if (user == null || shoe == null) {
			throw new RuntimeException("User or shoe does not exist.");
		}
		review.setDate(new Date());
		review.setUser(user);
		review.setShoe(shoe);
		return repo.save(review);
	}
	
	public void deleteReview(Long reviewId) {
		repo.deleteById(reviewId);
	}

}
