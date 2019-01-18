<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>LetsMeet</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Perfect Travel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" property="" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css"
	media="all">
<link href="css/owl.theme.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/cm-overlay.css" />
<!-- font -->
<link href="//fonts.googleapis.com/css?family=Merienda+One"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<script>
$(document).ready(function() { 
	$("#owl-demo").owlCarousel({
 
		autoPlay: 3000, //Set AutoPlay to 3 seconds
		autoPlay:true,
		items : 3,
		itemsDesktop : [640,5],
		itemsDesktopSmall : [414,4]
 
	});
	
}); 
</script>

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->
</head>
<body> 
<%
HttpSession ses = request.getSession(false);// don't create if it doesn't exist
String n=(String)ses.getAttribute("uname");
if(ses != null && !ses.isNew()&& n!=null) 
{
  //  chain.doFilter(request, response);
} else 
{
    response.sendRedirect("Login.jsp");
}

%>
<%//HttpSession ses=request.getSession(false);
					String name=(String)ses.getAttribute("uname");
					%>

<div class="head">
				<div class="container">
					<div class="navbar-top">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<div class="navbar-brand logo ">
								<h1 class="animated wow pulse" data-wow-delay=".5s">
									<a href="index.html">Lets <span>Plan</span></a>
								</h1>
							</div>

						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" style="margin-left: 100px; width: 800px"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav link-effect-4">
							<li ><a href="Home.jsp" data-hover="Home">Home</a>
						</li>
							<li><a href="CreateLetsMeet.jsp" data-hover="Gallery">Create
										Event</a></li>
										<li ><a href="UpdateLetsMeet.jsp" data-hover="Gallery">Update My Event</a></li>
											<li><a href="ShowMyLetsMeet.ar" data-hover="Gallery">My Events</a></li>
										<!-- 								<li><a href="SearchLetsMeet.jsp" data-hover="Gallery" >Search -->
<!-- 										Event</a></li> -->
										
										<li class="dropdown"><a href="Home.jsp"
									class="dropdown-toggle" data-hover="Pages"
									data-toggle="dropdown">Search
										Event <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="SearchByLocation.jsp">Search By Location</a></li>
										<li><a href="SearchByCategory.jsp">Search By Category</a></li>
<!-- 										<li><a href="SearchByDate.jsp">Search By Date</a></li> -->
									</ul></li>
										<li class="dropdown"><a href="Home.jsp"
									class="dropdown-toggle" data-hover="Pages"
									data-toggle="dropdown">Requests <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="sentrequests.ar">Sent Requests</a></li>
										<li><a href="recievedrequests.ar">Recieved Requests</a></li>
									</ul></li>
							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</div>

					<div class="header-left animated wow fadeInLeft animated"
						data-wow-delay=".5s">
						<ul>
							<li><i class="glyphicon glyphicon-envelope"></i><a
								href="mailto:info@example.com">letsplan@iacsd.com</a></li>
							<li><i class="glyphicon glyphicon-earphone"></i>+918960779292</li>
						<li><form action="getuserdetails.ar" ><button class="btn btn-link" name="btname" value="<%= name %>"><i class="glyphicon glyphicon-user"></i>Welcome <%= name %></button></form></li>	
						<li><form action="getusernotifications.ar">
									<button class="btn btn-link" name="btname" value="<%=name%>">
										<i class="glyphicon glyphicon-globe"></i>Notifications
										</button>
								</form></li>
							<li><i class="glyphicon glyphicon-log-out"></i><a href="signout.ar">Sign Out</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			
			<br><br>
			<font color="red"><b>${ msg }</b></font>
			
			
			<div
				style="margin-top: 50px; margin-left: 200px; height: 200px; width: 500px;">
	
		<form action="myletsmeetsearchl.ar" id="form1">

		<fieldset>
<!-- 			<div -->
<!-- 				style="margin-top: 150px; margin-left: 400px; height: 400px; width: 500px;"> -->
			
			
			
			<div class="form-group">
					<label class="col-md-4 control-label" for="txt5">Search By Location</label>
					<div class="col-md-6">
						<input id="mlocationcity" name="mlocationcity" type="text" required
							placeholder="" class="form-control input-md">

					</div>
				</div>
			
			
				<!-- 				Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="bt1"></label>
					<div class="col-md-8">
						<button id="bt1" name="bt1" class="btn btn-success" type="submit">Search Event</button>
					</div>
				</div>
				<br> <br>
			
			
<!-- 			</div> -->
				
		</fieldset>
	</form>

			</div>
			
			
			

<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="agile-footer-grids">
				<div class="col-md-4 agile-footer-grid">
					<h4>History of Lets Plan</h4>
					<p>
						It’s experiences, not things, that provide the lasting memories.
						Events are organized experiences and we want more of them to exist
						in this world by inspiring and empowering the passionate people
						that create them. 
					</p>
				</div>
				
				<div class="col-md-4 agile-footer-grid">
					<h4>Popular Items</h4>
					<div class="popular-grids">
						<div class="popular-grid">
							<a href="#"><img src="images/5.jpg" alt=""></a>
						</div>
						<div class="popular-grid">
							<a href="#"><img src="images/6.jpg" alt=""></a>
						</div>
						<div class="popular-grid">
							<a href="#"><img src="images/7.jpg" alt=""></a>
						</div>
						<div class="popular-grid">
							<a href="#"><img src="images/8.jpg" alt=""></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="popular-grids">
						<div class="popular-grid">
							<a href="#"><img src="images/9.jpg" alt=""></a>
						</div>
						<div class="popular-grid">
							<a href="#"><img src="images/10.jpg" alt=""></a>
						</div>
						<div class="popular-grid">
							<a href="#"><img src="images/2.jpg" alt=""></a>
						</div>
						<div class="popular-grid">
							<a href="#"><img src="images/3.jpg" alt=""></a>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="copyright">
			<p>
				© 2017 Lets Plan. All rights reserved | Design by <a
					href="http://w3layouts.com">Abhishek & Raj</a>
			</p>
		</div>
	</div>
	<!-- //footer -->
	<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
	<!-- //here ends scrolling icon -->s

</body>
</html>