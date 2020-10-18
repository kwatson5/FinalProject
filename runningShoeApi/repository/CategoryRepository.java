package com.promineotech.runningShoeApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.runningShoeApi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
