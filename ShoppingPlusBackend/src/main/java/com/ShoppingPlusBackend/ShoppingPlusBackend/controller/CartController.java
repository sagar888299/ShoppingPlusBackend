package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.CartRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.CustomerRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Cart;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Add or update cart item
    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateCartItem(@RequestBody CartRequest cartRequest) {
        Customer customer = customerRepository.findById(cartRequest.getPhoneNumber()).orElse(null);
        if (customer == null) {
            return ResponseEntity.badRequest().body("Customer not found");
        }

        Cart existingCartItem = cartRepository.findByCustomerAndOrderId(customer, cartRequest.getOrderId());
        
        if (existingCartItem != null) {
            // Decrease quantity
            if (cartRequest.getQuantity() < 0) {
                int newQuantity = existingCartItem.getQuantity() + cartRequest.getQuantity();
                if (newQuantity <= 0) {
                    cartRepository.delete(existingCartItem);
                    return ResponseEntity.ok("Cart item removed");
                } else {
                    existingCartItem.setQuantity(newQuantity);
                    cartRepository.save(existingCartItem);
                    return ResponseEntity.ok("Cart item quantity decreased");
                }
            }
            // Increase quantity
            else {
                existingCartItem.setQuantity(existingCartItem.getQuantity() + cartRequest.getQuantity());
                cartRepository.save(existingCartItem);
                return ResponseEntity.ok("Cart item quantity updated");
            }
        } else {
            // Add new item
            if (cartRequest.getQuantity() > 0) {
                Cart newCartItem = new Cart(customer, cartRequest.getOrderId(), cartRequest.getQuantity());
                cartRepository.save(newCartItem);
                return ResponseEntity.ok("Cart item added");
            } else {
                return ResponseEntity.badRequest().body("Quantity must be positive for new items");
            }
        }
    }


    // Get all cart items for a customer
    @GetMapping("/get/{phoneNumber}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable String phoneNumber) {
        Customer customer = customerRepository.findById(phoneNumber).orElse(null);
        if (customer == null) {
            return ResponseEntity.badRequest().body(null);
        }
        List<Cart> cartItems = cartRepository.findByCustomer(customer);
        return ResponseEntity.ok(cartItems);
    }

    // Inner class for request payload
    public static class CartRequest {
        private String phoneNumber;
        private String orderId;
        private Integer quantity;

        // Getters and setters

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
