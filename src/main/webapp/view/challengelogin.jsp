<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Challenge Login</title>
</head>
<body>
<form action="/hackall" id="challengeloginform"></form>
<div>
<div><img alt="" src="\images\sourcecode.jpg"></div>
<div>Enter Password :<input type="password" width="20" id="password"/></div>
<div><button onclick="next()">Login</button></div>
</div>
<script language="javascript">
function next(){
	var password=document.getElementById("password").value;
	if(password=='candy'){
		document.getElementById("challengeloginform").submit();
			}
	else{
		alert("enter correct password");
	}
}
</script>
</body>
</html>