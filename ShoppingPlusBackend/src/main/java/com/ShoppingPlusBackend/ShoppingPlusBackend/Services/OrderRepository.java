package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByCustomerId(String customerId);

}
