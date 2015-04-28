<%@ include file="header_01.jsp" %>
<body>

<!-- Start Header -->
<!-- start subheader -->
<section class="subHeader page">
    <div class="container">
    	<h1>Login Form</h1>
    	<form class="searchForm" method="post" action="#">
            <input type="text" name="search" value="Search our site" />
        </form>
    </div><!-- end subheader container -->
</section><!-- end subheader section -->

<!-- start main content -->
<section class="properties">
    <div class="container">
        <div class="row">

            <div class="col-lg-4 col-lg-offset-4">
                <h3>LOGIN</h3>
                <div class="divider"></div>
   <!--       <p style="font-size:13px;">Don't have an account yet? <a href="register.html">Register here!</a></p> -->
                <!-- start login form -->
                <!--<div class="filterContent sidebarWidget"> -->
                <div class="sidebarWidget"> 
                    <form method="post" action="LoginServlet">
                        <div class="row" >
                            <div class="col-lg-12 col-md-12 col-sm-6">
                                <div class="formBlock">
                                <label for="login">Login</label><br/>
                                <input type="text" name="username" id="username" />
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-6">
                                <div class="formBlock">
                                <label for="pass">Password</label><br/>
                                <input type="password" name="password" id="password" />
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-6">
                                <div class="formBlock">
                                    <input class="buttonColor" type="submit" value="LOGIN" style="margin-top:24px;">
                                </div>
                            </div>
                            <div style="clear:both;"></div>
                        </div><!-- end row -->
                    </form><!-- end form -->
               </div><!-- end login form -->
            </div><!-- end col -->
            
        </div>
    </div><!-- end container -->
</section>
<!-- end main content -->

<!-- start call to action -->

<!-- end call to action -->
<!-- end footer container -->


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
<script src="js/jquery.js"></script>			<!-- Jquery -->
<script src="js/bootstrap.min.js"></script>  <!-- bootstrap 3.0 -->
<script src="js/respond.js"></script>

</body>
</html>