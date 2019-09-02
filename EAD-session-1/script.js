var employeeName, employeeGender, employeeEmail, employeePassword, employeeMatchPassword, employeeNumber;;

var vehicleName, vehicleType, vehicleNumber, employeeId, vehicleIdentity;

var currency, plan;

function passMatch(){

    employeePassword = document.getElementsByName("epass")[0].value;
    employeeMatchPassword = document.getElementsByName("ecnfrmpass")[0].value;
    if (employeePassword != employeeMatchPassword) {
        document.getElementsByName("ecnfrmpassv")[0].innerHTML = "password doesn't match";
    }else{
        document.getElementsByName("ecnfrmpassv")[0].innerHTML = "Password Matched";
    }
}

function empRegister() {

    var valid =true;
    employeeName = document.getElementsByName("ename")[0].value;
    employeeGender = document.getElementsByName("egender");
    employeeEmail = document.getElementsByName("eemail")[0].value;
    employeePassword = document.getElementsByName("epass")[0].value;
    employeeMatchPassword = document.getElementsByName("ecnfrmpass")[0].value;
    employeeNumber = document.getElementsByName("ecnumber")[0].value;

    if (!(/^[A-z ]{2,}$/.test(employeeName))) {
        document.getElementsByName("enamev")[0].innerHTML = "please enter valid name";
        valid=false;
    }else{
        document.getElementsByName("enamev")[0].innerHTML = " ";
    }
    if (!employeeGender[0].checked && !employeeGender[1].checked) {
        document.getElementsByName("egenderv")[0].innerHTML = "please select gender";
        valid=false;
    } else{
        document.getElementsByName("egenderv")[0].innerHTML = " ";
    }
    if (!(/^[A-z]+@[A-z]+\.[A-z]+$/.test(employeeEmail))) {
        document.getElementsByName("eemailv")[0].innerHTML = "please enter valid email address";
        valid=false;
    }else{
        document.getElementsByName("eemailv")[0].innerHTML = " ";
    }
    if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
        document.getElementsByName("epassv")[0].innerHTML = "password should contains Uppercase, Lowercase, Numeric and min 8 characters";
        valid=false;
    }else{
        document.getElementsByName("epassv")[0].innerHTML = " ";
    }
    if (employeePassword != employeeMatchPassword) {
        document.getElementsByName("ecnfrmpassv")[0].innerHTML = "password doesn't match";
        valid=false;
    }else{
        document.getElementsByName("ecnfrmpassv")[0].innerHTML = "Password Matched";
    }
    if (!(/^[0-9]{10}$/.test(employeeNumber))) {
        document.getElementsByName("ecnumberv")[0].innerHTML = "please enter valid number";
        valid=false;
    }else{
        document.getElementsByName("ecnumberv")[0].innerHTML = " ";
    }
    if (valid == false) {
        valid=true;
        return;
    }

    document.getElementById("emp-reg").innerHTML = "<p style='font-size:180%'>Congratulations you are registered now with employee id 101</p1>";
    document.getElementById("veh-reg").style.display = "block";
    employeeId.value = "101";


}
function vehRegister() {

    vehicleName = document.getElementsByName("vname")[0].value;
    vehicleType = document.getElementsByName("vtype")[0].value;
    vehicleNumber = document.getElementsByName("vnumber")[0].value;
    employeeId = document.getElementsByName("eid")[0].value;
    vehicleIdentity = document.getElementsByName("videntity")[0].value;

    document.getElementById("veh-reg").innerHTML = "<p style='font-size:180%'>Congratulations your vehicle is registered now </p1>";
    document.getElementById("pricing").style.display = "block";
    document.getElementById("veh-type").innerHTML = "<p style='font-size(130%)'>Pricing available for </h4>" + vehicleType;
}
function showPrice() {

    currency = document.getElementById("currency").value;
    plan = document.getElementById("plans").value;

    plans.style.display = "block";
    var v = vehicleType;
    var daily = 5;
    var monthly = 100;
    var yearly = 500;

    if (v == "Motocycle") {
        daily = 10;
        monthly = 200;
        yearly = 1000;
    } else if (v == "Car") {
        daily = 20;
        monthly = 500;
        yearly = 3500;
    }

    var cur = currency;
    switch (cur) {
        case "INR":
            document.getElementById("daily").innerHTML = daily;
            document.getElementById("monthly").innerHTML = monthly;
            document.getElementById("yearly").innerHTML = yearly;
            break;
        case "USD":
            document.getElementById("daily").innerHTML = (daily / 71.74).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 71.74).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 71.74).toFixed(2);
            break;
        case "YEN":
            document.getElementById("daily").innerHTML = (daily / 0.68).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 0.68).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 0.68).toFixed(2);
            break;
    }
}
function setPricing() {
    document.getElementById("pricing").innerHTML = "<p style='font-size:180%'>Plan choosen successfully</p>"
}