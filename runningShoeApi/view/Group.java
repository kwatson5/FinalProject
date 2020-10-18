package com.promineotech.runningShoeApi.view;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.promineotech.runningShoeApi.entity.Category;
import com.promineotech.runningShoeApi.entity.Shoe;

@Entity
public class Group

{
	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	Category category;
	
	@ManyToOne
	@JoinColumn(name="shoeId")
	Shoe shoe;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Shoe getShoe() {
		return shoe;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}
	
	
	
	//private Set<Shoe> shoes;
	
	//public Shoes(Category category) {
	//	shoes=category.getShoes();
	//}

	//public Set<Shoe> getShoes() {
	//	return shoes;
	//}

	//public void setShoes(Set<Shoe> shoes) {
	//	this.shoes = shoes;
	//}

}
