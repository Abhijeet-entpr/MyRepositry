<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		<div class="container">
		<pre>${errormsg}</pre>
	<form method="post">
		
		  Name:<input type="text" name="name">
		  Password:<input type="text" name="password">
			<input type="submit" >
	</form>
	</div>
	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"> </script>
	<script src="webjars/jquery/3.7.0/jquery.min.js"> </script>
</body>
</html>