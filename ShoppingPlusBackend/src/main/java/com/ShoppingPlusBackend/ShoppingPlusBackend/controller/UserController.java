package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.UserRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.exception.ResourceNotFoundException;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.UserModel;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	

	
	@GetMapping("/user")
	public List<UserModel> getAllUser(){
		return userRepository.findAll();
	}		
	
	@PostMapping("/user")
	public UserModel createUser(@RequestBody UserModel UserModel) {
		return userRepository.save(UserModel);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<UserModel> updateEmployee(@PathVariable Long id, @RequestBody UserModel UserModelDetails){
		UserModel userModel = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		userModel.setFirstName(UserModelDetails.getFirstName());
		userModel.setLastName(UserModelDetails.getLastName());
		userModel.setEmailId(UserModelDetails.getEmailId());
		
		UserModel updatedUser = userRepository.save(userModel);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		UserModel userModel = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		userRepository.delete(userModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}


}
