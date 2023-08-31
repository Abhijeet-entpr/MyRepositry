<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
      
<!DOCTYPE html>

<html>
<head>
	<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet">
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.css.map" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>ToDo's</title>
</head>
<body>
		<%@include file="common/navigation.jspf" %>

	<div class="container">
	<div><h3>Welcome ${name}</h3></div>
		<hr>
		<div><h3>Add Todo Details</h3></div>
	<form:form method="post" modelAttribute="todo">
		<fieldSet class="mb-3">
		<form:label path="description" >Description </form:label>
		<form:input type="text" path="description" required="required"/>
		<form:errors path="description" cssClass="text-warning" />
		</fieldSet>
		<fieldSet class="mb-3">
		<form:label path="targetdate" >Date </form:label>
		<form:input type="text" path="targetdate" required="required"/>
		<form:errors path="targetdate" cssClass="text-warning" />
		</fieldSet>
		
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
		
		<div><input type="submit" class="btn btn-success"></div>
	</form:form>
	</div>
	
	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"> </script>
	<script src="webjars/jquery/3.7.0/jquery.min.js"> </script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"> </script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"> </script>
	<script type="text/javascript">
	$('#targetdate').datepicker({
	    format: 'yyyy-mm-dd',
	    
	});
	</script>
</body>
</html>
<!--    /META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.css.map
	/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css
	/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.css.map
	/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.css.map
	/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css
	/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js
	/META-INF/resources/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js    -->