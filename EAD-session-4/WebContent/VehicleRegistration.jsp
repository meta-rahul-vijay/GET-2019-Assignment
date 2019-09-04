<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Register vehicle</title>
<link rel='stylesheet' type='text/css' href='/EAD-session-4/style.css'>
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	 <div id="veh-reg" align="center">
        <form action="registerVehicle" onsubmit="return vehRegister()">
            <h2 align="center">Register Vehicle</h2><br />
            <table align="center">
                <tr>
                    <td>Vehicle Name</td>
                    <td><input type="text" placeholder="enter vehicle name" name="vname"><br /><label
                            name="vnamev"></label></td>
                </tr>
                <tr>
                    <td>Vehicle type</td>
                    <td><select width="40" id="selected-type" name="vtype">
                            <option value="" selected disabled hidden>Choose here</option>
                            <option value="Cycle">Cycle</option>
                            <option value="Motocycle">Motocycle</option>
                            <option value="Car">Car</option>
                        </select><br><label name="vtypev"></label></td>
                </tr>
                <tr>
                    <td>Vehicle number</td>
                    <td><input type="text" placeholder="enter vehicle number" name="vnumber"><br><label
                            name="vnumberv"></label></td>
                </tr>
                <tr>
                    <td>Employee Id</td>
                    <td><input type="text" placeholder="enter your emp id" name="eid" value=<%= session.getAttribute("empId") %> readonly><br><label
                            name="eidv"></label></td>
                </tr>
                <tr>
                    <td>Identification</td>
                    <td><textarea placeholder="enter vehicle Identification" rows="3"
                            name="videntity"></textarea><br><label name="videntityv"></label></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register Vehicle"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>