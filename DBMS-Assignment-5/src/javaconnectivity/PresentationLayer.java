package javaconnectivity;

import java.sql.SQLException;
import java.util.*;
/**
 * Main class
 * @author Mahendar Singh
 */
public class PresentationLayer {

	public static void main(String s[]){
		
		DataLayer dl=new DataLayer();
		dl.setDriver("com.mysql.jdbc.Driver") ;
        dl.setConnection("jdbc:mysql://localhost:3306/store_front","root","admin");
        
		BusinessLayer bl=new BusinessLayer();
		
		//fetching order details and printing them
		List<Orders> orderList = new ArrayList<>();
		try {
			orderList = bl.fetchOrderDetails(dl,2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Order id \t order date \t total price");
		for(int index = 0; index < orderList.size(); index++){
			System.out.println(orderList.get(index).getOrderId()
					+" \t " +  orderList.get(index).getOrderDate()
					+" \t " +  orderList.get(index).getOrderTotalPrice());
		}
		
		//inserting images
		try {
			bl.insertIntoImage(dl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println("images added sucessfully\n");
		
        //deleting products
        try {
			System.out.println(bl.UpdateProduct(dl));
		} catch (SQLException e) {
			e.printStackTrace();
		}

        //fetching top category and printing them
        List<Category> categoryList = new ArrayList<>();
		try {
			categoryList = bl.getTopCategory(dl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Top category \t\t number of items");
		for(int index = 0; index < orderList.size(); index++){
			System.out.println(categoryList.get(index).getTopCategoryName()
					+" \t\t " +  categoryList.get(index).getNumberOfChildren());
		}
		
	}
}
