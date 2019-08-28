
var ename, egender, eemail, epass, ecnfrmpass, ccnumber;;

var vname, vtype, vnumber, eid, videntity;

var currency, plan;

var count = 0;

function empRegister() {

    ename = document.getElementsByName("ename")[0].value;
    egender = document.getElementsByName("egender");
    eemail = document.getElementsByName("eemail")[0].value;
    epass = document.getElementsByName("epass")[0].value;
    ecnfrmpass = document.getElementsByName("ecnfrmpass")[0].value;
    ecnumber = document.getElementsByName("ecnumber")[0].value;

    if (!(/^[A-z ]{2,}$/.test(ename))) {
        document.getElementsByName("enamev")[0].innerHTML = "please enter valid name";
        count++;
    }
    if (!egender[0].checked && !egender[1].checked) {
        document.getElementsByName("egenderv")[0].innerHTML = "please select gender";
        count++;
    }
    if (!(/^[A-z]+@[A-z]+\.[A-z]+$/.test(eemail))) {
        document.getElementsByName("eemailv")[0].innerHTML = "please enter valid email address";
        count++;
    }
    if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(epass))) {
        document.getElementsByName("epassv")[0].innerHTML = "please enter strong password";
        count++;
    }
    if (epass != ecnfrmpass) {
        document.getElementsByName("ecnfrmpassv")[0].innerHTML = "password doesn't match";
        count++;
    }
    if (!(/^[0-9]{10}$/.test(ecnumber))) {
        document.getElementsByName("ecnumberv")[0].innerHTML = "please enter valid number";
        count++;
    }
    if (count > 0) {
        count = 0;
        return;
    }

    document.getElementById("emp-reg").innerHTML = "<p style='font-size:180%'>Congratulations you are registered now with employee id 101</p1>";
    document.getElementById("veh-reg").style.display = "block";
    eid.value = "101";


}
function vehRegister() {

    vname = document.getElementsByName("vname")[0].value;
    vtype = document.getElementsByName("vtype")[0].value;
    vnumber = document.getElementsByName("vnumber")[0].value;
    eid = document.getElementsByName("eid")[0].value;
    videntity = document.getElementsByName("videntity")[0].value;

    document.getElementById("veh-reg").innerHTML = "<p style='font-size:180%'>Congratulations your vehicle is registered now </p1>";
    document.getElementById("pricing").style.display = "block";
    document.getElementById("veh-type").innerHTML = "<p style='font-size(130%)'>Pricing available for </h4>" + vtype;
}
function showPrice() {

    currency = document.getElementById("currency").value;
    plan = document.getElementById("plans").value;

    plans.style.display = "block";
    var v = vtype;
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