function studentValidation() {
	
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var fatherName = document.getElementById("fatherName").value;
    var email = document.getElementById("email").value;
    var classNo = parseInt(document.getElementById("classNo").value);
    var age = parseInt(document.getElementById("age").value);

    var flag = true;

    //first Name validation 
    if (fname.length < 2 && fname.length < 50) {
        var message = "length of name should be min 2 character and max 50";
        document.getElementById("efname").innerHTML = message;
        flag = false;
    } else if (!(/^[a-zA-Z]+$/.test(fname))) {
        var message = "name must be in alphabets";
        document.getElementById("efname").innerHTML = message;
        flag = false;
    } else {
        document.getElementById("efname").innerHTML = "";
    }

    //last Name validation
    if (lname.length < 2 && lname.length > 50) {
        var message = "length of name should be min 2 character and max 50";
        document.getElementById("elname").innerHTML = message;
        flag = false;
    } else if (!(/^[a-zA-Z]+$/.test(lname))) {
        var message = "name must be in alphabets and should not contain space";
        document.getElementById("elname").innerHTML = message;
        flag = false;
    } else {
        document.getElementById("elname").innerHTML = "";
    }

    //father Name validation
    if (fatherName.length < 3) {
        var message = "length of name should be min 2 character and max 50";
        document.getElementById("efatherName").innerHTML = message;
        flag = false;
    } else if (!(/^[a-zA-Z ]+$/.test(fatherName))) {
        var message = "name must be in alphabet";
        document.getElementById("efatherName").innerHTML = message;
        flag = false;
    } else {
        document.getElementById("efatherName").innerHTML = "";
    }

    //Email Validation
    if (!(/\S+@\S+\.\S+/.test(email)) || email.length > 50) {
        var message = "invalid email address";
        document.getElementById("eemail").innerHTML = message;
        flag = false;
    } else {
        document.getElementById("eemail").innerHTML = "";
    }
    
    //age validation
    if (age < 3 || age > 35 ) {
        var message = "Invalid Age";
        document.getElementById("eage").innerHTML = message;
        flag = false;
    } else {
        document.getElementById("eage").innerHTML = "";
    }

    return flag;

}