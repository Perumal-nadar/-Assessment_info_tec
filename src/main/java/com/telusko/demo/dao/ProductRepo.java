package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.model.Products;

public interface ProductRepo extends JpaRepository<Products,Integer>{

}
