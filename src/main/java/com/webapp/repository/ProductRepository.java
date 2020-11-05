package com.webapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.webapp.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	public abstract List<Product> findAllByOrderByProductPriceDesc();
	
	public abstract List<Product> findByProductPriceGreaterThan(float price);
}
