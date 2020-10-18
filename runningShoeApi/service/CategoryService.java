package com.promineotech.runningShoeApi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.runningShoeApi.entity.Category;
import com.promineotech.runningShoeApi.entity.Rating;
import com.promineotech.runningShoeApi.entity.Shoe;
import com.promineotech.runningShoeApi.entity.User;
import com.promineotech.runningShoeApi.repository.CategoryRepository;
import com.promineotech.runningShoeApi.repository.ShoeRepository;
import com.promineotech.runningShoeApi.repository.UserRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	@Autowired
	private ShoeRepository shoeRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//public Iterable<Category> getCategories() {
	//	return repo.findAll();
	//}
	
	//public Category getCategory(Long id) {
	//	return repo.findById(id).orElseThrow();
	//}
	
	//public void addCategoryToShoe(Category category) {
	//	Set<Shoe> shoes = category.getShoes();
	//	for (Shoe shoe : shoes)  {
	//		shoe.getCategories().add(category);
	//	}
	//}
	
	//public Set<Shoe> convertToShoeSet(Iterable<Shoe> iterable) {
	//	Set<Shoe> set = new HashSet<Shoe>();
	//	for (Shoe shoe : iterable) {
	//		set.add(shoe);
	//	}
	//	return set;
	//}
	
	
	public Category createCategory(Category category, Long userId, Iterable<Long> shoeId) {
		User foundUser = userRepo.findById(userId).orElseThrow();
		Iterable<Shoe> shoes = shoeRepo.findAllById(shoeId);
		if (foundUser == null || shoes == null) {
			throw new RuntimeException("User or shoe does not exist.");
		}
		//category.setUser(user);
		//category.setShoes(shoes);
		return repo.save(category);
	}
	
	public Category updateCategory(Category category, Long id) {
		return repo.save(category);
	}	
}
