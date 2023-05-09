package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.demo.dao.ProductRepo;
import com.telusko.demo.model.Categories;
import com.telusko.demo.model.Products;

@RequestMapping("/api")
@RestController
public class ProductsController {
	
	@Autowired
	ProductRepo pr;
	
	@GetMapping("/product/page")
	public List<Products> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "I")int size){
		Page<Products> pagePost = pr.findAll(PageRequest.of(page, size));
		List<Products> allPost = pagePost.getContent();
		return allPost;
	} 
	
	@GetMapping("/products")
	public List<Products> getProducts(){
		
		return (List<Products>)pr.findAll();
	}
	@PostMapping("/product")
	public Products addProduct(Products product) {
		
		pr.save(product);		
		return product;	
	}
	@GetMapping("/products/{id}")
	public Products addProduct(@PathVariable int p_id) {
		
		Products product = pr.findById(p_id).orElse(new Products());
		return product;
	}
	@PutMapping("/products/{id}")
	public Products updateProduct(@RequestBody Products product,@PathVariable int p_id) {
		
		pr.save(product);
		return product;
	} 
	@DeleteMapping("/products/{id}")
	public Products deleteProduct(@PathVariable int p_id) {
		
		Products product = pr.findById(p_id).orElse(new Products());
		pr.delete(product);
		return product;
	}
		
}
