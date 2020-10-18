package com.promineotech.runningShoeApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.runningShoeApi.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
