package com.bangla.store.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bangla.store.domain.Product;
/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(String productID);

	List<Product> getProductsByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	List <Product> getProductsByManufacturer(String manufacturer);
	
	void addProduct(Product product);
}
