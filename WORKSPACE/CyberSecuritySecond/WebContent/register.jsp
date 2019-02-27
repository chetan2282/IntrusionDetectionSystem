<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IDS</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!--
Template 2063 Wide Mode
http://www.tooplate.com/view/2063-wide-mode
-->
<link href="tooplate_style.css" rel="stylesheet" type="text/css" />

<script type="text/JavaScript" src="js/jquery-1.6.3.js"></script>

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/ddsmoothmenu.js">

</script>

<link href="jquery.datepick.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="jquery.plugin.js"></script>
<script src="jquery.datepick.js"></script>

<script>
$(function() {
	$('#popupDatepicker').datepick();
	$('#inlineDatepicker').datepick({onSelect: showDate});
});

function showDate(date) {
	alert('The date chosen is ' + date);
}
</script>
<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "tooplate_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<link rel="stylesheet" href="css/slimbox2.css" type="text/css"
	media="screen" />
<script type="text/JavaScript" src="js/slimbox2.js"></script>

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />

<script>
function AllowAlphabet() {
	if (!userreg.fname.value.match(/^[a-zA-Z]+$/)
	&&userreg.fname.value != "") {
		userreg.fname.value = "";
		userreg.fname.focus();
	alert("Please Enter only alphabet in text");
	        }
	
	if (!userreg.mname.value.match(/^[a-zA-Z]+$/)
			&&userreg.mname.value != "") {
				userreg.mname.value = "";
				userreg.mname.focus();
			alert("Please Enter only alphabet in text");
			        }

	if (!userreg.lname.value.match(/^[a-zA-Z]+$/) 
			&&userreg.lname.value != "") {
		userreg.lname.value = "";
		userreg.lname.focus();
	alert("Please Enter only alphabets in text");
	        }
	
	if (!userreg.address.value.match(/^[a-zA-Z]+$/) 
			&&userreg.address.value != "") {
		userreg.address.value = "";
		userreg.address.focus();
	alert("Please Enter only alphabets in text");
	        }
}

function validEmail() {
	var mail=document.userreg.email.value;
	if(mail== ""){
alert("Enter mailid");
document.userreg.email.focus();
returnfalse;
    }
if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))  
    {  
}else{
	alert("Enter Valid mailid");
	document.userreg.email.focus();
returnfalse;
	}
}

function Validate()
{ 
var y = document.userreg.mobile.value;

if(isNaN(y)||y.indexOf(" ")!=-1)
   {

userreg.mobile.value="";
userreg.mobile.focus();
alert("Enter Valid Mobile no");
returnfalse;
   }
if (userreg.mobile.value.length!=10)
   {
alert("Enter 10 digits No.");
returnfalse;
   } 

if (!y.match(/^[0-9]+$/) 
&&y != "") {
y = "";
userreg.mobile.focus();
alert("Please Enter only Digits in text");
   }

}

</script>


