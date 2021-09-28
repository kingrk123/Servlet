<html>
<head><title>Confirmation</title></head>

<%
	//read form data
	String favLang=request.getParameter("fv");
	//Create the cookie
	Cookie thecookie =new Cookie("myapp.favoriteLanguage",favLang);
	//set the life span.......of cookie
	thecookie.setMaxAge(60*60*24*365);
	//send cookie to browser
	response.addCookie(thecookie);
%>

<body>
	Thanks we set Your Favorite Language to:${param.favoriteLanguage}
	<br><br>
	<a href="cookies-homepage.jsp">Return to homepage</a>
</body>
</html>