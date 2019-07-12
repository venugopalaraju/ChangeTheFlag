<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="icon" href="/favicon.ico" type="image/x-icon">
<link href='https://fonts.googleapis.com/css?family=Source Code Pro' rel='stylesheet'>
 <link href='/css/hack.css' rel='stylesheet'>
</head>
<body>

<div class="nav-bar">
 <a  href="/login"  >Logout</a>
 <span id="scorecard"></span>
 <div class="drop-down">
    <button class="dropbtn" cursor: pointer;>Trivia Challenges 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="drop-down-content">
      <a  href="/triviachallengeone" id="tc1">Trivia Challenge 1</a> 
						<a  href="/triviachallengetwo" id="tc2">Trivia Challenge 2</a> 
						<a  href="/triviachallengethree" id="tc3">Trivia Challenge 3</a>
						<a  href="/triviachallengefour" id="tc4">Trivia Challenge 4</a> 
						<a  href="/triviachallengefive" id="tc5">Trivia Challenge 5</a>
    </div>
  </div> 
  <a  onclick="openMyScore()" title='My Score' style="color: white;cursor: pointer;">My Profile</a>
  <a  onclick="openScore()" title='leader Board' style="color: white;cursor: pointer;">Leader Board</a>
</div>

<div class="sidenav">
  <div class="left-menu-item"  id="cha1div" >Challenge 1</div>
<div class="left-menu-item"  id="cha2div">Challenge 2</div>
<div class="left-menu-item"  id="cha3div">Challenge 3</div>
<div class="left-menu-item"  id="cha4div">Challenge 4</div>
<div class="left-menu-item"  id="cha5div">Challenge 5</div>
<div class="left-menu-item"  id="cha6div">Challenge 6</div>
<div class="left-menu-item"  id="cha7div">Challenge 7</div>
<div class="left-menu-item"  id="cha8div">Challenge 8</div>
<div class="left-menu-item"  id="cha9div">Challenge 9</div>
<div class="left-menu-item"  id="cha10div">Challenge 10</div>
<div class="left-menu-item"  id="cha11div">Challenge 11</div>
<div class="left-menu-item"  id="cha12div">Challenge 12</div>
</div>

<div id="main-content-div" align="center">
  
