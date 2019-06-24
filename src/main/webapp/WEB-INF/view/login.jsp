<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var userid='${userid}';
	if(userid.length>0){
		$("#regsuc").append("<span>You have registered successfully..!! Please login with user Id :</span><b><font color='blue'>" +userid+"</font></b>");
	}
	var error='${error}';
	if(error.length>0){
		$("#error").append("<span style='color:red;'>"+error+"</span>");
	}
});
</script>
</head>
<body>
<br><br><br><br>
<div></div>
<div id="regsuc" align="center"></div>
<div id="error" align="center"></div>
<form action="/validateuser" id="challengeloginform" method="post">
<div align="center" >
<br><br><br><br>
<div>Enter User Id :<input type="text" width="20" name="userid"/></div>
<div>Enter Password  :<input type="password" width="20" name="password"/></div>
<div><button type="submit">Login</button></div>
<div>Not Registered User <a href="/register" style="color: green">Register</a></div>
</div>
</form>
</body>
</html>