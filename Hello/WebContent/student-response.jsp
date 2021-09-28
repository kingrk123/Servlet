<html>
<head><title>Student Confirmation Title</title></head>
<body>
	The Student is Confirmed:${param.firstName} ${param.lastName} 
	
	<br><br>
	The Student is ${param.Gender}  
	<br><br>
	The Favorite Language is ::
	<ul>
		<%
			String[] langs = request.getParameterValues("fl");
		for(String tempLang :langs){
			out.println("<li>"+ tempLang+ "</li>");
		}
		%>
	</ul>
	<br><br>
	The Student Country:${param.country}  
	
</body>
</html>