</head>
<body>

	<div id="tooplate_wrapper">
		<div id="tooplate_header">
			<h1>
				<center>
					<a href="index.html"><font color="white">Intrusion
							Detection System</font></a>
				</center>
			</h1>
		</div>
		<!-- END of header -->
		<div id="tooplate_main_wrapper">
			<span class="tmw_frame tmw_framet"></span><span
				class="tmw_frame tmw_frameb"></span>
			<div id="tooplate_menu" class="ddsmoothmenu">
				<ul>
					<li><a href="index.jsp" class="selected">Home</a></li>
					<li><a href="AdminLogin.jsp">Admin</a></li>
					<li><a href="login.jsp">User</a></li>
					<li><a href="register.jsp">Registration</a></li>

				</ul>
				<br style="clear: left" />
			</div>
			<!-- end of tooplate_menu -->
			<!-- END of slider -->
			<div id="tooplate_main">
				<div id="home_about">
					<h1>Intrusion Detection System</h1>
						<table align="center">
				
				<table align="center">
				<tr>
				<td>
				 <img src="images/people.png" width="60" height="50">&nbsp;&nbsp;&nbsp;</td>
				 <td><span style="font-size:22px">Registration</span></td>
				 </tr>
            </table>
            
            
            
          <form action="reg" method="post" name="userreg" onsubmit="return Regvalidation()">
            <center><table>
            <tr>
            <td><strong>First Name</strong></td><td><input type="text" name="fname" onblur="AllowAlphabet()" required id="fname"></input>&nbsp;&nbsp;&nbsp;</td>
            <td><strong>Middle Name</strong></td><td><input type="text" name="mname" onblur="AllowAlphabet()" required id= "mname"></input>&nbsp;&nbsp;&nbsp;</td>
            <td><strong>Last Name</strong></td><td><input type="text" name="lname" id= "lname" onblur="AllowAlphabet()" required></input>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            
            
            <tr>
            <td><strong>Date of Birth</strong></td><td><input type="text" name="dob" id="popupDatepicker" required></input></td>
           
            </tr>
           <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            
            
            
            <tr>
            <td><strong>Gender</strong></td><td>&nbsp;Male&nbsp;<input type="radio" name="gender" required id="gender" value="male"></input> &nbsp;Female&nbsp;<input type="radio" name="gender" id="gender" value="female"></input></td>
            </tr>
           <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            
            
            
            <tr>
            <td><strong>Address</strong></td><td><input type="text" name="address" onblur="AllowAlphabet()" required id="address" maxlength="15"></input></td>
            <td><strong>City</strong></td><td><input type="text" name="city" required maxlength="10"></input></td>
            </tr>
           <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
           
           
            <tr>
            <td><strong>Email Id</strong></td><td><input type="text"  name="email" required id="email" onblur="validEmail()"></input></td>
            <td><strong>Mobile no</strong></td><td><input type="text" name="mobile" id="txtMB" pattern="[7|8|9][0-9]{9}" maxlength="10" onblur="Validate()" title="Phone number Start with 7 or 8 or 9" required "></input></td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            
          
            
            <tr>
            <td><strong>UserName</strong></td><td><input type="text" maxlength="8" name="username" id="username" maxlength="10"required></input>&nbsp;&nbsp;&nbsp;</td>
            <td><strong>Password</strong></td><td><input type="password" maxlength="8" name="password" id="passwords" required maxlength="10""></input></td>
            </tr>
           
           
            
           
           <!-- <tr>
           <td><strong>File Upload: Select a file to upload:</strong></td><td><input type="file" name="file" size="50" />
<td><input type="submit" value="Upload File" /></td>
            
            </tr> -->
            <!--  <tr><td></td></tr>-->
            <tr>
            <td><input type="submit" style="font-size:large; 70px; height: 38px; width:71px;"></input></td>
            
            <td> &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp;
            <a href="register.jsp"><img src="images/reset.png" width="57" height="43" title="Reset"></img></a></td>
            </tr>
            
            
            
            </table></center>
					
												
			</form>
			
				</div>
					<!-- END of main wrapper -->
	</div>
	<!-- END of tooplate_wrapper -->

	<div id="tooplate_footer_wrapper">
		<div id="tooplate_footer">
			<marquee>Intrusion Detection System</marquee>
					</div>
		<!-- END of tooplate_footer -->
	</div>
	<!-- END of tooplate_footer_wrapper -->

	<div id="tooplate_copyright_wrapper">
		<div id="tooplate_copyright">
			Copyright © 2048 Your Company Name | Design: <a
				href="http://www.tooplate.com">Tooplate</a>
		</div>
	</div>

	<script src="js/scroll-startstop.events.jquery.js"
		type="text/javascript"></script>
	<script type="text/javascript">
	$(function() {
		var $elem = $('#content');
		
		$('#nav_up').fadeIn('slow');
		
		$(window).bind('scrollstart', function(){
			$('#nav_up,#nav_down').stop().animate({'opacity':'0.2'});
		});
		$(window).bind('scrollstop', function(){
			$('#nav_up,#nav_down').stop().animate({'opacity':'1'});
		});
		
		$('#nav_up').click(
			function (e) {
				$('html, body').animate({scrollTop: '0px'}, 800);
			}
		);
	});
</script>

</body>
</html>