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

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

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

</head>
<%
   if(request.getParameter("login")!=null)
   {
  	 out.println("<script>alert('login failed')</script>");
   }
%>

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
				<tr>
				<td>
				 <img src="images/user.png" width="70" height="60">&nbsp;&nbsp;&nbsp;</td>
				 <td><span style="font-size:22px">Member Login</span></td>
				 </tr>
            </table>
            
            <br/>
             <form action="log" method="post">
            <br/>
            <table align="center">
            <tr>
            <td><span style="font-size:20px">Username</span></td><td><input type="text" name="username" placeholder="username" required></input></td>
            </tr>
            <tr>
            <td><br/></td>
            
            <td>
            </td>
            </tr>
            <tr>
            <td><span style="font-size:20px">Password</span></td><td><input type="password" name="password" placeholder="password" required></input>
            </tr>
            <!-- <tr>
            <td>
            
           

            </tr> -->
            </table>
            <br/>
             <div align="center"><input type="submit" value ="Login" style="font-size:large; 70px; height: 40px; width:60px;"></input></div>
            
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