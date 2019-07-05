<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var userid='${userid}';
	if(userid.length>0){
		$("#regsuc").append("<span style='color:green;'>You have registered successfully..!! Please login with user Id :</span><b><font color='blue'>" +userid+"</font></b>");
	}
	var error='${error}';
	if(error.length>0){
		$("#error").append("<span style='color:red;'>"+error+"</span>");
	}
});
</script>
<style type="text/css">
.form-control-default {
    display: block;
    height: calc(1.5em + .75rem + 2px);
    padding: .375rem .75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: .25rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}
</style>
</head>
<body style="padding-top: 10%;">
<div align="center">
<h1 align="center">Login</h1>
<div id="regsuc" align="center"></div>
<div id="error" align="center"></div>
<form action="/validateuser" id="challengeloginform" method="post">
<div class="form-group">
<label>Enter User Id :</label>
<input type="text" width="20" name="userid" class="form-control-default"/></div>
<div class="form-group">
<label>Enter Password  :</label>
<input type="password" width="20" name="password" class="form-control-default"/></div>
<div class="form-group">
<button type="submit" class="btn btn-success">Login</button>
<a href="/register" class="btn btn-info">Register</a>
</div>
</form>
</div>
</body>
</html>