<!DOCTYPE html PUBxLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DbConnection"%>
<%@page import="java.sql.Connection"%>
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
		mainmenuid : "tooplate_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
</script>

<link rel="stylesheet" href="css/slimbox2.css" type="text/css"
	media="screen" />
<script type="text/JavaScript" src="js/slimbox2.js"></script>

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />

</head>
<body>

<%
if(request.getParameter("insert")!=null)
{
out.println("<script>alert('File Uploaded Successfully...')</script>");	
}
%>

	<div id="tooplate_wrapper">
		<div id="tooplate_header">
			<h1>
				<center>
					<a href="index.jsp"><font color="white">Intrusion
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
					<li><a href="home.jsp" class="selected">Home</a></li>
					<li><a href="upload.jsp">Upload</a></li>
					<li><a href="received.jsp">Receive</a></li>
					<li><a href="index.jsp">Logout</a></li>

				</ul>
				<br style="clear: left" />
			</div>
			<!-- end of tooplate_menu -->
			<!-- END of slider -->
			<br>
			<br>

<form action="SentFiles" method="post"  enctype="multipart/form-data" onsubmit="return validate()">
				<h3 align="center">Upload and Send </h3>
				<table align="center">
					<tr>
						<td>File 1 :</td>
						<td><input type="file" name="file1" id="file1" required="required" style="" /></td>
						<td><input type="text" name="signature1" id="signature1" placeholder="signature1" maxlength="20" required="required" style="" /></td>
					</tr>
					<tr>
						<td>File 2 :</td>
						<td><input type="file" name="file2" id="file2" required="required" style="" /></td>
						<td><input type="text" name="signature2" id="signature2" placeholder="signature2" maxlength="20" required="required" style="" /></td>
					</tr>
					<tr>
						<td>File 3 :</td>
						<td><input type="file" name="file3" id="file3" required="required" style="" /></td>
						<td><input type="text" name="signature3" id="signature3" placeholder="signature3" maxlength="20" required="required" style="" /></td>
					</tr>
					
					<tr>
						<td>File 4 :</td>
						<td><input type="file" name="file4" id="file4" required="required" style="" /></td>
						<td><input type="text" name="signature4" id="signature4" placeholder="signature4" maxlength="20" required="required" style="" /></td>
					</tr>
					<tr><td></td>
					<td><select name="receiver" required
							class="required input_field">
								<option value="">----- Select Receiver -----</option>
								<%
									String username = (String) session.getAttribute("username");
									System.out.println("username : " + username);
									Connection con = DbConnection.getConnection();
									String sql = "select * from mem_info where username !='" + username
											+ "'";
									PreparedStatement ps = con.prepareStatement(sql);
									ResultSet rs = ps.executeQuery();
									while (rs.next()) {
								%>

								<option value="<%=rs.getString("username")%>"><%=rs.getString("username")%></option>
								<%
									String ss = rs.getString("username");
										System.out.println("re " + ss);
								%>

								<%
									}
								%>
						</select></td></tr>
					<tr>
					<td></td>
					<td><input type="submit" value="Upload" style="" /></td>
					</tr>
				</table>




			</form>
			<div id="tooplate_main">

				<div class="content_wrapper content_mb_60">
					<div class="col_2"></div>

					<div class="col_2 no_margin_right"></div>
				</div>
				<div class="clear h30"></div>
				<div style="display: none;" class="nav_up" id="nav_up"></div>
			</div>
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

			$(window).bind('scrollstart', function() {
				$('#nav_up,#nav_down').stop().animate({
					'opacity' : '0.2'
				});
			});
			$(window).bind('scrollstop', function() {
				$('#nav_up,#nav_down').stop().animate({
					'opacity' : '1'
				});
			});

			$('#nav_up').click(function(e) {
				$('html, body').animate({
					scrollTop : '0px'
				}, 800);
			});
		});
	</script>

</body>
</html>