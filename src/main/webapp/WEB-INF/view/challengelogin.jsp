<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Challenge Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
<body style="padding-top: 10px;">
<div align="center" >
<form action="/validatechallengezero" id="challengeloginform" method="post">
<div><img alt="" src="\images\icebreak.jpg" width="50%"></div><br>
<div><p>Application initiated with default credentials. Try the default credentials you know.</p></div>
<div class="form-group">
<label>Enter User Name :</label>
<input type="text" width="20" name="username" class="form-control-default" autocomplete="off" />
<label>Enter Password  :</label>
<input type="password" width="20" name="password" class="form-control-default" autocomplete="off" />
</div>
<div>
<button type="submit" class="btn btn-success">Login</button>
</div>
</form>
</div>
</body>
</html>