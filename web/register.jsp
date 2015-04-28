<body>
	<%@ include file="header_01.jsp"%>
	<section class="subHeader page">
		<div class="container">
			<h1>Register Form</h1>
			<form class="searchForm" method="post" action="#">
				<input type="text" name="search" value="Search our site" />
			</form>
		</div>
		<!-- end subheader container -->
	</section>
	<!-- end subheader section -->

	<!-- start main content -->
	<section class="properties">
		<div class="container">
			<div class="row">

				<div class="col-lg-4 col-lg-offset-4">
					<h3>REGISTER</h3>
					<div class="divider"></div>
					<p style="font-size: 13px;">
						Already have an account? <a href="login.jsp">Login here!</a>
					</p>
					<!-- start login form -->
					<div class="sidebarWidget">
					<label id="msg_label" style="width: 100%"></label>
						<form method="post" action="#" id="userForm">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-6">
									<div class="formBlock">
										<label for="Name">Name</label><br /> <input type="text"
											name="name" id="name" onkeydown="return isLetters(event)" />
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-6">
									<div class="formBlock">
										<label for="username">Username</label><br /> <input type="text"
											name="username" id="username" />
									</div>
								</div>
								
								<div class="col-lg-12 col-md-12 col-sm-6">
									<div class="formBlock">
										<label for="pass">Password</label><br /> <input
											type="password" name="password" id="password" />
									</div>
								</div>
								
								<div class="col-lg-12 col-md-12 col-sm-6">
									<div class="formBlock">
										<label for="phone">Phone</label><br /> <input type="text"
											name="phone" maxlength="10" id="phone" onkeydown="return isNumber(event)" />
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-6">
									<div class="formBlock">
										<label for="email">Email</label><br /> <input type="text"
											name="email" id="email" />
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-6">
									<div class="formBlock">
										<label for="city">City</label><br /> <input type="text"
											name="city" id="city" />
									</div>
								</div>
								

								<div class="col-lg-12 col-md-12 col-sm-6">
									<div class="formBlock">
										<input class="buttonColor" id="regBtn" type="button"
											value="REGISTER" style="margin-top: 24px;">
									</div>
								</div>
								<div style="clear: both;"></div>
							</div>
							<!-- end row -->
						</form>
						<!-- end form -->
						<div id="emp_output"></div>
					</div>
					<!-- end login form -->
				</div>
				<!-- end col -->

			</div>
		</div>
		<!-- end container -->
	</section>
	<!-- end main content -->

	<!-- start call to action -->
	<section class="callToAction" style="padding-top: 70px;">
		<div class="container">
			<div class="ctaBox">
				<div class="col-lg-9">
					<h1>
						Get started today for a <span>free</span> home evaluation!
					</h1>
					<p>Lorem ipsum dolor amet, consectetur adipiscing elit. Quisque
						eget ante vel nunc lorem ipsum rhoncus.</p>
				</div>
				<div class="col-lg-3">
					<a style="float: right; margin-top: 15px;" class="buttonColor"
						href="#">CONTACT US</a>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
	</section>
	<!-- end call to action -->

	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-6">
					<h4>
						<a class="footerLogo" href="#"><img src="images/logoGreen.png"
							alt="Easy Living" />EASY <span>LIVING</span></a>
					</h4>
					<p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut
						purus eget nunc ut dignissim cursus at a nisl. Mauris vitae turpis
						quis eros egestas tempor sit amet a arcu. Duis egestas hendrerit
						diam.</p>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6">
					<h4>CONTACT</h4>
					<ul class="contactList">
						<li><img class="icon" src="images/icon-pin.png" alt="" />
							123 Smith Drive, Arnold, Maryland</li>
						<li><img class="icon" src="images/icon-phone.png" alt="" />
							+1 234 567 8901</li>
						<li><img class="icon" src="images/icon-mail.png" alt="" />
							hello@thriveTheme.com</li>
					</ul>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6">
					<h4>TWITTER</h4>
					<ul>
						<li><a href="#">@JohnDoe</a> Lorem ipsum dolor amet,
							adipiscing elit. Maecenas eget tellus.<br /> <span>5
								MINUTES AGO</span></li>
						<li><a href="#">@JohnDoe</a> Lorem ipsum dolor amet,
							adipiscing elit. Maecenas eget tellus.<br /> <span>5
								MINUTES AGO</span></li>
					</ul>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6">
					<h4>NEWSLETTER</h4>
					<p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut
						purus eget nunc ut dignissim cursus at a nisl.</p>
					<form class="subscribeForm" method="post" action="#">
						<input type="text" name="email" value="Your email"
							class="input footer" /> <input type="submit" name="submit"
							value="SEND" class="buttonColor" />
					</form>
				</div>
			</div>
			<!-- end row -->
		</div>
		<!-- end footer container -->
	</footer>

	<div class="bottomBar">
		<div class="container">
			<p>EASY LIVING REAL ESTATE THEME COPYRIGHT 2013</p>
			<ul class="socialIcons">
				<li><a href="#"><img src="images/icon-fb.png" alt="" /></a></li>
				<li><a href="#"><img src="images/icon-twitter.png" alt="" /></a></li>
				<li><a href="#"><img src="images/icon-google.png" alt="" /></a></li>
				<li><a href="#"><img src="images/icon-rss.png" alt="" /></a></li>
			</ul>
		</div>
	</div>

	


	<!-- JavaScript file links -->
	<script src="js/jquery.js"></script>
	<!-- Jquery -->
	<script src="js/bootstrap.min.js"></script>
	<!-- bootstrap 3.0 -->
	<script src="js/respond.js"></script>

<!-- <script src="js/code/jquery-1.3.1.min.js"></script> -->

<script src="js/code/dhtmlxcommon.js"></script>
	<script src="js/code/json2.js"></script>
	<script src="js/code/user_fn_1.3.1.min.js"></script>


</body>
</html>