<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href='/css/hack.css' rel='stylesheet'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var error='${error}';
	if(error.length>0){
		$("#error").append("<span style='color:red;'>"+error+"</span>");
	}
});
</script>
</head>
<body style="padding-top: 10%;background: #D3D3D6">
<div align="center">
<h1 align="center">Registration</h1>
<div id="error" align="center"></div>
<form:form action="/registeruser" id="register" method="post" modelAttribute="user" >
<div class="form-group"><label>Enter User Id :</label><form:input type="text" name="userid" class="form-control-default"  path="userid" autocomplete="off" />(Numeric Values Only)</div>
<div class="form-group"><label>Enter User Name :</label><form:input type="text" name="username" class="form-control-default"  path="username" autocomplete="off"/>(Alphanumeric Characters Only)</div>
<div class="form-group"><label>Enter Password  :</label><form:input type="password" name="password" class="form-control-default"  path="password" autocomplete="off"/>(Should Not Be More Than 8 Characters)</div>
<div class="form-group"><label>Enter Mail  :</label><form:input type="text" name="mail" class="form-control-default"  path="email" autocomplete="off"/></div>
<div class="form-group">
<button type="submit" class="btn btn-success">Register</button>
<a href="/login" class="btn btn-info">Login</a>
</div>
<!-- <div class="form-group"><span></span><span><button type="submit">Register</button></span><span><a href="/login" >Login</a></span><span style="color: green"></span></div> -->
</form:form>
</div>
</body>
</html>