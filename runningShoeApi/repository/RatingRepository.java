package com.promineotech.runningShoeApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.runningShoeApi.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{

}
