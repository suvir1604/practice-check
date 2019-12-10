function validate()
{
	var name=document.forms["Form"]["name"].value;
	var price=document.forms["Form"]["price"].value;
	var date=document.forms["Form"]["date"].value;
	if (name == "") {
		alert("Title is required");
		return false;
	}
	if (name.length <2 name.length>100) {
		alert("title should have 2 to 65 characters");
		return false;
	}
	if (date =="") {
		alert("Date of launch cannot be blank");
		return false;
	}
	if (price =="") {
		alert("price cannot be empty");
		return false;
	}
	if(/[^0-9]/.test(price)) {
		alert("the price value should be number only");
		return false;
	}
}
		
	
