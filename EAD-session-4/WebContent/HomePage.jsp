<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<div id="main-head">
        <h1 align="center">Babbar Parking System</h1><br />
    </div>
 	<div style="font-size:130%;margin-left:3%">
	    <p>Welcome <%= session.getAttribute("email") %></p><br>
		<a href = "EditProfileServlet">Edit profile</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href = "FriendServlet">Friends</a>	
		<a style="float:right;margin-right:10%" href = "LogOutServlet">Logout</a>
	</div>
</body>
</html>