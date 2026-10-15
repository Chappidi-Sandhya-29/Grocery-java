package com.grocery;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Groceryservice {
	
	ArrayList<Products> getProduct() throws SQLException;
	
	void saveOrder(double price,String bagType,String payment_method) throws SQLException;

}
