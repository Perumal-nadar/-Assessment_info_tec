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

import com.telusko.demo.dao.CategoryRepo;
import com.telusko.demo.model.Categories;

@RequestMapping("/api")
@RestController
public class CategoriesController {
	
	@Autowired
	CategoryRepo cr;
	
	@GetMapping("/product/page")
	public List<Categories> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "I")int size){
		Page<Categories> pagePost = cr.findAll(PageRequest.of(page, size));
		List<Categories> allPost = pagePost.getContent();
		return allPost;
	} 
	
	@GetMapping(path="/categories")
	public List<Categories> getCategories() {
		return (List<Categories>) cr.findAll();
	}
	@PostMapping("/categories")
	public Categories addCategories(@RequestBody Categories ctg)
	{
		cr.save(ctg);
		return ctg;	
	}
	@GetMapping("/categories/{id}")
	public Categories getCategory(@PathVariable int c_id) {

		Categories ctg = cr.findById(c_id).orElse(new Categories());
		return ctg;		
	}
	@PutMapping("/categories/{id}")
	public Categories updateCategory(@RequestBody Categories ctg ,@PathVariable int c_id) {
		cr.save(ctg);
		return  ctg;	
	}
	@DeleteMapping("/categories/{id}")
	public Categories deleteCategory(@PathVariable int c_id) {
		
		Categories ctg = cr.findById(c_id).orElse(new Categories());
		cr.delete(ctg);
		return ctg;
		
	}
	
}
