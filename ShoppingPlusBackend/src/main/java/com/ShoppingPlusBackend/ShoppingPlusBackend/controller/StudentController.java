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

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.StudentRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.exception.ResourceNotFoundException;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.StudentModel;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")

public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/student")
	public List<StudentModel> getAllEmployees(){
		return studentRepository.findAll();
	}		
	
	
	@PostMapping("/student")
	public StudentModel createEmployee(@RequestBody StudentModel StudentModel) {
		return studentRepository.save(StudentModel);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<StudentModel> updateEmployee(@PathVariable Long id, @RequestBody StudentModel StudentModelDetails){
		StudentModel studentModel = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		studentModel.setFirstName(StudentModelDetails.getFirstName());
		studentModel.setLastName(StudentModelDetails.getLastName());
		studentModel.setEmailId(StudentModelDetails.getEmailId());
		
		StudentModel updatedStudent = studentRepository.save(studentModel);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		StudentModel studentModel = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		studentRepository.delete(studentModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
