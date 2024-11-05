package com.shop.entities;

import java.util.Objects;

public class ItemPrice {
	private int id;
	private int itemId;
	private String sizes;
	private double price;
	
	public ItemPrice() {}

	public ItemPrice(int id, int itemId, String sizes, double price) {
		this.id = id;
		this.itemId = itemId;
		this.sizes = sizes;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, price, sizes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPrice other = (ItemPrice) obj;
		return id == other.id && itemId == other.itemId
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(sizes, other.sizes);
	}

	@Override
	public String toString() {
		return "ItemPrice [id=" + id + ", itemId=" + itemId + ", sizes=" + sizes + ", price=" + price + "]";
	}
}
