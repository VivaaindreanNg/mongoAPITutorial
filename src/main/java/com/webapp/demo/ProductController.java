package com.webapp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.model.Product;
import com.webapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productServe;
	
	private final String ENDPOINT_LIST_ALL = "/product";
	private final String ENDPOINT_INSERT = "/product";
	private final String ENDPOINT_GET_BY_ID = "/product/{id}";
	private final String ENDPOINT_DELETE_BY_ID = "/delete/{id}";
	private final String ENDPOINT_UPDATE_BY_ID = "/update/{id}";
	
	@GetMapping(ENDPOINT_LIST_ALL)
	public List<Product> retrieveAll() {
		return productServe.getAllProduct();
	}
	
	@PostMapping(ENDPOINT_INSERT)
	public Product create(@RequestBody Product payload) {
		return productServe.addProduct(payload);
	}
	
	@GetMapping(ENDPOINT_GET_BY_ID)
	public Product retrieveOne(@PathVariable String id) {
		return productServe.getById(id);
	}
	
	@DeleteMapping(ENDPOINT_DELETE_BY_ID)
	public Product delete(@PathVariable String id) {
		return productServe.deleteById(id);
	}
	

	@PutMapping(ENDPOINT_UPDATE_BY_ID)
	public Product update(
			@PathVariable String id,
			@RequestParam String productName,
			@RequestParam float productPrice) {
		
		return productServe.updateById(id, productName, productPrice);
	}
	
	
	@GetMapping("/productsByPriceDesc")
	public List<Product> getProductsPriceByDesc() {
		return productServe.listProductPriceByDesc();
	}
	
	@GetMapping("/productsPriceMoreThan/{price}")
	public List<Product> getProductsPriceMoreThan(@PathVariable float price) {
		return productServe.listProductPriceMoreThan(price);
	}
}
