package com.promineotech.runningShoeApi.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.runningShoeApi.view.Group;

@Entity
public class Category {
	
	private Long id;
	private String purpose; // Trainer, Racing, Long, Tempo, Speed 
	

	private Set<Shoe> shoes;
	
	@JsonIgnore
	private User user;
	
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	//@OneToMany(mappedBy="categories")
	//public Set<Group> getGroups() {
	//	return groups;
	//}

	
	//public Set<Group> getGroups() {
	//	return groups;
	//}
	
	//public void setGroup(Set<Group> groups) {
	//	this.groups = groups;
	//}
	
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "group",
			joinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "shoeId", referencedColumnName = "id"))
	public Set<Shoe> getShoes() {
		return shoes;
	}

	public void setShoes(Set<Shoe> shoes) {
		this.shoes = shoes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
}
