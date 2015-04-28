<%@ include file="header_01.jsp" %>
<body>
<section class="subHeader page">
    <div class="container">
    	<h1>Page Not Found</h1>
    	<form class="searchForm" method="post" action="#">
            <input type="text" name="search" value="Search our site" />
        </form>
    </div><!-- end subheader container -->
</section><!-- end subheader section -->

<!-- start main content -->
<section class="properties">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3 error-404">
                <h1>404</h1><br/><br/>
                <p>Sorry, the page you are looking for cannot be found!<br/>
                Trying search for a page or return to the <a href="index.jsp">home page.</a></p><br/>
                <form method="post" action="#">
                    <input type="text" name="search" value="Search our site" />
                </form>
            </div>
        </div>
    </div><!-- end container -->
</section>
<!-- end main content -->

<!-- start call to action -->
<section class="callToAction" style="padding-top:70px;">
    <div class="container">
        <div class="ctaBox">
            <div class="col-lg-9">
                <h1>Get started today for a <span>free</span> home evaluation!</h1>
                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Quisque eget ante vel nunc lorem ipsum rhoncus.</p>
            </div>
            <div class="col-lg-3">
                <a style="float:right; margin-top:15px;" class="buttonColor" href="#">CONTACT US</a>
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
</section>
<!-- end call to action -->

<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4><a class="footerLogo" href="#"><img src="images/logoGreen.png" alt="Easy Living" />EASY <span>LIVING</span></a></h4>
                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut 
                purus eget nunc ut dignissim cursus at a nisl. Mauris vitae 
                turpis quis eros egestas tempor sit amet a arcu. Duis egestas 
                hendrerit diam.</p>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4>CONTACT</h4>
                <ul class="contactList">
                    <li><img class="icon" src="images/icon-pin.png" alt="" /> 123 Smith Drive, Arnold, Maryland</li>
                    <li><img class="icon" src="images/icon-phone.png" alt="" /> +1 234 567 8901</li>
                    <li><img class="icon" src="images/icon-mail.png" alt="" /> hello@thriveTheme.com</li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4>TWITTER</h4>
                <ul>
                    <li><a href="#">@JohnDoe</a> Lorem ipsum dolor amet, 
                    adipiscing elit. Maecenas eget tellus.<br/><span>5 MINUTES AGO</span></li>
                    <li><a href="#">@JohnDoe</a> Lorem ipsum dolor amet, 
                    adipiscing elit. Maecenas eget tellus.<br/><span>5 MINUTES AGO</span></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6">
                <h4>NEWSLETTER</h4>
                <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Sed ut 
                purus eget nunc ut dignissim cursus at a nisl.</p>
                <form class="subscribeForm" method="post" action="#">
                    <input type="text" name="email" value="Your email" class="input footer" />
                    <input type="submit" name="submit" value="SEND" class="buttonColor" />
                </form>
            </div>
        </div><!-- end row -->
    </div><!-- end footer container -->
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
<script src="js/jquery.js"></script>			<!-- Jquery -->
<script src="js/bootstrap.min.js"></script>  <!-- bootstrap 3.0 -->
<script src="js/respond.js"></script>

</body>
</html>