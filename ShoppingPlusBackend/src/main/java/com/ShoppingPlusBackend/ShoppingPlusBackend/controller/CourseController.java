package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.CourseRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.CourseModel;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")

public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/course")
	public List<CourseModel> getAllEmployees(){
		return courseRepository.findAll();
	}		
	
	@PostMapping("/course")
	public CourseModel createEmployee(@RequestBody CourseModel CourseModel) {
		return courseRepository.save(CourseModel);
	}
	

}
