package com.promineotech.runningShoeApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.runningShoeApi.entity.Rating;
import com.promineotech.runningShoeApi.entity.Shoe;
import com.promineotech.runningShoeApi.entity.User;
import com.promineotech.runningShoeApi.repository.RatingRepository;
import com.promineotech.runningShoeApi.repository.ShoeRepository;
import com.promineotech.runningShoeApi.repository.UserRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository repo;
	
	@Autowired
	private ShoeRepository shoeRepo;
	
	@Autowired
	private UserRepository userRepo;

	
	//should it just be if shoe doesn't exist, user does not matter
	//use for category create
	public Rating createRating(Rating rating, Long userId, Long shoeId) {
		User user = userRepo.findById(userId).orElseThrow();
		Shoe shoe = shoeRepo.findById(shoeId).orElseThrow();
		if (user == null || shoe == null) {
			throw new RuntimeException("User or shoe does not exist.");
		}
		rating.setUser(user);
		rating.setShoe(shoe);
		return repo.save(rating);
	}
	
	public void deleteRating(Long ratingId) {
		repo.deleteById(ratingId);
	}

}
