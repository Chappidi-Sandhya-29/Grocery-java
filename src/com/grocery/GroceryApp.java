package com.grocery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class GroceryApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Groceryservice service=new GroceryServiceImple();
		
		while(true) {
			try {
				
//				Listing all the products
				ArrayList<Products> products=service.getProduct();
				for(Products p:products) {
					System.out.println("id: "+p.getId() +"-Product:" +p.getName()+ "-Rs. "+p.getPrice());
				}
				
//				select the product
				ArrayList<CartItem> cart=new ArrayList<>();
				System.out.println("Enter Product Id: ");
				int id=sc.nextInt();
				
				System.out.println("Enter Prodcut qunatity: ");
				int quantity=sc.nextInt();
				
				for(Products p:products) {
					
					if(p.getId()==id) {
						cart.add(new CartItem(p,quantity));
						System.out.println("Prodcut added into the cart");
						
						
					}
					
				}
				
//				your amount
				double total=0;
				
				for(CartItem cartItem:cart) {
					total += cartItem.getProduct().getPrice()
							*cartItem.getQuantity();
				}
				
				System.out.println("Your Total Amount:"+total);
				
				System.out.println("1.paper Bag");
				System.out.println("2.Wooden cardBoard");
				System.out.println("3.no need");
				
				System.out.println("Enter your Choice: ");
				
				int bagChoice=sc.nextInt();
				
				String bagType="";
				
				if(bagChoice==1) {
					bagType="paper bag";
					
				}else if(bagChoice==2) {
					bagType="wooden cardboard";
					
				}else {
					bagType="no need";
				}
				
				
				System.out.println("1.UPI");
				System.out.println("2.CARD");
				System.out.println("3.CASH");
				
				System.out.println("Enter your Paymeny Type: ");
				
				int PaymentChoice=sc.nextInt();
				
				String PaymentType="";
				
				if(PaymentChoice==1) {
					PaymentType="UPI";
					
				}else if(PaymentChoice==2) {
					PaymentType="CARD";
					
				}else {
					PaymentType="CASH";
				}
				
				service.saveOrder(total, bagType, PaymentType);
				
				
				System.out.println("Payment Sucessfull "+ total);
				System.out.println("ThankYou! plese visit Again");
				
				
				
			}
			
			
			
			
			catch(SQLException e){
				throw new RuntimeException(e);
				
			}
		}

	}

}
