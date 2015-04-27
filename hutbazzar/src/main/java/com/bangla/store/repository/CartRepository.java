package com.bangla.store.repository;

import com.bangla.store.domain.Cart;
/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
public interface CartRepository {
	Cart create(Cart cart);

	Cart read(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);
}
