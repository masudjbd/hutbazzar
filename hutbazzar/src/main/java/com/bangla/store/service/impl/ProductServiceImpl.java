package com.bangla.store.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangla.store.domain.Product;
import com.bangla.store.repository.ProductRepository;
import com.bangla.store.service.ProductService;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
//        @Autowired
//        private SessionFactory sf;


	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	@Override
	public Set<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		List<Product> productsByManufacturer = new ArrayList<Product>();
		for (Product product : productRepository.getAllProducts()) {
			if (manufacturer.equalsIgnoreCase(product.getCategory().getCategoryName())) {
				productsByManufacturer.add(product);
			}
		}
		return productsByManufacturer;
	}

	@Override @Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}
}