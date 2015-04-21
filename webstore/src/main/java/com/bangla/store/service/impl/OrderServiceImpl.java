package com.bangla.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangla.store.domain.Order;
import com.bangla.store.domain.Product;
import com.bangla.store.domain.repository.OrderRepository;
import com.bangla.store.domain.repository.ProductRepository;
import com.bangla.store.service.CartService;
import com.bangla.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartService cartService;

	public void processOrder(String productId, long quantity) {
		Product productById = productRepository.getProductById(productId);
		if (productById.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException(
					"Out of Stock. Available Units in stock"
							+ productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}

	@Override
	public void processOrder(String productId, int count) {
		// TODO Auto-generated method stub

	}

	public Long saveOrder(Order order) {
		Long orderId = orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		return orderId;
	}
}