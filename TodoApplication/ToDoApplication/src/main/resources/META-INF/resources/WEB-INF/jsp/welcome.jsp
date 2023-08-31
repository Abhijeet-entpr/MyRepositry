<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
		<%@include file="common/navigation.jspf" %>
	
		<div class="container">
		<div>Welcome to ToDo Application ${name}!</div>
		<hr>
		<div>Your Name: ${name}</div>
		<div>Your Password: ${password}</div>
		<div> <a href="/todos" >Manage your ToDo's</a></div>
		
		<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"> </script>
	<script src="webjars/jquery/3.7.0/jquery.min.js"> </script>
	</div>
</body>
</html>