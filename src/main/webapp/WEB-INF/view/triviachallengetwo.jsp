<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trivia Challenge Two</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href='/css/hack.css' rel='stylesheet'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).on('click', 'button.submit', function () {
    var form = $('#triviaForm');
    var action = $(this).data('action');
    form.attr('action', action);
    form.submit();
});
</script>
</head>
<body style="padding-top: 10%;background: #D3D3D6">
<div align="center">
<h1 align="center">Trivia Challenge 2</h1>
<form action="/validatetriviachallengetwo" id="triviaForm" method="post">
<div class="form-group">
<label>Question : What type of animal was inside Sputnik 2 when launched into orbit in 1957 ?</label><br>
<label>Enter Your Answer :</label>
<input type="text" name="answer" class="form-control-default" autocomplete="off"/><span style="color: red;">${error}</span>
</div>
<div>
<button type="submit" class="btn btn-success" style="">Submit</button>
<button type="submit" class="submit btn btn-info" data-action="/skipvalidatetriviachallengetwo">Skip</button>
</div>
</form>
</div>
</body>
</html>