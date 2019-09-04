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
 * servlet to register vehicle in database
 * @author Mahendar Singh
 * Dated 09/04/2019
 */
public class RegisterVehicleServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out= response.getWriter();
		BusinessLayer bl =new BusinessLayer();
		
		HttpSession session = request.getSession();
		
		String vehicleName=request.getParameter("vname");
		String vehicleType = request.getParameter("vtype");
		String vehicleNumber = request.getParameter("vnumber");
		int empId = Integer.parseInt(session.getAttribute("empId").toString());
		String vehicleIdentity = request.getParameter("videntity");
		
		VehiclePojo vehicle = new VehiclePojo(empId, vehicleName, vehicleType, vehicleNumber, vehicleIdentity);
		try {
			bl.insertIntoVehicle(vehicle);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		session.setAttribute("vtype", vehicleType);
		session.setAttribute("vnumber", vehicleNumber);
		response.sendRedirect("ChoosePlan.jsp");
	}

}
