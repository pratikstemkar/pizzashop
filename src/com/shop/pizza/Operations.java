package com.shop.pizza;

import java.sql.SQLException;
import java.util.Scanner;

import com.shop.dao.AuthDAO;
import com.shop.dao.MenuDAO;
import com.shop.entities.Customer;

public class Operations {
	public String signIn(Scanner sc) throws SQLException {
		String email, password;
		System.out.print("Enter Email: ");
		email = sc.next();
		System.out.print("Enter Password: ");
		password = sc.next();
		try(AuthDAO adao = new AuthDAO()) {
			Customer c = adao.signIn(email, password);
			if(c == null) {
//				System.out.println("Sign In Unsuccessful!");
				return "FAIL";
			} else {
				System.out.println("Sign In Successfull!");
				if(c.getName().equals("admin") && c.getEmail().equals("admin@sunbeaminfo.com"))
					return "ADMIN";
				else
					return "CUSTOMER";
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
	
	public void getSizes(Scanner sc) throws SQLException {
		int itemId;
		System.out.print("Enter Item ID: ");
		itemId = sc.nextInt();
		try(MenuDAO mdao = new MenuDAO()) {
			mdao.fetchSizes(itemId);
		}
	}
}
