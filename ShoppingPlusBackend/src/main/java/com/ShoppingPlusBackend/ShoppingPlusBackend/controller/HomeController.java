package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "Hello From SPRING BOOT JAVA";
	}
}
