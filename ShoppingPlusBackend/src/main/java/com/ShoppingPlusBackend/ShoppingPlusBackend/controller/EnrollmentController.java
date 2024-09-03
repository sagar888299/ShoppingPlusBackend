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
import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.EnrollmentRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.StudentRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.CourseModel;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Enrollment;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.StudentModel;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class EnrollmentController {
     @Autowired
	 private EnrollmentRepository enrollmentRepository ;
     @Autowired
     private StudentRepository studentRepository ;
     @Autowired
     private CourseRepository courseRepository ;
	    
	    @GetMapping("/enroll")
	    public List<Enrollment> getAllEnrollments() {
	        return enrollmentRepository.findAll();
	    }
	    @PostMapping("/enroll")
	    public Enrollment saveEnrollment( @RequestBody EnrollmentRequest enrollmentRequest) {
	    	System.out.println(enrollmentRequest);
	    	Long studentId = enrollmentRequest.getStudentId();
	        Long courseId = enrollmentRequest.getCourseId();

	        // Fetch the student and course from the repository
	        StudentModel student = studentRepository.findById(studentId).orElseThrow();
	        CourseModel course = courseRepository.findById(courseId).orElseThrow();

	        // Create a new Enrollment object
	        Enrollment enrollment = new Enrollment();
	        enrollment.setStudent(student);
	        enrollment.setCourse(course);

	        // Save the enrollment
	        return enrollmentRepository.save(enrollment);
	    }
}
