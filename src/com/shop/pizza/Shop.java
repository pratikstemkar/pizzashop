package com.shop.pizza;

import java.sql.SQLException;
import java.util.Scanner;

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
		String authStatus;
		Scanner sc = new Scanner(System.in);
		Operations op = new Operations();
		
		try {
			while((authChoice = AuthMenu(sc)) != 0) {
				switch(authChoice) {
				case 1:
				{
					authStatus = op.signIn(sc);
					if(authStatus.equals("ADMIN")) {
						while((adminChoice = AdminMenu(sc)) != 3) {
							switch(adminChoice) {
							
							}
						}
						System.out.println("Admin Signed Out!");
					} else if(authStatus.equals("CUSTOMER")) {
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
								break;
							case 5:
								break;
							case 6:
								break;
							case 7:
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
