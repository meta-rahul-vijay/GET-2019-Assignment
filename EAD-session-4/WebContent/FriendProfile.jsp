<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Profile</title>
<link rel='stylesheet' type='text/css' href='/EAD-session-4/style.css'>
</head>
<body>
	<div id="emp-update" align="center">
            <h2 align="center"><%= request.getAttribute("fullName") %> Details</h2><br />
            <table align="center">
                <tr>
                    <td>Full Name</td>
                    <td><label name="ename""><%= request.getAttribute("fullName") %></label>
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    
                    <td><label name="egender""><%= request.getAttribute("gender") %></label></td>
                </tr>
                <tr>
                    <td>Email Id</td>
                    <td><label name="eemail""><%= request.getAttribute("email") %></label></td>
                </tr>
                <tr>
                    <td>Contact Number</td>
                    <td><label name="econtact""><%= request.getAttribute("contact") %></label></td>
                </tr>
                <tr>
                    <td>Organization</td>
                    <td>
						<label name="eorganization""><%= request.getAttribute("organization") %></label>
                    </td>
                </tr>      
                <tr>
                    <td colspan="2" align="center"><a style="font-size:150%" href="HomePage.jsp">Back to Home</a></td>
                </tr>
            </table>
        </form>
    </div>
    <br />
</body>
</html>