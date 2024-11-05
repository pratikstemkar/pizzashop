package com.shop.entities;

import java.util.Objects;

public class Item {
	private int id;
	private String name;
	private String type;
	private String category;
	private String description;
	
	public Item() {}

	public Item(int id, String name, String type, String category, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category + ", description="
				+ description + "]";
	}
}
