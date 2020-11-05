package com.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.model.Product;
import com.webapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	//Create
	public Product addProduct(Product payload) {
		return productRepo.save(payload);
	}
	
	//Retrieve
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}
	
	//Retrieve by ID
	public Product getById(String productID) {
		return productRepo.findById(productID).get();
	}
	
	//Delete product by ID
	public Product deleteById(String productID) {
		Product p = productRepo.findById(productID).get();
		productRepo.deleteById(productID);
		return p;
	}
	
	//Update product by ID
	public Product updateById(
			String productID, 
			String productName,
			float productPrice) {
		
		Product pTarget = productRepo.findById(productID).get();
		pTarget.setProductName(productName);
		pTarget.setProductPrice(productPrice);
		
		productRepo.save(pTarget);
		return pTarget;
	}
	
	public List<Product> listProductPriceByDesc() {
		return productRepo.findAllByOrderByProductPriceDesc();
	}
	
	public List<Product> listProductPriceMoreThan(float price) {
		return productRepo.findByProductPriceGreaterThan(price);
	}
}
