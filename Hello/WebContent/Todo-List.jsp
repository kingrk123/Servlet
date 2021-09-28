<%@ page import="java.util.*" %>
<html>
<body>
<!-- Step-1:Create HTML form -->
<form action="Todo-List.jsp">
	Add New Item : <input type="text" name="theItem"/>
	<input type="submit" value="submit"/>
</form>
<br>
<!-- Step-2:Add New Item to "TO DO" List -->
<%
	//get the TO DO items from the session
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	
	//if the TO DO item doesn't exist, then create a new one
	if(items==null){
		items=new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}
	
	//see if there is form data to add
	String theItem =request.getParameter("theItem");
	if(theItem!=null){
		items.add(theItem);
	}
%>
<!-- Step-3:Display all "TO DO" item from session -->
<hr>
<b> To List Items </b>
<ol>
	<%
		for(String temp: items){
			out.println("<li>" + temp+ "</li>");
		}
	%>
</ol>
</body>
</html>