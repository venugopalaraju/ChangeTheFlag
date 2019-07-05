<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trivia Challenge Four</title>
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
</head>
<body>
<div align="center">
<h1 align="center">Trivia Challenge 4</h1>
<form action="/validatetriviachallengefour" id="triviaForm" method="post">
<div>
<label> A famous Hacker who hacked phones and he is author of multiple books. Can you tell me what is his middle name ?</label>
</div>
<div>
<label>Enter Your Answer :</label><input type="text" name="answer"/><span style="color: red;">${error}</span>
</div>
<div>
<button type="submit" class="btn btn-primary" style="">Submit</button>
<button type="submit" class="submit btn btn-primary" data-action="/skipvalidatetriviachallengefour">Skip</button>
</div>
</form>
</div>
</body>
</html>