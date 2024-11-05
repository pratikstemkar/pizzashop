package com.shop.entities;

import java.util.Objects;

public class OrderDetails {
	private int id;
	private int OrderId;
	private int priceId;
	
	public OrderDetails() {}

	public OrderDetails(int id, int orderId, int priceId) {
		this.id = id;
		OrderId = orderId;
		this.priceId = priceId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(OrderId, id, priceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return OrderId == other.OrderId && id == other.id && priceId == other.priceId;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", OrderId=" + OrderId + ", priceId=" + priceId + "]";
	}
}
