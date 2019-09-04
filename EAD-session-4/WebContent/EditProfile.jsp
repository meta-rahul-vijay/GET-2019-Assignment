<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update details</title>
<link rel='stylesheet' type='text/css' href='/EAD-session-4/style.css'>
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<div id="emp-update" align="center">
        <form action="EditProfileServlet"  onsubmit="return updateEmployee();" method="post">
            <h2 align="center">Update Details</h2><br />
            <table align="center">
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" name="ename" value="<%= request.getAttribute("fullName") %>"><br><label name="enamev"></label>
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <%	
                    	boolean male=false,female=false;
                    	if((request.getAttribute("gender").toString()).equals("Male"))
                    		male=true;
                    	else
                    		female=true;
                    %>
                    <td><input type="radio" name="egender" value="Male" checked=<%=male %>>&nbspMale&nbsp&nbsp<input type="radio"
                            name="egender" value="Female" >&nbspFemale<br><label name="egenderv"></label></td>
                </tr>
                <tr>
                    <td>Email Id</td>
                    <td><input type="email" name="eemail" type="email" value=<%= request.getAttribute("email") %> readonly><br><label
                            name="eemailv"></label></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="Password" name="epass" value=<%= request.getAttribute("password") %>><br><label
                            name="epassv"></label></td>
                </tr>
                <tr>
                    <td>Contact Number</td>
                    <td><input type="text" name="ecnumber" value=<%= request.getAttribute("contact") %>><br><label
                            name="ecnumberv"></label></td>
                </tr>
                <tr>
                    <td>Select organization</td>
                    <td>
						<select width="40" id="organization" name="eorganization">
                            <option value="<%= request.getAttribute("organization") %>" ><%= request.getAttribute("organization") %></option>
                            <option value="Metacube software pvt ltd.">Metacube software pvt ltd.</option>
                            <option value="Infosys Tech pvt ltd.">Infosys Tech pvt ltd.</option>
                            <option value="TCS">TCS</option>
                            <option value="Amazon">Amazon</option>
                        </select><br>
						<span name="eorganizationv"></span>
                    </td>
                </tr>      
                <tr>
                    <td align="center"><input type="submit" value="Update"></td>
                    <td align="center"><a href="HomePage.jsp">Back</a></td>
                </tr>
            </table>
        </form>
    </div>
    <br />
</body>
</html>