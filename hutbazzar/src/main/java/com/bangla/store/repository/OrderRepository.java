package com.bangla.store.repository;

import com.bangla.store.domain.Order;
/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface OrderRepository {
	Long saveOrder(Order order);
}
