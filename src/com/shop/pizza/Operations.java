package com.shop.pizza;

import java.sql.SQLException;
import java.util.Scanner;

import com.shop.dao.CustomerDAO;
import com.shop.entities.Customer;

public class Operations {
	public void addCustomer(Scanner sc) throws SQLException {
		Customer c = new Customer();
		c.accept(sc);
		
		try(CustomerDAO cdao = new CustomerDAO()) {
			cdao.addCustomer(c);
		}
	}
}
