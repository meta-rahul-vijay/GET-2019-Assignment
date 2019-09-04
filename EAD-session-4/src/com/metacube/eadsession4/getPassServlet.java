package com.metacube.eadsession4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * servlet to submit details of pass choosen
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class getPassServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out= response.getWriter();
		BusinessLayer bl =new BusinessLayer();
		 
		HttpSession session = request.getSession();
		
		String passType=request.getParameter("passtype");
		String vehicleType=(String) session.getAttribute("vtype");
		String vehicleNumber=(String) session.getAttribute("vnumber");
		int empId=Integer.parseInt(session.getAttribute("empId").toString());
		
	    float daily = (float) (5/71.4);
	    float monthly = (float) (100/71.4);
	    float yearly = (float) (500/71.4);

	    if (vehicleType.equals("Motocycle")) {
	        daily = (float) (10/71.4);
	        monthly = (float) (200/71.4);
	        yearly = (float) (1000/71.4);
	    } else if (vehicleType.equals("Car")) {
	        daily = (float) (20/71.4);
	        monthly = (float) (500/71.4);
	        yearly = (float) (3500/71.4);
	    }
	    
	    float price=daily;
	    
	    if(passType.equals("monthly")){
	    	price= monthly;
	    }else if(passType.equals("yearly")){
	    	price= yearly;
	    }
		try {
			bl.insertIntoPlan(empId,vehicleNumber,passType,price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print(Variables.upperBody);
		out.println("<p style='font-size:140%'>Plan choosen successfully ,  please <a href='HomePage.jsp'>click here </a> to go to homepage</p>");
		out.print(Variables.lowerBody);
		
	}

}
