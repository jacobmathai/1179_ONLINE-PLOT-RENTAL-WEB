<%@page import="org.json.simple.JSONObject"%>
<%@include file="header_01.jsp" %>
<%@page  errorPage="error.jsp" %>
<body>

    <!-- start subheader -->
    <section class="subHeader map">
        <div id="map-canvas"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-lg-offset-7 col-md-5 col-md-offset-7 col-sm-5 col-sm-offset-7 mapFilter">
                    <div class="filterHeader">
                        <ul class="filterNav tabs">
                            <li><a class="current triangle" href="#tab1">ALL</a><span class="arrow-down"></span></li>
                            <li><a href="#tab2">FOR SALE</a></li>
                            <li><a href="#tab3">FOR RENT</a></li>
                        </ul>
                    </div>
                    <div class="filterContent" id="tab1">
                        <form id="defaultForm" method="post" action="#">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="propertyType">Property Type</label><br/>
                                        <select name="property type" id="propertyType" class="formDropdown">
                                            <option>Any</option>
                                            <option value="SINGLE_HOUSE">SINGLE HOUSE</option>
                                            <option value="FAMILY_HOUSE">FAMILY HOUSE</option>
                                            <option value="VILLA">VILLA</option>
                                            <option value="APARTMENT">APARTMENT</option>
                                            <option value="BUNGALOW">BUNGALOW</option>
                                            <option value="OFFICE_BUILDING">OFFICE BUILDING</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="location">Location</label><br/>
                                        <select name="location" id="location" class="formDropdown">
                                            <option>Any</option>
                                            <%

                                                for (Object obj : cityArray) {
                                                    JSONObject jSONObj = (JSONObject) obj;
                                            %>
                                            <option ><%= jSONObj.get("city")%></option>
                                            <%  }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                  <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="price">Price Range</label><br/>
                                        <select name="charge" id="charge" class="formDropdown">
                                            <option>Any</option>
                                            <option value="$200,000">$200,000</option>
                                            <option value="$300,000">$300,000</option>
                                            <option value="$400,000">$400,000</option>
                                            <option value="$500,000">$500,000</option>
                                            <option value="$600,000">$600,000</option>
                                            <option value="$700,000">$700,000</option>
                                            <option value="$900,000">$900,000</option>
                                            <option value="$1,000,000">$1,000,000</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="beds">Beds</label><br/>
                                        <select name="beds" id="beds" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="baths">Baths</label><br/>
                                        <select name="baths" id="baths" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="area">Area (Sq Ft)</label><br/>
                                        <select name="area" id="area" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="formBlock">
                                        <input class="buttonColor" type="button" id="searchBtn1" value="FIND PROPERTIES" style="margin-top:24px;"/>
                                    </div>
                                </div>
                                <div style="clear:both;"></div>
                            </div>
                        </form>
                    </div><!-- END TAB1 -->
                    <div class="filterContent" id="tab2">
                        <p>Filter content for Sale</p>
                        <form  id="saleForm" method="post" action="#">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="propertyType2">Property Type</label><br/>
                                        <select name="property type" id="propertyType2" class="formDropdown">
                                            <option>Any</option>
                                            <option value="SINGLE_HOUSE">SINGLE HOUSE</option>
                                            <option value="FAMILY_HOUSE">FAMILY HOUSE</option>
                                            <option value="VILLA">VILLA</option>
                                            <option value="APARTMENT">APARTMENT</option>
                                            <option value="BUNGALOW">BUNGALOW</option>
                                            <option value="OFFICE_BUILDING">OFFICE BUILDING</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="location2">Location</label><br/>
                                        <select name="location" id="location2" class="formDropdown">
                                            <option>Any</option>
                                            <%

                                                for (Object obj : cityArray) {
                                                    JSONObject jSONObj = (JSONObject) obj;
                                            %>
                                            <option ><%= jSONObj.get("city")%></option>
                                            <%  }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="price">Price Range</label><br/>
                                        <select name="price" id="price" class="formDropdown">
                                            <option>Any</option>
                                            <option value="$200,000">$200,000</option>
                                            <option value="$300,000">$300,000</option>
                                            <option value="$400,000">$400,000</option>
                                            <option value="$500,000">$500,000</option>
                                            <option value="$600,000">$600,000</option>
                                            <option value="$700,000">$700,000</option>
                                            <option value="$900,000">$900,000</option>
                                            <option value="$1,000,000">$1,000,000</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="beds2">Beds</label><br/>
                                        <select name="beds" id="beds2" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="4">5</option>
                                            <option value="4">6</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="baths2">Baths</label><br/>
                                        <select name="baths" id="baths2" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="4">5</option>
                                            <option value="4">6</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="area2">Area (Sq Ft)</label><br/>
                                        <select name="area" id="area2" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="formBlock">
                                        <input class="buttonColor" type="button" id="searchBtn2" value="FIND PROPERTIES" style="margin-top:24px;"/>
                                    </div>
                                </div>
                                <div style="clear:both;"></div>
                            </div>
                        </form>
                    </div><!-- END TAB 2 -->
                    <div class="filterContent" id="tab3">
                        <p>Filter content for Rent</p>
                        <form id="rentForm" method="post" action="#">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="propertyType3">Property Type</label><br/>
                                        <select name="property type" id="propertyType3" class="formDropdown">
                                            <option>Any</option>
                                            <option value="SINGLE_HOUSE">SINGLE HOUSE</option>
                                            <option value="FAMILY_HOUSE">FAMILY HOUSE</option>
                                            <option value="VILLA">VILLA</option>
                                            <option value="APARTMENT">APARTMENT</option>
                                            <option value="BUNGALOW">BUNGALOW</option>
                                            <option value="OFFICE_BUILDING">OFFICE BUILDING</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="location3">Location</label><br/>
                                        <select name="location" id="location3" class="formDropdown">
                                            <option>Any</option>
                                            <%
                                                for (Object obj : cityArray) {
                                                    JSONObject jSONObj = (JSONObject) obj;
                                            %>
                                            <option ><%= jSONObj.get("city")%></option>
                                            <%  }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="price2">Price Range</label><br/>
                                        <select name="price2" id="price2" class="formDropdown">
                                            <option>Any</option>
                                            <option value="$200,000">$200,000</option>
                                            <option value="$300,000">$300,000</option>
                                            <option value="$400,000">$400,000</option>
                                            <option value="$500,000">$500,000</option>
                                            <option value="$600,000">$600,000</option>
                                            <option value="$700,000">$700,000</option>
                                            <option value="$900,000">$900,000</option>
                                            <option value="$1,000,000">$1,000,000</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="beds3">Beds</label><br/>
                                        <select name="beds" id="beds3" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="baths3">Baths</label><br/>
                                        <select name="baths" id="baths3" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-12">
                                    <div class="formBlock select">
                                        <label for="area3">Area (Sq Ft)</label><br/>
                                        <select name="area" id="area3" class="formDropdown">
                                            <option>Any</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="formBlock">
                                        <input class="buttonColor" type="button" id="searchBtn3" value="FIND PROPERTIES" style="margin-top:24px;"/>
                                    </div>
                                </div>
                                <div style="clear:both;"></div>
                            </div>
                        </form>
                    </div><!-- END TAB 3 -->
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end subheader container -->
    </section><!-- end subheader section -->

    <!-- start big message -->
    <section class="bigMessage">
        <div class="container">
            <h1>Easy, fast & <span>affordable</span> real estate.</h1><br/>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sit amet sagittis erat. Maecenas suscipit ut quam id condimentum. 
                Pellentesque cursus lacinia sapien et laoreet. Ut mattis ultricies sem id elementum. Vestibulum blandit consectetur nibh.</p>
        </div>
    </section>
    <!-- end big message -->

    <!-- start recent properties -->
