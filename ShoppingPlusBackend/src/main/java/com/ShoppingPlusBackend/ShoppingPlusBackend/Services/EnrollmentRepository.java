package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	
}
