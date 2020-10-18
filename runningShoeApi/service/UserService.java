package com.promineotech.runningShoeApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.runningShoeApi.entity.User;
import com.promineotech.runningShoeApi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	//get list of users
	public Iterable<User> getUsers() {
		return repo.findAll();
	}
	
	public User getUserById(Long id) {
		return repo.findById(id).orElseThrow();
	}
	
	public User login(User user) throws Exception {
		User foundUser = repo.findByUsername(user.getUsername());
		if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return foundUser;
		} else {
			throw new Exception("Invalid username or password.");
		}
	}
	
	public User updateUser(User user, Long id) {
		User foundUser = repo.findById(id).orElseThrow();
		if (foundUser == null) {
			throw new RuntimeException("User does not exist.");
		}
		foundUser.setSurface(user.getSurface());
		foundUser.setSupport(user.getSupport());
		foundUser.setStatus(user.getStatus());
		return repo.save(foundUser);
	}
	
	public void deleteUser (Long userId) {
		repo.deleteById(userId);
	}
}
