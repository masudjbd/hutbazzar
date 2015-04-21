package com.packt.webstore.domain.repository;

import com.bangla.store.domain.Cart;

public interface CartRepository {
	Cart create(Cart cart);

	Cart read(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);
}
