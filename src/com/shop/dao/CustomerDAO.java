package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shop.entities.Customer;
import com.shop.utils.DBUtil;

public class CustomerDAO implements AutoCloseable {
	private Connection connection;
	
	public CustomerDAO() throws SQLException {
		connection = DBUtil.getConnection();
	}
	
	@Override
	public void close() throws SQLException {
		if(connection != null)
			connection.close();
	}
	
	public void addCustomer(Customer c) throws SQLException {
		String query = "INSERT INTO PIZZA_CUSTOMERS(Name, Password, Mobile, Address, Email) values(?, ?, ?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, c.getName());
			ps.setString(2, c.getPassword());
			ps.setString(3,  c.getMobile());
			ps.setString(4,  c.getAddress());
			ps.setString(5,  c.getEmail());
			ps.executeUpdate();
		}
	}
}
