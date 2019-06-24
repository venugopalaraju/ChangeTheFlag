<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
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
<body>
<div id="error" align="center"></div>
<form:form action="/registeruser" id="register" method="post" modelAttribute="user" >
<div align="center">
<br><br><br><br>
<div>Enter User Id :<form:input type="text" width="20" name="userid" path="userid"/></div>
<div>Enter User Name :<form:input type="text" width="20" name="username" path="username"/></div>
<div>Enter Password  :<form:input type="password" width="20" name="password" path="password"/></div>
<div>Enter Mail  :<form:input type="text" width="20" name="mail" path="email"/></div>
<div><button type="submit">Register</button></div>
</div>
</form:form>
</body>
</html>