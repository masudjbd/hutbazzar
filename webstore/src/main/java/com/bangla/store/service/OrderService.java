package com.bangla.store.service;

import com.bangla.store.domain.Order;

public interface OrderService {
	void processOrder(String productId, int count);
	Long saveOrder(Order order);
}
