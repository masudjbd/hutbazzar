package com.packt.webstore.domain.repository;

import com.bangla.store.domain.Order;

public interface OrderRepository {
	Long saveOrder(Order order);
}
