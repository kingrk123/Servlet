<html>
<body>
<h3>Training Portal</h3>
	<!-- read the favorite language from the cookie -->
<%
	//read form data
	String favLang="Java";
	//get the request from the browser
	Cookie[] thecookie =request.getCookies();
	//find your favorite language
	if(thecookie!=null){
		for(Cookie tempcookie:thecookie){
			if("myapp.favoriteLanguage".equals(tempcookie.getName())){
				favLang=tempcookie.getValue();
				break;
			}
		}
	}
%>
<!-- now show a personalized page ... use the "favLang" variable -->

<!-- show new books for this lang -->
<h4>New Books for <%= favLang %></h4>
<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>

<h4>Latest News Reports for <%= favLang %></h4>
<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>

<h4>Hot Jobs for <%= favLang %></h4>
<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>

<hr>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>

</html>

