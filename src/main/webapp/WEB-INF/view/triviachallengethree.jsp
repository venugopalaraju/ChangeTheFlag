<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trivia Challenge Three</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).on('click', 'button.submit', function () {
    var form = $('#triviaForm');
    var action = $(this).data('action');
    form.attr('action', action);
    form.submit();
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
<h1 align="center">Trivia Challenge 3</h1>
<form action="/validatetriviachallengethree" id="triviaForm" method="post">
<div class="form-group">
<label>Question : What is the password to login in reboot ?</label>

<p>Hint: REBOOT..
Hint: A security organization producing a short film "REBOOT" and released trailer in YouTube.
Can you find the password?</p>
<label>Enter Your Answer :</label>
<input type="text" name="answer" class="form-control-default"/><span style="color: red;">${error}</span>
</div>
<div>
<button type="submit" class="btn btn-success" style="">Submit</button>
<button type="submit" class="submit btn btn-info" data-action="/skipvalidatetriviachallengethree">Skip</button>
</div>
</form>
</div>
</body>
</html>