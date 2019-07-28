package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;
import com.google.gson.Gson;


@RestController
public class AggregatorController {

	@Autowired
	ProductService productService;

	@PostMapping("/saveProducts")
	public String nonProducts(@RequestBody Map<String, List<Product>> productMap) {
		productService.saveProducts(productMap);
		return "products";
	}
	

	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable Integer id) {
		return productService.updateProductWithID(product, id);
	}

	
	@GetMapping(value = "/products")
	public Iterable<Product> getAllProducts() {
		return productService.getAllProduct();
	}
	
	
	@GetMapping(value = "/productsByDate/{dateInput}")
	public String getAllProductsByDate(@PathVariable String dateInput) {
		Map<String, List<Product>> productsByUpdatedStatus = productService.getAllProductsByDate(dateInput);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(productsByUpdatedStatus);
		return jsonStr;
	}
	
}
