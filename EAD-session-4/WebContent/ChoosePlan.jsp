<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Plans</title>
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	
	<div style="margin-left: 42%;id="pricing">
        <form action="getPass" onsubmit="return setPricing()">
            <h2>Choose your plan</h2><br>
            <label id="veh-type">Pricing available for <%= session.getAttribute("vtype") %></label><br />
            Select currency&nbsp;&nbsp;
            <select id="currency" onchange="showPrice()">
                <option value="" selected disabled hidden>Choose here</option>
                <option value="INR">INR</option>
                <option value="USD">USD</option>
                <option value="YEN">YEN</option>
            </select><br><label name="currencyv"></label><br />
            <div align="left" style="display: none" id="plans"><label name="plansv"></label><br>
                <input type="radio" name="passtype" value="daily">&nbsp;Daily - <label id="daily"></label><br />
                <input type="radio" name="passtype" value="monthly">&nbsp;Monthly - <label id="monthly"></label><br />
                <input type="radio" name="passtype" value="yearly">&nbsp;Yearly - <label id="yearly"></label><br><br />
            </div>
      
            <input style="margin-left: 10%" type="submit" value="Get Pass">
        </form>
    </div>
	
	
</body>
</html>