package com.promineotech.runningShoeApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.runningShoeApi.entity.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe, Long >{

}
