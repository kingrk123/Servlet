function validate(frm){
	//set vflag to "yes indicating client side form validations are done"
	frm.vflag.value = "yes";
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("nameErr").style="color:red";
	document.getElementById("ageErr").style="color:red";
	
	//read form data
	var name = frm.pname.value;
	var age = frm.page.value;
	//perform client side form validations
	if(name=="")//required rule
		{
		document.getElementById("nameErr").innerHTML = "Person name is mandatory";
		frm.pname.focus();
		return false;
		}
	if(age==""){
		document.getElementById("nameErr").innerHTML = "Person age is mandatory";
		frm.page.focus();
		return false;
	}
	else {
		if(isNAN(age)){
			document.getElementById("nameErr").innerHTML = "Person age must be numeric value";
			frm.page.focus();
			frm.page.value="";
			return false;
		}
	}
	return true;
}