<!--    <section class="properties">
        <div class="container">
            <h3>RECENT PROPERTIES</h3>
            <div class="divider"></div>
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-6">
                    <div class="propertyItem">
                        <div class="propertyContent">
                            <a class="propertyType" href="#">FAMILY HOME</a>
                            <a href="user_property_single.jsp" class="propertyImgLink"><img class="propertyImg" src="images/home1.jpg" alt="" /></a>
                            <h4><a href="user_property_single.jsp">587 Smith Avenue</a></h4>
                            <p>Baltimore, MD</p>
                            <div class="divider thin"></div>
                            <p class="forSale">FOR SALE</p>
                            <p class="price">$687,000</p>
                        </div>
                        <table border="1" class="propertyDetails">
                            <tr>
                                <td><img src="images/icon-area.png" alt="" style="margin-right:7px;" />2,412m</td>
                                <td><img src="images/icon-bed.png" alt="" style="margin-right:7px;" />6 Beds</td>
                                <td><img src="images/icon-drop.png" alt="" style="margin-right:7px;" />3 Baths</td>
                            </tr>
                        </table> 
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6">
                    <div class="propertyItem">
                        <div class="propertyContent">
                            <a class="propertyType" href="#">APARTMENT</a>
                            <a href="user_property_single.jsp" class="propertyImgLink"><img class="propertyImg" src="images/home2.jpg" alt="" /></a>
                            <h4><a href="user_property_single.jsp">587 Smith Avenue</a></h4>
                            <p>Baltimore, MD</p>
                            <div class="divider thin"></div>
                            <p class="forSale">FOR RENT</p>
                            <p class="price">$1,200/mo</p>
                        </div>
                        <table border="1" class="propertyDetails">
                            <tr>
                                <td><img src="images/icon-area.png" alt="" style="margin-right:7px;" />2,412m</td>
                                <td><img src="images/icon-bed.png" alt="" style="margin-right:7px;" />6 Beds</td>
                                <td><img src="images/icon-drop.png" alt="" style="margin-right:7px;" />3 Baths</td>
                            </tr>
                        </table> 
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6">
                    <div class="propertyItem">
                        <div class="propertyContent">
                            <a class="propertyType" href="#">CONDO</a>
                            <a href="user_property_single.jsp" class="propertyImgLink"><img class="propertyImg" src="images/home3.jpg" alt="" /></a>
                            <h4><a href="user_property_single.jsp">587 Smith Avenue</a></h4>
                            <p>Baltimore, MD</p>
                            <div class="divider thin"></div>
                            <p class="forSale">FOR SALE</p>
                            <p class="price">$687,000</p>
                        </div>
                        <table border="1" class="propertyDetails">
                            <tr>
                                <td><img src="images/icon-area.png" alt="" style="margin-right:7px;" />2,412m</td>
                                <td><img src="images/icon-bed.png" alt="" style="margin-right:7px;" />6 Beds</td>
                                <td><img src="images/icon-drop.png" alt="" style="margin-right:7px;" />3 Baths</td>
                            </tr>
                        </table> 
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6">
                    <div class="propertyItem">
                        <div class="propertyContent">
                            <a class="propertyType" href="#">VILLA</a>
                            <a href="user_property_single.jsp" class="propertyImgLink"><img class="propertyImg" src="images/home4.jpg" alt="" /></a>
                            <h4><a href="user_property_single.jsp">587 Smith Avenue</a></h4>
                            <p>Baltimore, MD</p>
                            <div class="divider thin"></div>
                            <p class="forSale">FOR SALE</p>
                            <p class="price">$687,000</p>
                        </div>
                        <table border="1" class="propertyDetails">
                            <tr>
                                <td><img src="images/icon-area.png" alt="" style="margin-right:7px;" />2,412m</td>
                                <td><img src="images/icon-bed.png" alt="" style="margin-right:7px;" />6 Beds</td>
                                <td><img src="images/icon-drop.png" alt="" style="margin-right:7px;" />3 Baths</td>
                            </tr>
                        </table> 
                    </div>
                </div>
            </div> end row 
        </div> end container 
    </section>-->
    <!-- end recent properties -->

    <!-- start services section -->
    <%@ include file="service.jsp" %>
    <!-- end services section -->

    <!-- start top agents section -->
    <section class="topAgents">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <img class="agentImg" src="images/agent1.png" alt="" /><br/><br/>
                    <h4>JOHN DOE</h4>
                    <p>Lorem ipsum dolor amet, consectetur 
                        adipiscing elit. Sed purus eget nunc.</p>
                    <ul class="socialIcons">
                        <li><a href="#"><img src="images/icon-fb.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-twitter.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-google.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-rss.png" alt="" /></a></li>
                    </ul>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <img class="agentImg" src="images/agent2.png" alt="" /><br/><br/>
                    <h4>STEVE SMITH</h4>
                    <p>Lorem ipsum dolor amet, consectetur 
                        adipiscing elit. Sed purus eget nunc.</p>
                    <ul class="socialIcons">
                        <li><a href="#"><img src="images/icon-fb.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-twitter.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-google.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-rss.png" alt="" /></a></li>
                    </ul>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <img class="agentImg" src="images/agent3.png" alt="" /><br/><br/>
                    <h4>WALTER WHITE</h4>
                    <p>Lorem ipsum dolor amet, consectetur 
                        adipiscing elit. Sed purus eget nunc.</p>
                    <ul class="socialIcons">
                        <li><a href="#"><img src="images/icon-fb.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-twitter.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-google.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-rss.png" alt="" /></a></li>
                    </ul>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-3">
                    <img class="agentImg" src="images/agent4.png" alt="" /><br/><br/>
                    <h4>SARAH PARKER</h4>
                    <p>Lorem ipsum dolor amet, consectetur 
                        adipiscing elit. Sed purus eget nunc.</p>
                    <ul class="socialIcons">
                        <li><a href="#"><img src="images/icon-fb.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-twitter.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-google.png" alt="" /></a></li>
                        <li><a href="#"><img src="images/icon-rss.png" alt="" /></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <!-- end top agents section -->
