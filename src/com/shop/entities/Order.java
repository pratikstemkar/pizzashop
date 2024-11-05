package com.shop.entities;

import java.util.Date;
import java.util.Objects;

public class Order {
	private int id;
	private int customerId;
	private Date orderTime;
	private String status;
	
	public Order() {}

	public Order(int id, int customerId, Date orderTime, String status) {
		this.id = id;
		this.customerId = customerId;
		this.orderTime = orderTime;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, orderTime, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return customerId == other.customerId && id == other.id && Objects.equals(orderTime, other.orderTime)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", orderTime=" + orderTime + ", status=" + status
				+ "]";
	}
}
