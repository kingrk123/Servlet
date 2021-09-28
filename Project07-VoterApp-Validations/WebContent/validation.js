/**
 * 
 */
function validate(frm) {
	//set vflag to  "yes" indicating client side form validations are done
	frm.vflag.value="yes";
	//set style to error messages
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("nameErr").style="color:red";
	document.getElementById("nameErr").style="color:red";
	
	//read form data 
	var name = frm.pname.value;
	var age = frm.page.value;
	
	//perform client side form validations
	if(name=="")//required rule
		{
		document.getElementById("nameErr").innerHTML="Person name is mandatory ";
		frm.pname.focus();
		return false;
		}//if
	if(age==""){
		document.getElementById("ageErr").innerHTML="Person Age is manadatory";
		frm.page.focus();
		return false;
		}//if
	else{
		if(isNaN(age)) //check weather age is numeric value or not
			{
			document.getElementById("ageErr").innerHTML="Person age must be numeric value";
			frm.page.focus();
			frm.page.value="";
			return false;
			}//if
		}//else
	return true;
			}//function
