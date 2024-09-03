package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.MentorModel;


@Repository
public interface MentorRepository extends JpaRepository<MentorModel, Long>{


}