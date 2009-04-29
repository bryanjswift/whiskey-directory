<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.whiskeydirectory.web.controller.Index" %>
<%@ page import="com.whiskeydirectory.model.PersistableStreet" %>
<%@ page import="java.util.List" %>
<html>
	<head>
		<title>Save a street</title>
	</head>
	<body>
		<% Index.streets(request); %>
		<form action="/index" method="post">
			<p>
				<label for="streetname">Street</label>
				<input id="streetname" name="name" type="text" />
			</p>
			<p>
				<input id="northsouth" name="longitudinal" type="checkbox" value="true" />
				<label for="northsouth">North/South</label>
			</p>
			<input type="submit" name="submit" value="Submit" />
	</body>
</html>
