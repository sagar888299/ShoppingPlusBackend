package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.OrderRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Order;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<List<Order>> createOrders(@RequestBody List<Order> orders) {
        List<Order> savedOrders = orderRepository.saveAll(orders);
        return ResponseEntity.ok(savedOrders);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable String customerId) {
        // Assuming there is a way to find orders by customerId. If not, you should adjust the repository or service.
        List<Order> order = orderRepository.findByCustomerId(customerId);
        return ResponseEntity.ok(order);
    }
    
    @PatchMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus("Cancelled"); // Update the status to "Cancelled"
            Order updatedOrder = orderRepository.save(order); // Save the updated order
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
