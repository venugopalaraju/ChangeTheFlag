

<!DOCTYPE html>
<html lang="en-US">
<head>
<title>Hacking Test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="Keywords" content="HTML,CSS,JavaScript,SQL,PHP,jQuery,XML,DOM,Bootstrap,Python,Java,Web development,W3C,tutorials,programming,training,learning,quiz,primer,lessons,references,examples,exercises,source code,colors,demos,tips">
<meta name="Description" content="Well organized and easy to understand Web building tutorials with lots of examples of how to use HTML, CSS, JavaScript, SQL, PHP, Python, Bootstrap, Java and XML.">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link href='https://fonts.googleapis.com/css?family=Source Code Pro' rel='stylesheet'>
<style>
a:hover,a:active{color:#4CAF50}
table.w3-table-all{margin:20px 0}
/*OPPSETT AV TOP, TOPNAV, SIDENAV, MAIN, RIGHT OG FOOTER:*/
.top {
position:relative;
background-color:#ffffff;
height:68px;
padding-top:20px;
line-height:50px;
overflow:hidden;
z-index:2;
}
.w3schools-logo {
font-family:fontawesome;
text-decoration:none;
line-height:1;
-webkit-font-smoothing:antialiased;
-moz-osx-font-smoothing:grayscale;
font-size:37px;
letter-spacing:3px;
color:#555555;
display:block;
position:absolute;
top:17px;
}
.w3schools-logo .dotcom {color:#4CAF50}
.topnav {
position:fixed;
z-index:2;
font-size:17px;
background-color:#5f5f5f;
color:#f1f1f1;
width:100%;
padding:0;
letter-spacing:1px;
font-family:"Segoe UI",Arial,sans-serif;
padding-right: 33px;
}
.topnav a{
padding:10px 15px 9px 15px !important;
}
.topnav .w3-bar a:hover,.topnav .w3-bar a:focus{
background-color:#000000 !important;
color:#ffffff !important;
}
.topnav .w3-bar a.active {
background-color:#4CAF50;
color:#ffffff;
}
a.topnav-icons {
width:52px !important;
font-size:20px !important;
padding-top:11px !important;
padding-bottom:13px !important;
}
a.topnav-icons.fa-home {font-size:22px !important}
a.topnav-icons.fa-menu {font-size:22px !important}
a.topnav-localicons {
font-size:20px !important;
padding-top:6px !important;
padding-bottom:12px !important;
}
i.fa-caret-down,i.fa-caret-up{width:10px}
#sidenav h2 {
font-size:21px;
padding-left:16px;
margin:-4px 0 4px 0;
width:204px;
}
#sidenav a {font-family:"Segoe UI",Arial,sans-serif;text-decoration:none;display:block;padding:2px 1px 1px 16px}
#sidenav a:hover,#sidenav a:focus {color:#000000;background-color:#cccccc;}
#sidenav a.active {background-color:#4CAF50;color:#ffffff}
#sidenav a.activesub:link,#sidenav a.activesub:visited {background-color:#ddd;color:#000;}
#sidenav a.activesub:hover,#sidenav a.activesub:active {background-color:#ccc;color:#000;}
#leftmenuinner {
position:fixed;
padding-bottom:0;    
height:100%;
width:220px;
top:50px;
z-index: 5000;
background: #f1f1f1;
}
#leftmenuinnerinner {
height:100%;
width:100%;
overflow-y:auto;
overflow-x:hidden;
background-color: #D3D3B6;
}
#main {padding:16px}
#mainLeaderboard {height:90px}
#right {text-align:center;padding:16px 16px 0 0}
#right a {text-decoration:none}
#right a:hover {text-decoration:underline}
#skyscraper {min-height:600px}
.sidesection {margin-bottom:32px;}
#sidesection_exercise a{display:block;padding:4px 10px;}
#sidesection_exercise a:hover,#sidesection_exercise a:active{background-color:#ccc;text-decoration:none;color:#000000;}
.bottomad {padding:0 16px 16px 0;float:left;width:auto;}
.footer a {text-decoration:none;}
.footer a:hover{text-decoration:underline;}
#nav_tutorials,#nav_references,#nav_exercises{-webkit-overflow-scrolling:touch;overflow:auto;}
#nav_tutorials::-webkit-scrollbar,#nav_references::-webkit-scrollbar,#nav_exercises::-webkit-scrollbar {width: 12px;}
#nav_tutorials::-webkit-scrollbar-track,#nav_references::-webkit-scrollbar-track,#nav_exercises::-webkit-scrollbar-track {background:#555555;}
#nav_tutorials::-webkit-scrollbar-thumb,#nav_references::-webkit-scrollbar-thumb,#nav_exercises::-webkit-scrollbar-thumb {background: #999999;}
#nav_tutorials,#nav_references,#nav_exercises {
display:none;
letter-spacing:0;
margin-top:44px;
}
#nav_tutorials a,#nav_references a,#nav_exercises a{
padding:2px 0 2px 6px!important;
}
#nav_tutorials a:focus,#nav_references a:focus,#nav_exercises a:focus{
color: #000;
background-color: #ccc;
}
#nav_tutorials h3,#nav_references h3,#nav_exercises h3{
padding-left:6px;
}
.ref_overview{display:none}
.w3-example{background-color:#f1f1f1;padding:0.01em 16px;margin:20px 0;box-shadow:0 2px 4px 0 rgba(0,0,0,0.16),0 2px 10px 0 rgba(0,0,0,0.12)!important}
.nextprev a {font-size:17px;border:1px solid #cccccc;}
.nextprev a:link,.nextprev a:visited {background-color:#ffffff;color:#000000;}
.w3-example a:focus,.nextprev a:focus{box-shadow:0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);}
.nextprev a.w3-right,.nextprev a.w3-left {background-color:#4CAF50;color:#ffffff;border-color:#4CAF50}
#w3-exerciseform {background-color:#555555;padding:16px;color:#ffffff;}
#w3-exerciseform .exercisewindow {background-color:#ffffff;padding:16px;color:#000000;}
#w3-exerciseform .exerciseprecontainer {background-color:#f1f1f1;padding:16px;font-size:120%;font-family:Consolas,"Courier New", Courier, monospace;}
#w3-exerciseform .exerciseprecontainer pre {display: block;}
#w3-exerciseform .exerciseprecontainer input {padding:1px;border: 1px solid transparent;height:1.3em;}
.w3-theme {color:#fff !important;background-color:#73AD21 !important;background-color:#4CAF50 !important}
.w3-theme-border {border-color:#4CAF50 !important}
.sharethis a:hover {color:inherit;}
.fa-facebook-square,.fa-twitter-square,.fa-google-plus-square {padding:0 8px;}
.fa-facebook-square:hover, .fa-thumbs-o-up:hover {color:#3B5998;}
.fa-twitter-square:hover {color:#55acee;}
.fa-google-plus-square:hover {color:#dd4b39;}
#google_translate_element img {margin-bottom:-1px;}
#googleSearch {color:#000000;}
#googleSearch a {padding:0 !important;}
.searchdiv {max-width:400px;margin:auto;text-align:left;font-size:16px}
div.cse .gsc-control-cse, div.gsc-control-cse {background-color:transparent;border:none;padding:6px;margin:0px}
td.gsc-search-button input.gsc-search-button {background-color:#4CAF50;border-color:#4CAF50}
td.gsc-search-button input.gsc-search-button:hover {background-color:#46a049;}
input.gsc-input, .gsc-input-box, .gsc-input-box-hover, .gsc-input-box-focus, .gsc-search-button {
box-sizing:content-box; line-height:normal;}
.gsc-tabsArea div {overflow:visible;}
/*"nullstille" w3css:*/
.w3-main{transition:margin-left 0s;
    background: #D3D2CD;
    height: 100%;
    position: absolute;
    width: 100%;}
/*"nullstilling" slutt*/
@media (min-width:1675px) {
#main {width:79%}
#right {width:21%}
}
@media (max-width:992px) {
.top {height:100px}
.top img {display:block;margin:auto;}
.top .w3schools-logo {position:relative;top:0;width:100%;text-align:center;margin:auto}
.toptext {width:100%;text-align:center}
#sidenav {width:260px;
box-shadow:0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
}
#sidenav h2 {font-size:26px;width:100%;}
#sidenav a {padding:3px 2px 3px 24px;font-size:17px}
#leftmenuinner {  
overflow:auto;
-webkit-overflow-scrolling:touch;
height:100%;
position:relative;
width:auto;
padding-top:0;
background-color:#f1f1f1;
}
#leftmenuinnerinner {overflow-y:scroll}
.bottomad {float:none;text-align:center}
#skyscraper {min-height:60px}
}
@media screen and (max-width:600px) {
.w3-example, .w3-note, #w3-exerciseform {margin-left:-16px;margin-right:-16px;}
.top {height:68px}
.toptext {display:none}
}
@font-face {
font-family:'fontawesome';
src: url('../lib/fonts/fontawesome.eot?14663396');
src:url('../lib/fonts/fontawesome.eot?14663396#iefix') format('embedded-opentype'),
url('../lib/fonts/fontawesome.woff?14663396') format('woff'),
url('../lib/fonts/fontawesome.ttf?14663396') format('truetype'),
url('../lib/fonts/fontawesome.svg?14663396#fontawesome') format('svg');
font-weight:normal;
font-style:normal;
}
.fa {
display:inline-block;
font:normal normal normal 14px/1 FontAwesome;
font-size:inherit;
text-rendering:auto;
-webkit-font-smoothing:antialiased;
-moz-osx-font-smoothing:grayscale;
transform:translate(0, 0);
}
.fa-2x {
 font-size:2em;
}
.fa-home:before {content:'\e800';}
.fa-menu:before {content: '\f0c9';}
.fa-globe:before {content:'\e801';}
.fa-search:before {content:'\e802'; }
.fa-thumbs-o-up:before {content:'\e803';}
.fa-left-open:before {content:'\e804';}
.fa-right-open:before {content:'\e805';}
.fa-facebook-square:before {content:'\e806';}
.fa-google-plus-square:before {content:'\e807';}
.fa-twitter-square:before {content:'\e808';}
.fa-caret-down:before {content:'\e809';}
.fa-caret-up:before {content:'\e80a';}
.fa-adjust:before { content: '\e80b'; }
span.marked, span.deprecated {
 color:#e80000;
 background-color:transparent;
}
.intro {font-size:16px}
.w3-btn, .w3-btn:link, .w3-btn:visited {color:#FFFFFF;background-color:#4CAF50}
a.w3-btn[href*="exercise.asp"],a.w3-btn[href*="exercise_js.asp"] {margin:10px 5px 0 0}
a.btnplayit,a.btnplayit:link,a.btnplayit:visited {background-color:#FFAD33;padding:1px 10px 2px 10px}
a.btnplayit:hover,a.btnplayit:active {background-color:#ffffff;color:#FFAD33}
a.btnplayit:hover {box-shadow:0 4px 8px 0 rgba(0,0,0,0.2);}
a.btnsmall:link,a.btnsmall:visited,a.btnsmall:active,a.btnsmall:hover {
float:right;padding:1px 10px 2px 10px;font:15px Verdana, sans-serif;}
a.btnsmall:hover {box-shadow:0 4px 8px 0 rgba(0,0,0,0.2);}
a.btnsmall:active,a.btnsmall:hover {color:#4CAF50;background-color:#ffffff}
.tagcolor{color:mediumblue}
.tagnamecolor{color:brown}
.attributecolor{color:red}
.attributevaluecolor{color:mediumblue}
.commentcolor{color:green}
.cssselectorcolor{color:brown}
.csspropertycolor{color:red}
.csspropertyvaluecolor{color:mediumblue}
.cssdelimitercolor{color:black}
.cssimportantcolor{color:red}  
.jscolor{color:black}
.jskeywordcolor{color:mediumblue}
.jsstringcolor{color:brown}
.jsnumbercolor{color:red}
.jspropertycolor{color:black}
.javacolor{color:black}
.javakeywordcolor{color:mediumblue}
.javastringcolor{color:brown}
.javanumbercolor{color:red}
.javapropertycolor{color:black}
.kotlincolor{color:black}
.kotlinkeywordcolor{color:mediumblue}
.kotlinstringcolor{color:brown}
.kotlinnumbercolor{color:red}
.kotlinpropertycolor{color:black}
.phptagcolor{color:red}
.phpcolor{color:black}
.phpkeywordcolor{color:mediumblue}
.phpglobalcolor{color:goldenrod}
.phpstringcolor{color:brown}
.phpnumbercolor{color:red}  
.pythoncolor{color:black}
.pythonkeywordcolor{color:mediumblue}
.pythonstringcolor{color:brown}
.pythonnumbercolor{color:red}  
.angularstatementcolor{color:red}
.sqlcolor{color:black}
.sqlkeywordcolor{color:mediumblue}
.sqlstringcolor{color:brown}
.sqlnumbercolor{color:} 
.darktheme {background-color:rgb(40,44,52);color:white;}
.darktheme .tagcolor{color:#88ccbb/*green2*/!important}
.darktheme .tagnamecolor{color:#ff9999/*red*/!important}
.darktheme .attributecolor{color:#c5a5c5/*purple*/!important}
.darktheme .attributevaluecolor{color:#88c999/*green*/!important}
.darktheme .commentcolor{color:color: #999;!important}
.darktheme .cssselectorcolor{color:#ff9999/*red*/!important}
.darktheme .csspropertycolor{color:#c5a5c5/*purple*/!important}
.darktheme .csspropertyvaluecolor{color:#88c999/*green*/!important}
.darktheme .cssdelimitercolor{color:white!important}
.darktheme .cssimportantcolor{color:color:#ff9999/*red*/!important}
.darktheme .jscolor{color:white!important}
.darktheme .jskeywordcolor{color:#c5a5c5/*purple*/!important}
.darktheme .jsstringcolor{color:#88c999/*green*/!important}
.darktheme .jsnumbercolor{color:#80b6ff/*blue*/!important}
.darktheme .jspropertycolor{color:white!important}
.darktheme .javacolor{color:white!important}
.darktheme .javakeywordcolor{color:#88c999/*green*/!important}
.darktheme .javastringcolor{color:#88c999/*green*/!important}
.darktheme .javanumbercolor{color:#88c999/*green*/!important}
.darktheme .javapropertycolor{color:white!important}
.darktheme .kotlincolor{color:white!important}
.darktheme .kotlinkeywordcolor{color:#88c999/*green*/!important}
.darktheme .kotlinstringcolor{color:#88c999/*green*/!important}
.darktheme .kotlinnumbercolor{color:#88c999/*green*/!important}
.darktheme .kotlinpropertycolor{color:white!important}
.darktheme .phptagcolor{color:#999!important}
.darktheme .phpcolor{color:white!important}
.darktheme .phpkeywordcolor{color:#ff9999/*red*/!important}
.darktheme .phpglobalcolor{color:white!important}
.darktheme .phpstringcolor{color:color:#88c999/*green*/!important}
.darktheme .phpnumbercolor{color:#88c999/*green*/!important}
.darktheme .pythoncolor{color:white!important}
.darktheme .pythonkeywordcolor{color:#ff9999/*red*/!important}
.darktheme .pythonstringcolor{color:#88c999/*green*/!important}
.darktheme .pythonnumbercolor{color:#88c999/*green*/!important}
.darktheme .angularstatementcolor{color:#ff9999/*red*/!important}
.darktheme .sqlcolor{color:white!important}
.darktheme .sqlkeywordcolor{color:#80b6ff/*blue*/!important}
.darktheme .sqlstringcolor{color:#88c999/*green*/!important}
.darktheme .sqlnumbercolor{color:}
@media only screen and (max-device-width: 480px) {
.w3-code, .w3-codespan,#w3-exerciseform .exerciseprecontainer {font-family: 'Source Code Pro',Menlo,Consolas,monospace;}
.w3-code {font-size:14px;}
.w3-codespan {font-size:15px;}
#w3-exerciseform .exerciseprecontainer {font-size:15px;}
#w3-exerciseform .exerciseprecontainer input {padding:0;height:1.5em}
}
@media screen and (max-width:700px) {
#mainLeaderboard {height:60px}
#div-gpt-ad-1422003450156-0 {float:none;margin-left:auto;margin-right:auto}
#div-gpt-ad-1422003450156-3 {float:none;margin-left:auto;margin-right:auto}
}
@media (max-width:1700px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(17){display:none;}}
@media (max-width:1600px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(13){display:none;}}
@media (max-width:1510px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(12){display:none;}}
@media (max-width:1450px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(11){display:none;}}
@media (max-width:1330px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(10){display:none;}}
@media (max-width:1200px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(9){display:none;}}
@media (max-width:1100px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(8){display:none;}}
@media (max-width:1000px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(7){display:none;}}
@media (max-width:992px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(6){display:none;}}
@media (max-width:930px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(18){display:none;}}
@media (max-width:800px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(19){display:none;}}
@media (max-width:650px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(5){display:none;} #topnav .w3-bar:nth-of-type(1) a:nth-of-type(16){display:none;}}
@media (max-width:460px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(4){display:none;}}
@media (max-width:400px) {#topnav .w3-bar:nth-of-type(1) a:nth-of-type(3){display:none;}}
.w3-note{background-color:#ffffcc;border-left:6px solid #ffeb3b}
.w3-warning{background-color:#ffdddd;border-left:6px solid #f44336}
.w3-info{background-color:#ddffdd;border-left:6px solid #4CAF50}
hr[id^="ez-insert-after-placeholder"] {margin-top: 0;}
.phonebr {display:none;}
@media screen and (max-width: 475px) {.phonebr {display:initial;}}
.topnav-right {
  float: right;
}
</style>
<script src="//snigelweb-com.videoplayerhub.com/videoloader.js" async></script>
<script src="//static.h-bid.com/sncmp/sncmp_stub.min.js" type="text/javascript"></script>
<script async type="text/javascript" src="//static.h-bid.com/w3schools.com/20190327/snhb-w3schools.com.min.js?20190327"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
.left-menu-item{
     padding: 10px;
    /* text-align: center; */
    vertical-align: middle;
    border-bottom: 1px solid grey;
    font-weight: 600;
    font-size: 14px;
    color: black;
}
</style>
</head>
<body>
<div style="display: none;" id="encryptedsrcpassword" value="d2VsY29tZQ=="></div>
<div class='w3-card-2 topnav notranslate' id='topnav'>
  <div style="overflow:auto;">
    <div class="w3-bar w3-left" style="width:100%;overflow:hidden;height:50px">
      <div class="topnav-right">
      <a class="w3-bar-item w3-button" onclick="openScore()" title='leader Board' style="cursor: pointer;">leader Board</a>
      <a class="w3-bar-item w3-button" onclick="openMyScore()" title='My Score' style="cursor: pointer;">My Profile</a>

					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Trivia Challenges </button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="/triviachallengeone" id="tc1">Trivia Challenge 1</a> 
						<a class="dropdown-item" href="/triviachallengetwo" id="tc2">Trivia Challenge 2</a> 
						<a class="dropdown-item" href="/triviachallengethree" id="tc3">Trivia Challenge 3</a>
						<a class="dropdown-item" href="/triviachallengefour" id="tc4">Trivia Challenge 4</a> 
						<a class="dropdown-item" href="/triviachallengefive" id="tc5">Trivia Challenge 5</a>
					</div>
					<a class="w3-bar-item w3-button" href="/login"  style="cursor: pointer;color: inherit;">Logout</a>
					<span id="scorecard"></span>
      <!-- <a class="w3-bar-item w3-button" href="/login" target="_self">Logout</a> -->
  </div>
 </div>
  </div>
</div>

<div class='w3-sidebar w3-collapse' id='sidenav'>
  <div id='leftmenuinner'>
    <div class='w3-light-grey' id='leftmenuinnerinner'>
<!--  <a href='javascript:void(0)' onclick='close_menu()' class='w3-button w3-hide-large w3-large w3-display-topright' style='right:16px;padding:3px 12px;font-weight:bold;'>&times;</a>-->
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
  </div>
</div>
<div style="display: none;" id="srcpassword" value="candy"></div>
<div class='w3-main w3-light-grey' id='belowtopnav' style='margin-left:220px;'>
<br><br>
<!-- Image loader -->
<div id="wait" style="display:none;width:69px;height:89px;border:1px solid black;position:absolute;top:50%;left:50%;padding:2px;"><img src='\images\load.gif' width="300%" height="300%" /><br>Loading..</div>
<!-- Image loader -->
<div id="main-content-div" align="center">
</div>
</div>
<div id="challenge1" class="challenge" style="display:none;">
<h1>Challenge 1</h1>
<div class="form-group">
<label>Developer stored the password in source code.</label>
</div>
<div><img alt="" src="\images\sourcecode.jpg"></div>
<div class="form-group">
Enter Password :<input type="password" id="challenge1password" class="form-control-default"/>
</div>
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
<input type="password" width="20" id="challenge2password" class="form-control-default"/>
</div>
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
<input type="password" width="20" id="challenge3password" class="form-control-default"/>
</div>
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
<input type="password" width="20" id="challenge4password" class="form-control-default"/>
</div>
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
<input type="password" width="20" id="challenge5password" class="form-control-default"/>
</div>
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
<input type="text" width="20" id="challenge7name" maxlength="20" class="form-control-default"/>
</div>
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
<input type="password" width="20" id="challenge8password" class="form-control-default"/>
</div>
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
<input type="text" width="100" id="command" class="form-control-default" value=""/>
</div>
<div class="form-group"><button onclick="challenge9()" class="btn btn-success">Submit</button></div>
<div class="command-output" style="display:none;">
<div id="cmd-output-body"></div>
<div class="form-group">
<label>Password :</label>
<input type="password" width="100" id="commandpwd" class="form-control-default"/>
</div>
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
<input type="password" width="20" id="challenge10password" class="form-control-default"/>
</div>
<div class="form-group"><button onclick="validatechallenge10()" class="btn btn-success">Submit</button></div>
<div><a href="/challenge10?getvalue=username" target="_blank"><font color="green"><b>Click here</b></font></a> to check your password</div>
</div>
<div id="challenge11" class="challenge" style="display:none;">
<h1>Challenge 11</h1>
<div class="form-group"><label>Developer Stored the password in a file visible to all users.</label></div>
<div><img alt="" src="\challenge11\directory.png"></div>
<div class="form-group">
<label>Enter Password :</label>
<input type="password" width="20" id="challenge11password" class="form-control-default"/>
</div>
<div class="form-group"><button onclick="validatechallenge11()" class="btn btn-success">Submit</button></div>
</div>
<div id="challenge12" class="challenge" style="display:none;">
<h1>Challenge 12</h1>
<div class="form-group"><label>Bypass the login page using logic gates.</label></div>
<div><img alt="" src="\images\sqlinjection.png"></div>
<div class="form-group">
<label>Enter Username :</label>
<input type="text" width="20" id="challenge12username" class="form-control-default"/>
</div>
<div class="form-group">
<label>Enter Password :</label>
<input type="text" width="20" id="challenge12password" class="form-control-default"/>
</div>
<div class="form-group"><button onclick="validatechallenge12()" class="btn btn-success">Submit</button></div>
</div>
<div id="challenge13" class="challenge" style="display:none;">
<div style="padding-top: 10%;"><p style="color: blue;">You have passed all the challenges. Please check your score board to know your score.If you have not earned 100% please complete Trivia Challenges also. Thank you..!!!</p> <a href="/login" style="color: green">Logout</a></div>
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
			$("#cha"+i+"div").append("<span class='tick'>&#10004;</span>");
		}
		score+=1;
		challenge(score);
	}else{
		challenge(1);
		$("#cha"+1+"div").append("<span class='hand'>&#9754;</span>");
	}
	updateMyScore();
});
function challenge(id){
	if(score>1){
		var divid=score-1;
		$("#cha"+divid+"div").css("background-color","lightblue");
		$("#cha"+divid+"div .hand").remove();
		$("#cha"+divid+"div").append("<span class='tick'>&#10004;</span>");
		$("#cha"+score+"div").append("<span class='hand'>&#9754;</span>");

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
						alert("Enter valid password");
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
						alert("Enter valid password");
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
						alert("Enter valid password");
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
						alert("Enter valid password");
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
						alert("Enter valid password");
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
						alert("Please enter a string which contains more than 20 characters");
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
						alert("Enter valid password");
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
						alert("Enter valid password");
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
						alert("Enter valid password");
					}
				}});
}
$(document).ajaxStart(function(){
	  // Show image container
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
							alert("Enter valid password");
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
							alert("Enter valid crednetials");
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
						$('.topnav-right #scorecard').html(score);
					}});
	}
</script>
<div class="modal" id="leaderBoardModel">
    <div class="modal-dialog">
      <div class="modal-content" style="height: 100%;width: 600px;">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Leadr Board</h4>
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
