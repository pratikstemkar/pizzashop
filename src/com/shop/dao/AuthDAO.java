package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.entities.Customer;
import com.shop.utils.DBUtil;

public class AuthDAO implements AutoCloseable {
	private Connection connection;
	
	public AuthDAO() throws SQLException {
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
	
	public Customer fetchCustomer(String email) throws SQLException {
		String query = "SELECT * FROM PIZZA_CUSTOMERS WHERE Email = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1,  email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getNString(5), rs.getString(6));
			}
		}
		return null;
	}
	
	public Customer signIn(String email, String password) throws SQLException {
		String query = "SELECT * FROM PIZZA_CUSTOMERS WHERE Email = ? AND password = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1,  email);
			ps.setString(2,  password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getNString(5), rs.getString(6));
			}
		}
		return null;
	}
}
