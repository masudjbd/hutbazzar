package com.bangla.store.domain;

import com.bangla.store.domain.Customer;
import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = -3560539622417210365L;

	private Long orderId;
	private Cart cart;
	private Customer customer;
	private ShippingDetail shippingDetail;

	public Order() {
		this.customer = new Customer();
		this.shippingDetail = new ShippingDetail();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShippingDetail getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(ShippingDetail shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

	// add getters and setters for all the fields here.
	// Override equals and hashCode based on orderId field.
	// the code for the same is available in the code bundle
	// which can be downloaded from www.packtpub.com/support
}