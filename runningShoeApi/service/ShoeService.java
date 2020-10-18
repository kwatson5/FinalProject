package com.promineotech.runningShoeApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.runningShoeApi.entity.Shoe;
import com.promineotech.runningShoeApi.entity.User;
import com.promineotech.runningShoeApi.repository.ShoeRepository;
import com.promineotech.runningShoeApi.repository.UserRepository;
import com.promineotech.runningShoeApi.util.RunnerStatus;

@Service
public class ShoeService {
	
	@Autowired
	private ShoeRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Iterable<Shoe> getAllShoes() {
		return repo.findAll();
	}
	
	public Shoe getShoe(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public Shoe createShoe(Shoe shoe, Long userId) throws Exception {
		User foundUser = userRepo.findById(userId).orElseThrow();
		if(foundUser == null) {
			throw new RuntimeException("User not found.");
		} else if(foundUser.getStatus() !=RunnerStatus.ADMIN) {
			throw new Exception("Only admin can add shoe.");
		}
		return repo.save(shoe);
	}
	
	public Shoe updateShoe(Shoe shoe, Long shoeId, Long userId) {
		User foundUser = userRepo.findById(userId).orElseThrow();
		Shoe foundShoe = repo.findById(shoeId).orElseThrow();
		if(foundUser.getStatus() !=RunnerStatus.ADMIN) {
			throw new RuntimeException("Only Admin can update shoe.");
		}
		if (foundShoe == null) {
			throw new RuntimeException("Shoe not found.");
		}
		foundShoe.setBrand(shoe.getBrand());
		foundShoe.setModel(shoe.getModel());
		foundShoe.setPrice(shoe.getPrice());
		foundShoe.setWeight(shoe.getWeight());
		foundShoe.setDrop(shoe.getDrop());
		foundShoe.setModel(shoe.getModel());
		return repo.save(foundShoe);
		}
	
	public void deleteShoe(Long shoeId) {
		repo.deleteById(shoeId);
	}

}