<!--
    <!-- start widgets section -->
    <section class="genericSection">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h3>RECENT BLOG POSTS</h3>
                    <div class="divider"></div>
                    <div class="recentBlogPost">
                        <img class="blogThumb" src="images/blog-thumb1.jpg" alt="" />
                        <div class="recentBlogContent">
                            <h4><a href="blog_single.html">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                            <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Quisque 
                                eget ante vel nunc posuere rhoncus. Donec quis elit sit...</p>
                            <a class="buttonGrey" href="#">READ MORE</a>
                            <div class="date"><p>Feb 5, 2014</p></div>
                        </div>
                    </div>
                    <div class="divider thin" style="margin-top:5px; margin-bottom:20px;"></div>
                    <div class="recentBlogPost">
                        <img class="blogThumb" src="images/blog-thumb2.png" alt="" />
                        <div class="recentBlogContent">
                            <h4><a href="blog_single.html">AWESOME DREAM HOUSE IN A GREAT LOCATION</a></h4>
                            <p>Lorem ipsum dolor amet, consectetur adipiscing elit. Quisque 
                                eget ante vel nunc posuere rhoncus. Donec quis elit sit...</p>
                            <a class="buttonGrey" href="#">READ MORE</a>
                            <div class="date"><p>Feb 5, 2014</p></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <h3>TESTIMONIALS</h3>
                    <div class="divider"></div>
                    <div>
                        <img class="blogThumb" src="images/testimonial-thumb1.png" alt="" />
                        <h4>JOHN DOE</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi 
                            vehicula dapibus mauris, quis ullamcorper enim aliquet sed. 
                            Maecenas eget tellus dui. Vivamus condimentum egestas nulla 
                            quis vehicula. Sed justo turpis, commodo sit amet.</p>
                    </div>
                    <div class="divider thin" style="margin-top:20px; margin-bottom:20px;"></div>
                    <div>
                        <img class="blogThumb" src="images/testimonial-thumb2.png" alt="" />
                        <h4>JOHN DOE</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi 
                            vehicula dapibus mauris, quis ullamcorper enim aliquet sed. 
                            Maecenas eget tellus dui. Vivamus condimentum egestas nulla 
                            quis vehicula. Sed justo turpis, commodo sit amet.</p>
                    </div>
                </div>
            </div><!-- end row -->
        </div><!-- end container -->
    </section>
    <!-- end widgets section -->
