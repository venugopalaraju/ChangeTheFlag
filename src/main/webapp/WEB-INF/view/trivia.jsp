<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trivia Challenge</title>
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
<body >
<div align="center" style="padding-top: 10%">
<div><strong style="font-size: 20px;">Trivia Challenges</strong></div>
<form:form action="/triviasubmit" modelAttribute="trivia" id="triviaForm">
<div class="form-group">
<div><label>Question 1:</label></div>
<div>
<form:input path="triviaAnswerOne"/>
<span style="color: red;"><form:errors path="triviaAnswerOne"/></span></div>
</div>
<div class="form-group">
<div><label>Question 2:</label></div>
<div>
<form:input path="triviaAnswerTwo"/>
<span style="color: red;"><form:errors path="triviaAnswerTwo"/></span></div>
</div>
<div class="form-group">
<div><label>Question 3:</label></div>
<div>
<form:input path="triviaAnswerThree"/>
<span style="color: red;"><form:errors path="triviaAnswerThree"/></span></div>
</div>
<div class="form-group">
<div><label>Question 4:</label></div>
<div>
<form:input path="triviaAnswerFour"/>
<span style="color: red;"><form:errors path="triviaAnswerFour"/></span></div>
</div>
<div class="form-group">
<div><label>Question 5:</label></div>
<div>
<form:input path="triviaAnswerFive"/>
<span style="color: red;"><form:errors path="triviaAnswerFive"/></span></div>
</div>
<div>
<button type="submit" class="btn btn-primary" style="">Submit</button>
<button type="submit" class="submit btn btn-primary" data-action="/triviaskip">Skip</button>
<!-- <input type="button" class="submit" value="Skip" data-action="/triviaskip" /> -->
</div>
</form:form>
</div>
</body>
</html>