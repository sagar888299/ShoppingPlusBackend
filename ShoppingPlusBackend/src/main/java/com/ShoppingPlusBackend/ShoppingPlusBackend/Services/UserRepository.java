package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

}