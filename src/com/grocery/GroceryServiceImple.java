package com.grocery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroceryServiceImple implements Groceryservice{

//	private double total;

	@Override
	public ArrayList<Products> getProduct() throws SQLException {
		ArrayList<Products> products=new ArrayList<>();
		
		Connection conn=DBConnection.getConnection();
		
		PreparedStatement ps=conn.prepareStatement("select * from products");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			int id=rs.getInt("id");
			String name=rs.getString("name");
			double price=rs.getDouble("price");
			int stock=rs.getInt("stock");
			
			Products p=new Products(id,name,price,stock);
			
			products.add(p);
			
			
		}
		conn.close();
		return products;
	}

	@Override
	public void saveOrder(double price, String bagType, String payment_method) throws SQLException {
		
		Connection conn=DBConnection.getConnection();
		
		String query="INSERT INTO orders(total,bag_type,payment_method)values (?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(query);
		
		ps.setDouble(1, price);
		ps.setString(2, bagType);
		ps.setString(3, payment_method);
		
		
		ps.executeUpdate();
		
		ps.close();
		
		conn.close();
		
	}

	
}

