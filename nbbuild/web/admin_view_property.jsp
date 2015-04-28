<%@page import="com.opr.bean.PropertyBean"%>
<%@page import="com.opr.model.SearchModel"%>
<%@include file="header_02.jsp"%>
<%@ page errorPage="error.jsp"%>
<!-- End Header -->
<!-- start subheader -->
<body>
    <section class="subHeader page">
        <div class="container">
            <h1>Property Single</h1>
            <form class="searchForm" method="post" action="#">
                <input type="text" name="search" value="Search our site" />
            </form>
        </div><!-- end subheader container -->
    </section><!-- end subheader section -->

    <!-- start main content section -->
    <section class="properties">
        <div class="container">
            <div class="row">
                <%
                    String propId = request.getParameter("prop_id");
                    PropertyBean bean = new SearchModel().getPropertyListById(propId);
                    if (bean != null) {
                %>
                <!-- start content -->
                <div class="col-lg-9 col-md-9">
                    <div class="gallery">
                        <ul class="bxslider2">
                            <li><img
                                    src="<%=AppConstants.REAL_FOLDER + "/"
                                            + AppConstants.PHOTO_ONE + propId%>.jpg"
                                    alt="" /></li>
                            <li><img
                                    src="<%=AppConstants.REAL_FOLDER + "/"
                                            + AppConstants.PHOTO_TWO + propId%>.jpg"
                                    alt="" /></li>
                            <li><img
                                    src="<%=AppConstants.REAL_FOLDER + "/"
                                            + AppConstants.PHOTO_THREE + propId%>.jpg"
                                    alt="" /></li>
                            <li><img
                                    src="<%=AppConstants.REAL_FOLDER + "/"
                                            + AppConstants.PHOTO_FOUR + propId%>.jpg"
                                    alt="" /></li>
                            <li><div style="background-color:white; height: 320px;width: 100%">
                                    <video width="100%" height="100%" controls="controls">
                                        <source
                                            src="VIDEO/891067.MP4"
                                            type="video/MP4" id="vlc" loop="yes" autoplay="yes"/>
                                    </video>
                                </div></li>
                        </ul>

                        <div id="bx-pager">
                            <a data-slide-index="0" href=""> <img
                                    src="<%=AppConstants.NAVIGATE_FOLDER + "/"
                                            + AppConstants.PHOTO_ONE + propId%>.jpg"
                                    alt="" /></a> <a data-slide-index="1" href=""> <img
                                    src="<%=AppConstants.NAVIGATE_FOLDER + "/"
                                            + AppConstants.PHOTO_TWO + propId%>.jpg"
                                    alt="" /></a> <a data-slide-index="2" href=""> <img
                                    src="<%=AppConstants.NAVIGATE_FOLDER + "/"
                                            + AppConstants.PHOTO_THREE + propId%>.jpg"
                                    alt="" /></a> <a data-slide-index="3" href=""> <img
                                    src="<%=AppConstants.NAVIGATE_FOLDER + "/"
                                            + AppConstants.PHOTO_FOUR + propId%>.jpg"
                                    alt="" /></a> <a data-slide-index="3" href=""><img
                                    src="images/blog-thumb4.jpg" alt="" /></a>
                        </div>
                        <div class="sliderControls">
                            <span class="slider-prev"></span> <span class="slider-next"></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="overview">
                                <h4>OVERVIEW</h4>
                                <ul class="overviewList">
                                    <li>Property Type <span><%=bean.getPropType()%></span></li>
                                    <li>Contract Type <span><%=bean.getContractType()%></span></li>
                                    <li>Owner <span><%=bean.getUsername()%></span></li>
                                    <li>Size <span><%=bean.getArea()%></span></li>
                                    <li>Bedrooms <span><%=bean.getBathrooms()%></span></li>
                                    <li>Bathrooms <span><%=bean.getBathrooms()%></span></li>
                                    <li>City <span><%=bean.getCity()%></span></li>
                                </ul>
                            </div>
                            <div id="map-canvas-one-pin" class="mapSmall"></div>
                        </div>
                        <div class="col-lg-8">
                            <p class="price" style="float: right;">
                                $<%=bean.getPrice()%></p>
                            <p class="forSale" style="float: right; margin-right: 20px;"><%=bean.getContractType()%>
                            </p>
                            <h1><%=bean.getPropTitle()%></h1>
                            <p><%=bean.getAddress()%></p>
                            <!--                         <p>Baltimore, MD</p> -->
                            <!--                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vehicula dapibus  -->
                            <!--                         mauris, quis ullamcorper enim aliquet sed. Maecenas quis eget tellus dui. Vivamus  -->
                            <!--                         condimentum egestas.</p> -->
                            <!--                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam euismod  -->
                            <!--                         sollicitudin nunc, eget pretium massa. Ut sed adipiscing enim, pellentesque ultrices  -->
                            <!--                         erat. Integer placerat felis neque, et semper augue ullamcorper in. Pellentesque  -->
                            <!--                         iaculis leo iaculis aliquet ultrices. Suspendisse potenti. Aenean ac magna faucibus,  -->
                            <!--                         consectetur ligula vel, feugiat est. Nullam imperdiet semper neque eget euismod.  -->
                            <!--                         Nunc commodo volutpat semper.</p><br/> -->
                            <br />
                            <h4>GENERAL AMENTITIES</h4>
                            <div class="divider thin"></div>
                            <table class="amentitiesTable">
                                <tr>
                                    <td>
                                        <%
                                            if (bean.getAc().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Air
                                        Conditioning <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Air
                                        Conditioning <%                                                                                    }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getCoffee().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />CoffeePot
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />CoffeePot <%     }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getHeating().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Heating
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Heating <%     }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getParking().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Parking
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Parking <%     }
                                        %>
                                    </td>


                                </tr>
                                <tr>
                                    <td>
                                        <%
                                            if (bean.getBalcony().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Balcony
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Balcony <%     }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getInternet().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Internet
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Internet <%     }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getPool().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Pool
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Pool <%     }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getBedding().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Bedding
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Bedding <%     }
                                        %>
                                    </td>


                                </tr>
                                <tr>

                                    <td>
                                        <%
                                            if (bean.getFridge().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Fridge
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Fridge <%     }
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if (bean.getMicrowave().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Microwave
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Microwave <%     }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getCable().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Cable
                                        TV <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Cable TV <%     }
                                        %>
                                    </td>

                                    <td>
                                        <%
                                            if (bean.getOven().equals(AppConstants.IS_ON)) {
                                        %> <img class="icon" src="images/icon-check.png" alt="" />Oven
                                        <%                                                                                } else {
                                        %> <img class="icon" src="images/icon-cross.png" alt="" />Oven <%     }
                                        %>
                                    </td>



                                </tr>

                            </table><br/>
                        </div><!-- end col -->

                        <!-- <div class="col-lg-2">
                                     <a style="float:right; margin-top:15px;" class="buttonColor" href="#">REJECT</a>
                             </div> -->
                        <%
                            if (bean.getStatus().equals(AppConstants.APPROVED)) {
                        %>
                        <div class="col-lg-8">
                            <a style="float:right; margin-top:15px;margin-left:10px;" class="buttonColor" href="AdminDeleteProperty?prop_id=<%=bean.getPropertyId()%>">REJECT</a>
                        </div>
                        <%} else {
                        %>                        <div class="col-lg-8">
                            <a style="float:right; margin-top:15px;margin-left:10px;" class="buttonColor" href="AdminDeleteProperty?prop_id=<%=bean.getPropertyId()%>">REJECT</a>
                            <a style="float:right; margin-top:15px;" class="buttonColor" href="AdminAcceptProperty?prop_id=<%=bean.getPropertyId()%>">SUBMIT</a>    
                        </div>
                        <%}%>

                    </div><!-- end row -->

                    <!-- start related properties -->
                    <h4>Submit if you like.</h4>

                    <div class="divider thin"></div>
                    <div class="row"></div><!-- end related properties row -->

                </div><!-- end content -->

                <%
                } else {
                %>
                <div class="col-lg-9 col-md-9">
                    <p>
                        Sorry, the page you are looking for cannot be found!<br /> Trying
                        search for a page or return to the <a href="index.jsp">home
                            page.</a>
                    </p>
                </div>
                <%                                    }
                %>

                <!-- start sidebar -->
                <div class="col-lg-3 col-md-3">
                    <!-- start quick search widget -->
                    <h3>QUICK SEARCH</h3>
                    <div class="divider"></div>
                    <div class="filterContent sidebarWidget">
                        <form method="post" action="#">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock select">
                                        <label for="propertyType">Property Type</label><br/>
                                        <select name="property type" id="propertyType" class="formDropdown">
                                            <option value="">Any</option>
                                            <option value="Country2">Family Home</option>
                                            <option value="Country3">Apartment</option>
                                            <option value="Country4">Condo</option>
                                            <option value="Country5">Villa</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock select">
                                        <label for="location">Location</label><br/>
                                        <select name="location" id="location" class="formDropdown">
                                            <option value="">Any</option>
                                            <option value="Country2">Option 1</option>
                                            <option value="Country3">Option 2</option>
                                            <option value="Country4">Option 3</option>
                                            <option value="Country5">Option 4</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock select">
                                        <label for="price">Price Range</label><br/>
                                        <select name="price" id="price" class="formDropdown">
                                            <option value="">Any</option>
                                            <option value="Country2">Option 1</option>
                                            <option value="Country3">Option 2</option>
                                            <option value="Country4">Option 3</option>
                                            <option value="Country5">Option 4</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <input class="buttonColor" type="submit" value="FIND PROPERTIES" style="margin-top:24px;">
                                    </div>
                                </div>
                                <div style="clear:both;"></div>
                            </div><!-- end row -->
                        </form><!-- end form -->
                    </div><!-- end quick search widget -->

                    <!-- start recent posts widget -->
                    <h3>RECENT POSTS</h3>
                    <div class="divider"></div>
                    <div class="recentPosts sidebarWidget">
                        <h4><a href="#">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                        <a href="#">READ MORE</a>
                        <p class="date">Feb 5, 2014</p>
                        <div style="clear:both;"></div>
                        <div class="divider thin"></div>
                        <h4><a href="#">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                        <a href="#">READ MORE</a>
                        <p class="date">Feb 5, 2014</p>
                        <div style="clear:both;"></div>
                        <div class="divider thin"></div>
                        <h4><a href="#">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                        <a href="#">READ MORE</a>
                        <p class="date">Feb 5, 2014</p>
                        <div style="clear:both;"></div>
                    </div>
                    <!-- end recent posts widget -->

                    <!-- start property types widget -->
                    <h3>PROPERTY TYPES</h3>
                    <div class="divider"></div>
                    <div class="propertyTypesWidget sidebarWidget">
                        <ul>
                            <li><h4><a href="#">FAMILY HOUSE</a></h4></li>
                            <li><h4><a href="#">SINGLE HOUSE</a></h4></li>
                            <li><h4><a href="#">APARTMENT</a></h4></li>
                            <li><h4><a href="#">CONDO</a></h4></li>
                            <li><h4><a href="#">VILLA</a></h4></li>
                            <li><h4><a href="#">OFFICE BUILDING</a></h4></li>
                        </ul>
                    </div>
                    <!-- end property types widget -->

                </div><!-- end col -->
            </div><!-- end row -->

        </div><!-- end container -->
    </section>
    <!-- end main content -->

    <!-- start call to action --><!-- end call to action -->

    <div class="bottomBar">
        <div class="container">
            <p>ONLINE PLOT RENTAL COPYRIGHT 2013</p>
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
    <script src="js/jquery.bxslider.min.js"></script>           <!-- bxslider -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAqb3fT3SbMSDMggMEK7fJOIkvamccLrjA&sensor=false"></script><!-- google maps -->
    <script type="text/javascript" src="js/map-one-pin.js"></script> <!-- map script -->
    <script>
        $('.bxslider2').bxSlider({
            pagerCustom: '#bx-pager',
            nextSelector: '.slider-next',
            prevSelector: '.slider-prev',
            nextText: '<img src="images/slider-next2.png" alt="Next" />',
            prevText: '<img src="images/slider-prev2.png" alt="Previous" />'
        });
    </script>

</body>
</html>