package com.promineotech.runningShoeApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.runningShoeApi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