</div>
<div id="challenge1" class="challenge" style="display:none;">
<h1>Challenge 1</h1>
<div class="form-group">
<label>Developer stored the password in source code.</label>
</div>
<div><img alt="" src="\images\sourcecode.jpg"></div>
<div class="form-group">
Enter Password :<input type="password" id="challenge1password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div>
<button onclick="validatechallenge1()" class="btn btn-success">Submit</button>
</div>
</div>
<div id="challenge2" class="challenge" style="display:none;">
<h1>Challenge 2</h1>
<div class="form-group">
<label>Password stored in accessible location for end users.</label>
</div>
<div><img alt="" src="\images\cookie1.jpg"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge2password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group">
<button onclick="validatechallenge2()" class="btn btn-success">Submit</button>
</div>
</div>
<div id="challenge3" class="challenge" style="display:none;">
<h1>Challenge 3</h1>
<div class="form-group">
<label>Developer stored the password in source code. But it is encoded this time. Find the pass and decode it.</label>
</div>
<div><img alt="" src="\images\password3.jpg"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge3password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group">
<button onclick="validatechallenge3()" class="btn btn-success">Submit</button>
</div>
</div>
<div id="challenge4" class="challenge" style="display:none;">
<h1>Challenge 4</h1>
<div class="form-group">
<label>Password stored in accessible location for end users. But it is encoded this time. Find the pass and decode it.</label>
</div>
<div><img alt="" src="\images\cookie2.jpg"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge4password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group">
<button onclick="validatechallenge4()" class="btn btn-success">Submit</button>
</div>
</div>
<div id="challenge5" class="challenge" style="display:none;">
<h1>Challenge 5</h1>
<div class="form-group">
<label>Developer shared the password in an image file. Name of the file is guessable. Can you find the image and get me the password?</label>
</div>
<div><img alt="" src="\images\tunnel.jpg"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge5password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group"><button onclick="validatechallenge5()" class="btn btn-success">Submit</button></div>
</div>
<div id="challenge6" class="challenge" style="display:none;">
<h1>Challenge 6</h1>
<div class="form-group">
<label>Currently logged in user is a normal user. Make yourself an admin user to proceed to next challenge.</label>
</div>
<div><a target="_top" onclick='challenge6()'><img alt="" src="\images\admin.jpg"></a></div>
</div>
<div id="challenge7" class="challenge" style="display:none;">
<label>Challenge 7</label>
<div class="form-group">
<label>Developer restricted users to enter 20 characters only. Submit a value more than 20 characters to move forward.</label></div>
<div><img alt="" src="\images\html.png"></div>
<div class="form-group">
<label>Please enter a string which contains more than 20 characters</label>
<label>Enter String :</label>
<input type="text" width="20" id="challenge7name" maxlength="20" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group">
<button onclick="validatechallenge7()" class="btn btn-success">Submit</button></div>
</div>
<div id="challenge8" class="challenge" style="display:none;">
<h1>Challenge 8</h1>
<div class="form-group">
<label>Developer stored the password in a text file under root folder. File name is guessable. Guess the file to obtain the password.</label></div>
<div><img alt="" src="\images\file.jpg"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge8password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group"><button onclick="validatechallenge8()" class="btn btn-success">Submit</button></div>
<div><a target="_blank" href="\images\password2.jpg"><font color="green"><b>Click here</b></font></a> to check your password</div>
</div>
<div id="challenge9" class="challenge" style="display:none;">
<h1>Challenge 9</h1>
<div class="form-group">
<label>Developer stored the password in readme.txt file. Read the file content to get the password.</label></div>
<div><img alt="" src="\images\command.jpg"></div>
<div class="form-group"><br>
<label><b>Enter IP to ping :</b></label>
<input type="text" width="100" id="command" class="form-control-default" autocomplete="off" value=""/>
</div>
<div class="form-group"><button onclick="challenge9()" class="btn btn-success">Submit</button></div>
<div class="command-output" style="display:none;">
<div id="cmd-output-body"></div>
<div class="form-group">
<label>Password :</label>
<input type="password" width="100" id="commandpwd" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group"><button onclick="validatechallenge9pwd()" class="btn btn-success">submit</button></div>
</div>
</div>
<div id="challenge10" class="challenge" style="display:none;">
<h1>Challenge 10</h1>
<div class="form-group">
<label>Developer is retrieving the data from a get parameter. Try to get the value of password.</label></div>
<div><img alt="" src="\images\xssjs.jpg"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge10password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group"><button onclick="validatechallenge10()" class="btn btn-success">Submit</button></div>
<div><a href="/challenge10?getvalue=username" target="_blank"><font color="green"><b>Click here</b></font></a> to check your password</div>
</div>
<div id="challenge11" class="challenge" style="display:none;">
<h1>Challenge 11</h1>
<div class="form-group"><label>Developer Stored the password in a file visible to all users.</label></div>
<div><img alt="" src="\challenge11\directory.png"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge11password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group"><button onclick="validatechallenge11()" class="btn btn-success">Submit</button></div>
</div>
<div id="challenge12" class="challenge" style="display:none;">
<h1>Challenge 12</h1>
<div class="form-group"><label>Bypass the login page using logic gates.</label></div>
<div><img alt="" src="\images\sqlinjection.png"></div>
<div class="form-group">
<label>Enter Username :</label>
<input type="text" width="20" id="challenge12username" class="form-control-default" autocomplete="off"/>
</div>
<div class="form-group">
<label>Enter Password :</label>
<input type="text" width="20" id="challenge12password" class="form-control-default" autocomplete="off"/>
</div>
<div id="error" align="center"></div>
<div class="form-group"><button onclick="validatechallenge12()" class="btn btn-success">Submit</button></div>
</div>
<div id="challenge13" class="challenge" style="display:none;">
<div style="padding-right: 157px;padding-top: 224px;padding-left: 366px;"><p class="card bg-info text-white card-body">You have passed all the challenges. Please check your score board to know your score.If you have not earned 100% please complete Trivia Challenges also. Thank you..!!!</p> <a href="/login" style="color: green">Logout</a></div>
</div>
<input type="hidden" id="ensrcpwd" name="user" value="texens" />
<script type="text/javascript">
var score=0;
$(function() {
	loadTC();
	window.history.pushState("object or string", "Title", "/hackall");
	score=${challenge};
	if(score>0){
		for(i=1;i<score;i++){
			$("#cha"+i+"div").css("background-color","lightblue");
			$("#cha"+i+"div").append("<span class='tick'> <i style='font-size:24px;color:blue;' class='fa'>&#xf087;</i></span>");
		}
		score+=1;
		challenge(score);
	}else{
		challenge(1);
		$("#cha"+1+"div").append("<span class='hand'> <i style='font-size:24px;color:red;' class='fa'>&#xf0a5;</i></span>");
	}
	updateMyScore();
});
function challenge(id){
	if(score>1){
		var divid=score-1;
		$("#cha"+divid+"div").css("background-color","lightblue");
		$("#cha"+divid+"div .hand").remove();
		$("#cha"+divid+"div").append("<span class='tick'> <i style='font-size:24px;color:blue;' class='fa'>&#xf087;</i></span>");
		$("#cha"+score+"div").append("<span class='hand'> <i style='font-size:24px;color:red;' class='fa'>&#xf0a5;</i></span>");

	}
	if(score==0){
		score+=1;
	}
	if(score==id){
		if(id==2){
			challenge2();
		}
				if(id==4){
			challenge4();
		}
		$("#main-content-div").children().remove();
		$("#main-content-div").append($("#challenge"+id));
		$("#challenge"+id).show();
	}
}
function validatechallenge1(){
	var password=$("#challenge1password").val();
	$.ajax(
			{
				url: "/validatechallenge1",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
}
function challenge2(){
	$.ajax(
			{
				url: "/challenge2",
				success: function(result)
				{
					//ToDo
				}});
}
function validatechallenge2(){
	var password=$("#challenge2password").val();
	$.ajax(
			{
				url: "/validatechallenge2",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
}
function validatechallenge3(){
	var password=$("#challenge3password").val();
	$.ajax(
			{
				url: "/validatechallenge3",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
}
function challenge4(){
	$.ajax(
			{
				url: "/challenge4",
				success: function(result)
				{
					//ToDo
				}});
}
function validatechallenge4(){
	var password=$("#challenge4password").val();
	$.ajax(
			{
				url: "/validatechallenge4",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
}
function validatechallenge5(){
	var password=$("#challenge5password").val();
	$.ajax(
			{
				url: "/validatechallenge5",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
}
function challenge6(){
	$.ajax(
			{
				url: "/validatechallenge6",
				contentType: 'application/json',
				success:function(data){
					if(data!='success'){
						alert("your role is User..!!");
					}if(data=='success'){
						alert("your role is Admin..!!");
						score+=1;
						challenge(score);
						updateMyScore();
					}
				}});
}
function validatechallenge7(){
	var value=$("#challenge7name").val();
	$.ajax(
			{
				url: "/validatechallenge7",
				data: value,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Please enter a string which contains more than 20 characters</span>");
					}
				}});
}
function validatechallenge8(){
	var password=$("#challenge8password").val();
	$.ajax(
			{
				url: "/validatechallenge8",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
}
function challenge9(){
	var command=$("#command").val();
	$.ajax(
			{
				url: "/validatechallenge9",
				data: command,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					$("#cmd-output-body").html(data);
					$(".command-output").show();
				}});
}
function validatechallenge9pwd(){
	var password=$("#commandpwd").val();
	$.ajax(
			{
				url: "/validatechallenge9pwd",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
	}
function validatechallenge10(){
	var password=$("#challenge10password").val();
	$.ajax(
			{
				url: "/validatechallenge10",
				data: password,
				type: 'post',
			    contentType: 'application/json',
				success:function(data){
					if(data=="success"){
						score+=1;
						challenge(score);
						updateMyScore();
					}else{
						$("#error").append("<span style='color:red;'>Enter valid password</span>");
					}
				}});
}
$(document).ajaxStart(function(){
	  // Show image container
	  $("#error").empty();
	 $("#wait").css("display", "block");
	});
	$(document).ajaxComplete(function(){
	  // Hide image container
		 $("#wait").css("display", "none");
	});
	function validatechallenge11(){
		var password=$("#challenge11password").val();
		$.ajax(
				{
					url: "/validatechallenge11",
					data: password,
					type: 'post',
				    contentType: 'application/json',
					success:function(data){
						if(data=="success"){
							score+=1;
							challenge(score);
						}else{
							$("#error").append("<span style='color:red;'>Enter valid password</span>");
						}
					}});
	}
	function validatechallenge12(){
		var username=$("#challenge12username").val();
		var password=$("#challenge12password").val();
		var user={"username" : username,"password" :password};
		$.ajax(
				{
					url: "/validatechallenge12",
					data: JSON.stringify(user),
					type: 'post',
				    contentType: 'application/json',
					success:function(data){
						if(data=="success"){
							score+=1;
							challenge(score);
							updateMyScore();
						}else{
							$("#error").append("<span style='color:red;'>Enter valid crednetials</span>");
						}
					}});
	}
	function updatescore(challengeno){
		var challenge=challengeno;
		$.ajax(
				{
					url: "/updatescore",
					data: JSON.stringify(challenge),
					type: 'post',
				    contentType: 'application/json',
					success:function(data){
						//To Do
					}});
	}
	function openScore(){
		$("#model-tbody").find("tr").remove();
		$.ajax(
				{
					url: "/getscores",
					contentType: 'application/json',
					success:function(list){
						var data='';
						var userid='${user_id}';
						$.each(list, function( index, value ) {
							if(userid==value.userid){
								data=data+"<tr style='color:blue;'><td>"+(index+1)+"</td><td>"+value.userid+"</td><td>"+value.userName+"</td><td>"+value.score+"</td></tr>";
							}else{
								data=data+"<tr><td>"+(index+1)+"</td><td>"+value.userid+"</td><td>"+value.userName+"</td><td>"+value.score+"</td></tr>";
							}
													});
						$("#model-tbody").append(data);
						$("#leaderBoardModel").modal('toggle');
					}});
	}
	function openMyScore(){
		$("#myscore-table").find("tr").remove();
		$.ajax(
				{
					url: "/getmyscore",
					contentType: 'application/json',
					success:function(data){
						$("#myscore-table").append(data);
						$("#MyScoreModel").modal('toggle');
					}});
	}
	function loadTC(){
		var tc=${trivia};
		if(tc.challengeone=='Y'){
			$("#tc1"). removeAttr("href");
			$("#tc1").css("background-color","lightblue");
			$("#tc1").append("<span class='tick'>&#10004;</span>");
		}
		if(tc.challengetwo=='Y'){
			$("#tc2"). removeAttr("href");
			$("#tc2").css("background-color","lightblue");
			$("#tc2").append("<span class='tick'>&#10004;</span>");
		}
		if(tc.challengethree=='Y'){
			$("#tc3"). removeAttr("href");
			$("#tc3").css("background-color","lightblue");
			$("#tc3").append("<span class='tick'>&#10004;</span>");
		}
		if(tc.challengefour=='Y'){
			$("#tc4"). removeAttr("href");
			$("#tc4").css("background-color","lightblue");
			$("#tc4").append("<span class='tick'>&#10004;</span>");
		}
		if(tc.challengefive=='Y'){
			$("#tc5"). removeAttr("href");
			$("#tc5").css("background-color","lightblue");
			$("#tc5").append("<span class='tick'>&#10004;</span>");
		}
	}
	function updateMyScore(){
		$("#myscore-table").find("tr").remove();
		$.ajax(
				{
					url: "/getmyscorecard",
					contentType: 'application/json',
					success:function(data){
						var score="<span style='color: #b3d7ff;'>Score: "+data+"/100</span>";
						$('.nav-bar #scorecard').html(score);
					}});
	}
</script>
<div class="modal" id="leaderBoardModel">
    <div class="modal-dialog">
      <div class="modal-content" style="height: 100%;width: 600px;">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Leader Board</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
         <table class="table table-striped">
    <thead>
      <tr>
      	<th>Rank</th>
        <th>User Id</th>
        <th>Username</th>
        <th>Score</th>
      </tr>
    </thead>
    <tbody id="model-tbody">
    </tbody>
  </table>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  <div class="modal" id="MyScoreModel">
    <div class="modal-dialog">
      <div class="modal-content" style="height: 100%;width: 600px;">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">My Profile</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
         <table class="table table-striped" id="myscore-table"></table>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
</body>
</html>
