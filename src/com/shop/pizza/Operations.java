package com.shop.pizza;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.shop.dao.AuthDAO;
import com.shop.dao.MenuDAO;
import com.shop.entities.Customer;
import com.shop.entities.ItemPrice;

public class Operations {
	public int signIn(Scanner sc) throws SQLException {
		String email, password;
		System.out.print("Enter Email: ");
		email = sc.next();
		System.out.print("Enter Password: ");
		password = sc.next();
		try(AuthDAO adao = new AuthDAO()) {
			Customer c = adao.signIn(email, password);
			if(c == null) {
				return -1;
			} else {
				if(c.getName().equals("admin") && c.getEmail().equals("admin@sunbeaminfo.com")) {
					System.out.println();
					System.out.println("Logged In as Admin!");
					System.out.println();
					return 1;
				}
				else {
					System.out.println();
					System.out.println("Logged in as " + c.getName());
					System.out.println();
					return c.getId();
				}
			}
		}
	}
	
	public void signUp(Scanner sc) throws SQLException {
		Customer c = new Customer();
		c.accept(sc);
		
		try(AuthDAO adao = new AuthDAO()) {
			adao.addCustomer(c);
		}
	}
	
	public void getTypes() throws SQLException {
		try(MenuDAO mdao = new MenuDAO()) {
			mdao.fetchTypes();
		}
	}
	
	public void getItems(String type) throws SQLException {
		try(MenuDAO mdao = new MenuDAO()) {
			mdao.fetchItems(type);
		}
	}
	
	public int getSizes(Scanner sc) throws SQLException {
		int itemId;
		System.out.print("Enter Item ID: ");
		itemId = sc.nextInt();
		try(MenuDAO mdao = new MenuDAO()) {
			mdao.fetchSizes(itemId);
		}
		return itemId;
	}
	
	private int ItemMenu(Scanner sc) {
		System.out.println("1. Veg Items");
		System.out.println("2. Non-Veg Items");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	public ItemPrice getItemPrice(Scanner sc) throws SQLException {
		int itemChoice, priceId;
		itemChoice = ItemMenu(sc);
		switch(itemChoice) {
			case 1:
			{
				getItems("Veg");
				getSizes(sc);
				System.out.print("Enter Price ID: ");
				priceId = sc.nextInt();
				try(MenuDAO mdao = new MenuDAO()) {
					return mdao.fetchItemPrice(priceId);
				}
			}
			case 2:
			{
				getItems("NonVeg");
				getSizes(sc);
				System.out.print("Enter Price ID: ");
				priceId = sc.nextInt();
				try(MenuDAO mdao = new MenuDAO()) {
					return mdao.fetchItemPrice(priceId);
				}
			}
			default:
				System.out.println("Wrong Choice. Try Again!");
				break;
		}
		System.out.println("Back to previous menu.");
		return null;
	}
	
	public void addOrder(int customerId, List<ItemPrice> cart) throws SQLException {
		if(cart.size() < 1) {
			System.out.println("Cart is Empty!");
			return;
		}
		
		try(MenuDAO mdao = new MenuDAO()) {
			mdao.saveOrder(customerId);
			mdao.saveOrderDetails(cart, customerId);
			System.out.println("Order Placed!");
		}
	}
	
	public void getOrders() throws SQLException {
		System.out.println();
		try(MenuDAO mdao = new MenuDAO()) {
			mdao.fetchOrders();
		}
		System.out.println();
	}
	
	public void getOrderDetails(Scanner sc) throws SQLException {
		int orderId;
		System.out.print("Enter Order ID: ");
		orderId = sc.nextInt();
		System.out.println();
		try(MenuDAO mdao = new MenuDAO()) {
			mdao.fetchOrderDetails(orderId);
		}
		System.out.println();
	}
	
	public void getCart(List<ItemPrice> cart) throws SQLException {
		if(cart.size() < 1) {
			System.out.println("Cart is Empty!");
			return;
		}
		int total = 0;
		for(ItemPrice ip : cart) {
			total += ip.getPrice();
			System.out.println(ip);
		}
		System.out.println("Total Amount: " + total);
	}
}