-->
    <!-- start call to action -->
    <section class="callToAction">
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

    <%@include file="footer.jsp" %>

    <!-- JavaScript file links -->
    <script src="js/jquery.js"></script>			<!-- Jquery -->
    <script src="js/bootstrap.min.js"></script>  <!-- bootstrap 3.0 -->
    <script src="js/respond.js"></script>
    <script src="js/tabs.js"></script>       <!-- tabs -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAqb3fT3SbMSDMggMEK7fJOIkvamccLrjA&sensor=false"></script><!-- google maps -->
    <script src="js/markerclusterer.js"></script>
    <script type="text/javascript" src="js/code/map.js"></script> <!-- map script -->
    <script type="text/javascript" src="js/code/dhtmlxcommon.js"></script> <!-- map script -->
    <script type="text/javascript" src="js/code/jquery.search.min.js"></script> <!-- search script -->
    <script src="js/jquery.nouislider.min.js"></script> 
    <script>
        var Link = $.noUiSlider.Link;

        $(".priceSlider").noUiSlider({
            range: {
                'min': 0,
                'max': 800000
            }
            ,start: [150000, 550000]
            ,step: 1000
            ,margin: 100000
            ,connect: true
            ,direction: 'ltr'
            ,orientation: 'horizontal'
            ,behaviour: 'tap-drag'
            ,serialization: {
                lower: [
                    new Link({
                        target: $("#price-min")
                    })
                ],

                upper: [
                    new Link({
                        target: $("#price-max")
                    })
                ],

                format: {
                    // Set formatting
                    decimals: 0,
                    thousand: ',',
                    prefix: ''//$
                }
            }
        });
    </script>

</body>
</html>
