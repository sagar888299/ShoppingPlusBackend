package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long>{

}
