package com.telusko.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.model.Categories;

public interface CategoryRepo extends JpaRepository<Categories,Integer>{

	
	
	
}
