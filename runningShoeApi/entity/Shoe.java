package com.promineotech.runningShoeApi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.runningShoeApi.view.Group;


@Entity
public class Shoe {
	
	private Long id;
	private String brand;
	private String model;
	private double price;
	private double weight; // in ounces
	private double drop; // in mm
	private String shoePictureUrl;
	private Set<Review> reviews;
	private Set<Category> categories;
	private Set<Rating> ratings;
	
	@JsonIgnore
	private Set<Group> groups;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getDrop() {
		return drop;
	}
	
	public void setDrop(double drop) {
		this.drop = drop;
	}
	
	public String getShoePictureUrl() {
		return shoePictureUrl;
	}
	
	public void setShoePictureUrl(String shoePictureUrl) {
		this.shoePictureUrl = shoePictureUrl;
	}
	
	@OneToMany(mappedBy = "shoe")
	public Set<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	//@OneToMany(mappedBy = "shoes")
	//public Set<Group> getGroups() {
	//	return groups;
	//}
	
	//@ManyToMany(mappedBy = "shoes")
	//public Set<Group> getGroups() {
	//	return groups;
	//}
	
	//public void setGroup(Set<Group> groups) {
	//	this.groups = groups;
	//}
	
	@ManyToMany(mappedBy = "shoes")
	public Set<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	@OneToMany(mappedBy = "shoe")
	public Set<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

}
