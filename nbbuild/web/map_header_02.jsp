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
                            href="admin_home.jsp" class="current">HOME</a>
                        <ul class="dropdown-menu">
                            <li><a href="admin_home.jsp" class="current-sub">Home
                                    Horizontal Filter</a></li>
                            <li><a href="admin_home_map.jsp">Home Map</a></li>
                        </ul></li>

                    <li class="dropdown menu-item-has-children"><a
                            href="admin_view_list.jsp">REQUEST</a>
                        <ul class="dropdown-menu">
                            <li><a href="admin_view_list.jsp">Property List</a></li>
                            <li><a href="admin_view_booked_list.jsp">Booked List</a></li>
                        </ul></li>

                   <li class="dropdown menu-item-has-children"><a
                            href="admin_view_clients_list.jsp">LISTINGS</a>
                        <ul class="dropdown-menu">
                            <li><a href="admin_view_clients_list.jsp">CLients</a></li>
                            <li><a href="admin_listing_grid_masonry.jsp">Building Gallery</a></li>
                            <li><a href="admin_listing_grid_plot.jsp">Plot Gallery</a></li>
                        </ul>
                   </li>

                    <li class="dropdown menu-item-has-children"><a
                            href="admin_submit_property.jsp">SUBMIT</a>
                        <ul class="dropdown-menu">
                            <li><a href="admin_submit_property.jsp">Submit Property</a></li>
                            <li><a href="admin_submit_plot.jsp">Submit Plot</a></li>
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

        <style>
            html,body,#mapDiv {
                height: 70%;
                margin: 0px;
                padding: 0px
            }

            .controls {
                margin-top: 16px;
                border: 1px solid transparent;
                border-radius: 2px 0 0 2px;
                box-sizing: border-box;
                -moz-box-sizing: border-box;
                height: 32px;
                outline: none;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
            }

            #pac-input {
                background-color: #fff;
                padding: 0 11px 0 13px;
                width: 400px;
                font-family: Roboto;
                font-size: 15px;
                font-weight: 300;
                text-overflow: ellipsis;
            }

            #pac-input:focus {
                border-color: #4d90fe;
                margin-left: -1px;
                padding-left: 14px; /* Regular padding-left + 1. */
                width: 401px;
            }

            .pac-container {
                font-family: Roboto;
            }

            #type-selector {
                color: #fff;
                background-color: #4d90fe;
                padding: 5px 11px 0px 11px;
            }

            #type-selector label {
                font-family: Roboto;
                font-size: 13px;
                font-weight: 300;
            }
        </style>
        <script  src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>

        <style type="text/css">
            #target {
                width: 345px;
            }
        </style>

    </header>

    <%
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Expires", "0");
        response.setDateHeader("Expires", -1);

        LoginBean bean = (LoginBean) session.getAttribute(AppConstants.SESSION);
        String username = "";
        if (bean == null || session == null) {
            response.sendRedirect("index.jsp");
        } else if (bean != null
                && !bean.getUserType().equals(AppConstants.TYPE_ADMIN)) {
            response.sendRedirect("index.jsp");
        } else {
            username = bean.getUsername();
        }
    %>