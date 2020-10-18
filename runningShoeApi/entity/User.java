package com.promineotech.runningShoeApi.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.promineotech.runningShoeApi.util.RunSurface;
import com.promineotech.runningShoeApi.util.RunnerStatus;
import com.promineotech.runningShoeApi.util.SupportType;

@Entity
public class User {
	
	private Long id;
	private String username;
	private String password;
	private RunSurface surface; 
	private SupportType support; 
	private RunnerStatus status;
	
	//@JsonIgnore
	//private Set<Shoe> shoes;
	
	@JsonIgnore
	private Set<Shoe> shoes;

	//@JsonIgnore
	private Set<Review> reviews;
	
	//@JsonIgnore
	private Set<Rating> ratings;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public RunSurface getSurface() {
		return surface;
	}

	public void setSurface(RunSurface surface) {
		this.surface = surface;
	}

	public SupportType getSupport() {
		return support;
	}

	public void setSupport(SupportType support) {
		this.support = support;
	}
	
	//@OneToMany(mappedBy = "user")
	//public Set<Shoe> getShoes() {
	//	return shoes;
	//}

	//public void setShoes(Set<Shoe> shoes) {
	//	this.shoes = shoes;
	//}

	@OneToMany(mappedBy = "user")
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(mappedBy = "user")
	public Set<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public RunnerStatus getStatus() {
		return status;
	}

	public void setStatus(RunnerStatus status) {
		this.status = status;
	}
	

}
