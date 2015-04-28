<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.opr.model.SearchModel"%>
<!DOCTYPE html>
<%@page import="com.opr.bean.LoginBean"%>
<%@page import="com.opr.utils.AppConstants"%>
<%@page errorPage="error.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="description"
              content="Easy Living - Responsive Real Estate Template">
        <meta name="keywords"
              content="Themes, real estate, responsive, themeforest, Templates">
        <meta name="author" content="Rype Pixel [Chris Gipple]">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Easy Living | OPR</title>
        <!-- html5 support in IE8 and later -->
        <script src="js/html5.js"></script>
        <!-- CSS file links -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/jquery.bxslider.css" rel="stylesheet" media="screen">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"
              media="all" />
        <link href="css/yamm.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/jquery.nouislider.min.css" rel="stylesheet"
              type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:700'
              rel='stylesheet' type='text/css'>
    </head>

    <header class="navbar yamm navbar-default navbar-fixed-top">
        <div class="topBar">
            <div class="container">
                <p class="topBarText">
                    <img class="icon" src="images/icon-phone.png" alt="" />1-800-192-0978
                </p>
                <p class="topBarText">
                    <img class="icon" src="images/icon-mail.png" alt="" />opr.infos@gmail.com
                </p>
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
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target=".navbar-collapse">
                    <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="images/logoGreen.png"
                                                      alt="Easy Living" />ONLINE PLOT <span>RENTAL</span></a>
            </div>
            <div class="navbar-collapse collapse">

                <!--  start login/register -->
                <!--         <ul class="userButtons">   -->
                <!--             <li class="userBtn"><a href="#" class="buttonGrey">LOGIN</a></li> -->
                <!--             <li class="userBtn"><a href="#" class="buttonGrey">REGISTER</a></li> -->
                <!--         </ul> -->
                <!-- end login/register -->

                <ul class="nav navbar-nav">
                    <li class="dropdown menu-item-has-children"><a
                            href="user_home.jsp" class="current">HOME</a>
                        <ul class="dropdown-menu">
                            <li><a href="user_home.jsp" class="current-sub">Home
                                    Horizontal Filter</a></li>
                            <li><a href="user_home_map.jsp">Home Map</a></li>
                        </ul></li>

                    <li class="dropdown menu-item-has-children"><a
                            href="user_property_list.jsp">PROPERTY</a>
                        <ul class="dropdown-menu">
                            <li><a href="user_property_list.jsp">Property List</a></li>
                            <li><a href="user_plot_list.jsp">Plot List</a></li>
                        </ul></li>



                    <li class="dropdown menu-item-has-children"><a
                            href="user_submit_property.jsp">SUBMIT</a>
                        <ul class="dropdown-menu">
                            <li><a href="user_submit_property.jsp">Submit Property</a></li>
                            <li><a href="user_submit_plot.jsp">Submit Plot</a></li>
                        </ul></li>

                    <li class="dropdown menu-item-has-children"><a
                            href="LogoutServlet">LOGOUT</a>
                        <ul class="dropdown-menu">
                            <li><a href="LogoutServlet">Sign out</a></li>
                        </ul></li>


                </ul>
            </div>
            <!--/.navbar-collapse -->
        </div>
        <!-- end header container -->
    </header>

    <%
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Expires", "0");
        response.setDateHeader("Expires", -1);
        String username = "";
        LoginBean loginBean = (LoginBean) session.getAttribute(AppConstants.SESSION);
        if (loginBean == null || session == null) {
            response.sendRedirect("index.jsp");
        } else if (loginBean != null
                && !loginBean.getUserType().equals(AppConstants.TYPE_USER)) {
            response.sendRedirect("index.jsp");
        } else {
            username = loginBean.getUsername();
        }
        JSONArray cityArray = new SearchModel().getCity();
        JSONArray areaArray = new SearchModel().getAreaSqft();
        JSONArray priceArray = new SearchModel().getPriceRange();
    %>