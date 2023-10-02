<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook</title>
<%@include file="component/allCss.jsp"%>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<%@include file="component/navbar.jsp"%>
	
	<% session.getAttribute("user"); %>

	<div class="container text-center text-success">
		<h1>Welcome to PhoneBook</h1>
	</div>
      
	</div>

<%@include file="component/footer.jsp"%>
</body>
</html>