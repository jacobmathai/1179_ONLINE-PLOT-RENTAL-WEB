<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.opr.model.SearchModel"%>
<%@page import="com.opr.bean.LoginBean"%>
<%@page import="com.opr.utils.AppConstants"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="description" content="Easy Living - Responsive Real Estate Template">
        <meta name="keywords" content="Themes, real estate, responsive, themeforest, Templates">
        <meta name="author" content="Rype Pixel [Chris Gipple]">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Easy Living | OPR</title>
        <!-- html5 support in IE8 and later -->
        <script src="js/html5.js"></script>
        <!-- CSS file links -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/jquery.bxslider.css" rel="stylesheet" media="screen">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/yamm.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/jquery.nouislider.min.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:700' rel='stylesheet' type='text/css'/>
    </head>

    <header class="navbar yamm navbar-default navbar-fixed-top">
        <div class="topBar">
            <div class="container">
                <p class="topBarText"><img class="icon" src="images/icon-phone.png" alt="" />1-800-192-0978</p>
                <p class="topBarText"><img class="icon" src="images/icon-mail.png" alt="" />opr.infos@gmail.com</p>
                <ul class="socialIcons">
                    <li class="topBarText"><a href="login.jsp">Login</a></li>
                    <li class="topBarText"><a href="register.jsp">Register</a></li>
                    <li><a href="#"><img src="images/icon-fb.png" alt="" /></a></li>
                    <li><a href="#"><img src="images/icon-twitter.png" alt="" /></a></li>
                    <li><a href="#"><img src="images/icon-google.png" alt="" /></a></li>
                    <li><a href="#"><img src="images/icon-rss.png" alt="" /></a></li>
                </ul>
            </div>
        </div>
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="images/logoGreen.png" alt="Easy Living" />ONLINE PLOT <span>RENTAL</span></a>
            </div>
            <div class="navbar-collapse collapse">

                <!--  start login/register -->
                <ul class="userButtons">  
                    <li class="userBtn"><a href="login.jsp" class="buttonGrey">LOGIN</a></li>
                    <li class="userBtn"><a href="register.jsp" class="buttonGrey">REGISTER</a></li>
                </ul>
                <!-- end login/register -->

                <ul class="nav navbar-nav">
                    <li class="dropdown menu-item-has-children">
                        <a href="index.jsp">HOME</a>
                        <ul class="dropdown-menu">
                            <li><a href="index.jsp">Home Horizontal Filter</a></li>
                            <li><a href="home_map.jsp">Home Map</a></li>
                        </ul>
                    </li>
<!--                    <li class="dropdown menu-item-has-children">
                        <a href="blog_classic.jsp">BLOG</a>
                        <ul class="dropdown-menu">
                            <li><a href="blog_classic.jsp">Blog Classic</a></li>
                        </ul>
                    </li>-->
                    <li class="dropdown menu-item-has-children">
                        <a href="about.jsp">PAGES</a>
                        <ul class="dropdown-menu">
                            <li><a href="about.jsp">About</a></li>
                        </ul>
                    </li>

                    <li class="dropdown menu-item-has-children">
                        <a href="contact.jsp">CONTACT</a>
                        <ul class="dropdown-menu">
                            <li><a href="contact.jsp">Contact</a></li>
                        </ul>
                    </li>
                </ul>        
            </div><!--/.navbar-collapse -->
        </div><!-- end header container -->
    </header>
    <%
       
        JSONArray cityArray = new SearchModel().getCity();
        JSONArray areaArray = new SearchModel().getAreaSqft();
        JSONArray priceArray = new SearchModel().getPriceRange();
    %>