package com.bangla.store.service;

import com.bangla.store.domain.Order;
/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface OrderService {
	void processOrder(int productId, int count);
	Long saveOrder(Order order);
}
