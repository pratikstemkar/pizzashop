package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.entities.Item;
import com.shop.utils.DBUtil;

public class MenuDAO implements AutoCloseable {
	private Connection connection;
	
	public MenuDAO() throws SQLException {
		connection = DBUtil.getConnection();
	}
	
	@Override
	public void close() throws SQLException {
		if(connection != null)
			connection.close();
	}
	
	public void fetchTypes() throws SQLException {
		String query = "SELECT DISTINCT(Type) FROM PIZZA_ITEMS";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			System.out.println("Pizza Types: ");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
	}
	
	public void fetchItems(String type) throws SQLException {
		String query = "SELECT * FROM PIZZA_ITEMS WHERE Type = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1,  type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Item i = new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				System.out.println(i);
			}
		}
	}
	
	public void fetchSizes(int itemId) throws SQLException {
		String query = "SELECT PIZZA_PRICING.SIZES FROM PIZZA_ITEMS, PIZZA_PRICING WHERE PIZZA_ITEMS.id = PIZZA_PRICING.ITEMID AND PIZZA_ITEMS.id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1,  itemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
	}
}
