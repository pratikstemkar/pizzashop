package com.shop.pizza;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shop.entities.ItemPrice;

public class Shop {
	private static int AuthMenu(Scanner sc) {
		System.out.println("0. EXIT");
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	private static int CustomerMenu(Scanner sc) {
		System.out.println("1. Show Veg Items");
		System.out.println("2. Show Non-Veg Items");
		System.out.println("3. Show Available Sizes");
		System.out.println("4. Add to Cart");
		System.out.println("5. Show Cart");
		System.out.println("6. Place Order");
		System.out.println("7. Sign Out");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	private static int AdminMenu(Scanner sc) {
		System.out.println("1. Show All Orders");
		System.out.println("2. Show Order Details");
		System.out.println("3. Sign Out");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Pizza Shop!");
		int authChoice, adminChoice, customerChoice;
		int authStatus;
		List<ItemPrice> cart = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Operations op = new Operations();
		
		try {
			while((authChoice = AuthMenu(sc)) != 0) {
				switch(authChoice) {
				case 1:
				{
					authStatus = op.signIn(sc);
					if(authStatus == 1) {
						while((adminChoice = AdminMenu(sc)) != 3) {
							switch(adminChoice) {
							case 1:
								op.getOrders();
								break;
							case 2:
								op.getOrderDetails(sc);
								break;
							default:
								System.out.println("Wrong Choice. Try Again!");
								break;
							}
						}
						System.out.println("Admin Signed Out!");
					} else if(authStatus != -1) {
						while((customerChoice = CustomerMenu(sc)) != 7) {
							switch(customerChoice) {
							case 1:
								op.getItems("Veg");
								break;
							case 2:
								op.getItems("NonVeg");
								break;
							case 3:
								op.getSizes(sc);
								break;
							case 4:
								cart.add(op.getItemPrice(sc));
								break;
							case 5:
								op.getCart(cart);
								break;
							case 6:
								op.addOrder(authStatus, cart);
								break;
							default:
								System.out.println("Wrong Choice. Try Again!");
								break;
							}
						}
						System.out.println("Customer Signed Out!");
					} else {
						System.out.println("Sign In Failed!");
					}
				}
					break;
				case 2:
					op.signUp(sc);
					break;
				default:
					System.out.println("Wrong Choice. Try Again!");
					break;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thank You for visiting!");
	}
}
