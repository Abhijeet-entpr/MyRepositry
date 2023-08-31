<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>ToDo's</title>
</head>
<body>
			<%@include file="common/navigation.jspf" %>
	

	<div class="container">
	<div><h3>Welcome ${name}</h3></div>
		<hr>
	<div><h1>Your ToDo's </h1> </div>
	<table class="table">
		<thead>
			<tr>
			<!--<th> Id </th>-->
			<th> Name </th>
			<th> Description </th>
			<th> Target Date </th>
			<th> Done? </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<!--   <td> ${todo.id}</td> -->
					<td> ${todo.username}</td>
					<td> ${todo.description}</td>
					<td> ${todo.targetdate}</td>
					<td> ${todo.done}</td>
					<td> <a href="/delete-todo?id=${todo.id}" class="btn btn-warning" />Delete ${todo.id}</td>
					<td> <a href="/update-todo?id=${todo.id}" class="btn btn-success"/> Update </td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
		<div> <a href="/add-todo"  class="btn btn-success">Add Todo</a></div>
	
	</div>
	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"> </script>
	<script src="webjars/jquery/3.7.0/jquery.min.js"> </script>
</body>
</html>