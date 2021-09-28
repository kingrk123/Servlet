<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	//just Create some sample data .....normally provided by mvc
	
	String[] cities ={ "Hyderbad","Banglore","Pune"};
	pageContext.setAttribute("myCities",cities);
%>

<html>
<body>
	<c:forEach var ="tempCity" items="${myCities}">
	
	 ${tempCity} <br>
	</c:forEach>
</body>

</html>