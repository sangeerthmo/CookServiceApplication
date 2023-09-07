package com.me.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.entity.Cook;


@Repository
public interface CookRepository extends JpaRepository<Cook, Integer> {
	
	

}