package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Cart;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findByCustomer(Customer customer);

	Cart findByCustomerAndOrderId(Customer customer, String orderId);

}

