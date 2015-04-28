
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.opr.model.SearchModel"%>
<%@ include file="header_03.jsp" %>
<%@page errorPage="error.jsp" %>

<body>

    <!-- Start Header -->

    <!-- End Header -->

    <!-- start subheader -->
    <section class="sliderControls">
        <div>
            <span class="slider-prev"></span>
            <span class="slider-next"></span>
        </div>
    </section>

    <section class="subHeader home bxslider">
        <%@include file="slides.jsp" %>
    </section>

    <!-- start horizontal filter -->
    <section class="filter">
        <div class="container">
            <div class="filterHeader">
                <ul class="filterNav tabs">
                    <li><a class="current triangle" href="#tab1">ALL PROPERTIES</a></li>
                    <li><a href="#tab2">FOR SALE</a></li>
                    <li><a href="#tab3">FOR RENT</a></li>
                </ul>
                <div class="filterHeadButton"><a class="buttonGrey" href="">VIEW ALL LISTINGS</a></div>
            </div>
            <div class="filterContent defaultTab" id="tab1">
                <form id="defaultForm" method="post" action="DefualtSearchServlet">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6">
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
                        <div class="col-lg-4 col-md-4 col-sm-6">
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
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock">
                                <label for="price-min">Price Range</label><br/>
                                <div style="float:right; margin-top:-25px;">
                                    <div class="priceInput"><input type="text" name="price min" id="price-min" class="priceInput" /></div>
                                    <span style="float:left; margin-right:10px; margin-left:10px;">-</span>
                                    <div class="priceInput"><input type="text" name="price max" id="price-max" class="priceInput" /></div>
                                </div><br/>
                                <div class="priceSlider"></div>
                                <div class="priceSliderLabel"><span>0</span><span style="float:right;">800,000</span></div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="beds">Beds</label><br/>
                                <select name="beds" id="beds" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock">
                                <input class="buttonColor" type="button" value="FIND PROPERTIES" id="searchBtn1" style="margin-top:24px;"/>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </form>
            </div><!-- END TAB1 -->
            <div class="filterContent" id="tab2">
                <p>Filter content for Sale</p>
                <form id="saleForm" method="post" action="SaleSearchServlet">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="propertyType2">Property Type</label><br/>
                                <select name="propertyType" id="propertyType2" class="formDropdown">
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
                        <div class="col-lg-4 col-md-4 col-sm-6">
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
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="priceMinDropDown">Min Price</label><br/>
                                <select name="priceMinDropdown" id="priceMinDropDown" class="formDropdown">
                                    <option>Any</option>
                                    <option value="$100,000">$100,000</option>
                                    <option value="$200,000">$200,000</option>
                                    <option value="$300,000">$300,000</option>
                                    <option value="$400,000">$400,000</option>
                                    <option value="$500,000">$500,000</option>
                                    <option value="$600,000">$600,000</option>
                                    <option value="$800,000">$800,000</option>
                                    <option value="$900,000">$900,000</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="priceMaxDropdown">Max Price</label><br/>
                                <select name="priceMaxDropdown" id="priceMaxDropdown" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="beds2">Beds</label><br/>
                                <select name="beds" id="beds2" class="formDropdown">
                                    <option>Any</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="baths2">Baths</label><br/>
                                <select name="baths" id="baths2" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="area2">Area (Sq Ft)</label><br/>
                                <select name="area" id="area2" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock">
                                <input class="buttonColor" type="button" value="FIND PROPERTIES" id="searchBtn2" style="margin-top:24px;"/>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </form>
            </div><!-- END TAB 2 -->
            <div class="filterContent" id="tab3">
                <p>Filter content for Rent</p>
                <form id="rentForm" method="post" action="RentSearchServlet">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="propertyType3">Property Type</label><br/>
                                <select name="propertyType" id="propertyType3" class="formDropdown">
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
                        <div class="col-lg-4 col-md-4 col-sm-6">
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
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="priceMinDropDown">Min Price</label><br/>
                                <select name="priceMinDropdown" id="priceMinDropDown3" class="formDropdown">
                                    <option>Any</option>
                                    <option value="$100,000">$100,000</option>
                                    <option value="$200,000">$200,000</option>
                                    <option value="$300,000">$300,000</option>
                                    <option value="$400,000">$400,000</option>
                                    <option value="$500,000">$500,000</option>
                                    <option value="$600,000">$600,000</option>
                                    <option value="$800,000">$800,000</option>
                                    <option value="$900,000">$900,000</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="priceMaxDropdown">Max Price</label><br/>
                                <select name="priceMaxDropdown" id="priceMaxDropdown3" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="beds2">Beds</label><br/>
                                <select name="beds" id="beds3" class="formDropdown">
                                    <option>Any</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="baths2">Baths</label><br/>
                                <select name="baths" id="baths3" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="area2">Area (Sq Ft)</label><br/>
                                <select name="area" id="area3" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock">
                                <input class="buttonColor" type="button" value="FIND PROPERTIES" id="searchBtn3" style="margin-top:24px;"/>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </form>
            </div><!-- END TAB 3 -->
        </div><!-- END CONTAINER -->
    </section>
    <!-- end horizontal filter -->

    <!-- start big message -->
    <!--    <section class="bigMessage">
            <div class="container">
                <h1>Easy, fast & <span>affordable</span> real estate.</h1><br/>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sit amet sagittis erat. Maecenas suscipit ut quam id condimentum. 
                    Pellentesque cursus lacinia sapien et laoreet. Ut mattis ultricies sem id elementum. Vestibulum blandit consectetur nibh.</p>
            </div>
        </section>-->
    <!-- end big message -->

    <!-- start recent properties -->
    <section class="properties" id="saleSection">
    </section>
    <!-- end recent properties -->

        <!-- start horizontal filter -->
    <section class="filter">
        <div class="container">
            <div class="filterHeader">
                <ul class="filterNav tabs">
                    <li><a class="current triangle" href="#plotTab1">ALL PROPERTIES</a></li>
                    <li><a href="#plotTab2">FOR SALE</a></li>
                    <li><a href="#plotTab3">FOR RENT</a></li>
                </ul>
                <div class="filterHeadButton"><a class="buttonGrey" href="">VIEW ALL LISTINGS</a></div>
            </div>
            <div class="filterContent defaultTab" id="plotTab1">
                <form id="plotDefaultForm" method="POST" action="DefaultPlotServlet">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="propertyType">Property Type</label><br/>
                                <select name="propType" id="p_propertyType" class="formDropdown">
                                    <option>Any</option>
                                    <option value="FARM_LAND">FARM LAND</option>
                                    <option value="ASSOCIATED_LAND">ASSOCIATED LAND</option>
                                    <option value="NON_URBAN_LAND">NON URBAN LAND</option>
                                    <option value="MULTY_STORY_BUILDINGS">MULTY STORY BUILDINGS</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="location">Location</label><br/>
                                <select name="city" id="p_location" class="formDropdown">
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
                       <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="priceMinDropDown1">Min Price</label><br/>
                                <select name="downPrice" id="p_priceMinDropdown1" class="formDropdown">
                                    <option>Any</option>
                                    <option value="100,000">$100,000</option>
                                    <option value="200,000">$200,000</option>
                                    <option value="300,000">$300,000</option>
                                    <option value="400,000">$400,000</option>
                                    <option value="500,000">$500,000</option>
                                    <option value="600,000">$600,000</option>
                                    <option value="800,000">$800,000</option>
                                    <option value="900,000">$900,000</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="p_priceMaxDropdown1">Max Price</label><br/>
                                <select name="maxPrice" id="p_priceMaxDropdown1" class="formDropdown">
                                    <option>Any</option>
                                    <option value="200,000">$200,000</option>
                                    <option value="300,000">$300,000</option>
                                    <option value="400,000">$400,000</option>
                                    <option value="500,000">$500,000</option>
                                    <option value="600,000">$600,000</option>
                                    <option value="700,000">$700,000</option>
                                    <option value="900,000">$900,000</option>
                                    <option value="1,000,000">$1,000,000</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="area">Area (Sq Ft)</label><br/>
                                <select name="area" id="p_area" class="formDropdown">
                                    <option>Any</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock">
                                <input class="buttonColor" type="button" value="FIND PROPERTIES" id="plotDefaultBtn" style="margin-top:24px;"/>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </form>
            </div><!-- END TAB1 -->
            <div class="filterContent" id="plotTab2">
                <p>Filter content for Sale</p>
                <form id="plotsaleForm" method="post" action="PlotSaleServlet">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="propertyType2">Property Type</label><br/>
                                <select name="propType" id="p_propertyType2" class="formDropdown">
                                    <option>Any</option>
                                    <option value="FARM_LAND">FARM LAND</option>
                                    <option value="ASSOCIATED_LAND">ASSOCIATED LAND</option>
                                    <option value="NON_URBAN_LAND">NON URBAN LAND</option>
                                    <option value="MULTY_STORY_BUILDINGS">MULTY STORY BUILDINGS</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="location2">Location</label><br/>
                                <select name="city" id="p_location2" class="formDropdown">
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
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="priceMinDropDown2">Min Price</label><br/>
                                <select name="downPrice" id="p_priceMinDropdown2" class="formDropdown">
                                    <option>Any</option>
                                    <option value="100,000">$100,000</option>
                                    <option value="200,000">$200,000</option>
                                    <option value="300,000">$300,000</option>
                                    <option value="400,000">$400,000</option>
                                    <option value="500,000">$500,000</option>
                                    <option value="600,000">$600,000</option>
                                    <option value="800,000">$800,000</option>
                                    <option value="900,000">$900,000</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="p_priceMaxDropdown2">Max Price</label><br/>
                                <select name="maxPrice" id="p_priceMaxDropdown2" class="formDropdown">
                                    <option>Any</option>
                                    <option value="200,000">$200,000</option>
                                    <option value="300,000">$300,000</option>
                                    <option value="400,000">$400,000</option>
                                    <option value="500,000">$500,000</option>
                                    <option value="600,000">$600,000</option>
                                    <option value="700,000">$700,000</option>
                                    <option value="900,000">$900,000</option>
                                    <option value="1,000,000">$1,000,000</option>
                                </select>
                            </div>
                        </div>
                       
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="p_area2">Area (Sq Ft)</label><br/>
                                <select name="area" id="p_area2" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock">
                                <input class="buttonColor" type="button" value="FIND PROPERTIES" id="p_searchBtn2" style="margin-top:24px;"/>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </form>
            </div><!-- END TAB 2 -->
            <div class="filterContent" id="plotTab3">
                <p>Filter content for Rent</p>
                <form id="plotRentForm" method="post" action="PlotRentSearchServlet">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="p_propertyType3">Property Type</label><br/>
                                <select name="propType" id="p_propertyType3" class="formDropdown">
                                    <option>Any</option>
                                    <option value="FARM_LAND">FARM LAND</option>
                                    <option value="ASSOCIATED_LAND">ASSOCIATED LAND</option>
                                    <option value="NON_URBAN_LAND">NON URBAN LAND</option>
                                    <option value="MULTY_STORY_BUILDINGS">MULTY STORY BUILDINGS</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="formBlock select">
                                <label for="p_location3">Location</label><br/>
                                <select name="city" id="p_location3" class="formDropdown">
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
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="p_priceMinDropDown3">Min Price</label><br/>
                                <select name="downPrice" id="p_priceMinDropDown3" class="formDropdown">
                                    <option>Any</option>
                                    <option value="100,000">$100,000</option>
                                    <option value="200,000">$200,000</option>
                                    <option value="300,000">$300,000</option>
                                    <option value="400,000">$400,000</option>
                                    <option value="500,000">$500,000</option>
                                    <option value="600,000">$600,000</option>
                                    <option value="800,000">$800,000</option>
                                    <option value="900,000">$900,000</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-3">
                            <div class="formBlock select">
                                <label for="p_priceMaxDropdown3">Max Price</label><br/>
                                <select name="maxPrice" id="p_priceMaxDropdown3" class="formDropdown">
                                    <option>Any</option>
                                    <option value="200,000">$200,000</option>
                                    <option value="300,000">$300,000</option>
                                    <option value="400,000">$400,000</option>
                                    <option value="500,000">$500,000</option>
                                    <option value="600,000">$600,000</option>
                                    <option value="700,000">$700,000</option>
                                    <option value="900,000">$900,000</option>
                                    <option value="1,000,000">$1,000,000</option>
                                </select>
                            </div>
                        </div>
                       
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock select">
                                <label for="p_area3">Area (Sq Ft)</label><br/>
                                <select name="area" id="p_area3" class="formDropdown">
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
                        <div class="col-lg-3 col-md-3 col-sm-6">
                            <div class="formBlock">
                                <input class="buttonColor" type="button" value="FIND PROPERTIES" id="rentPlotBtn" style="margin-top:24px;"/>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </form>
            </div><!-- END TAB 3 -->
        </div><!-- END CONTAINER -->
    </section>
    <!-- end horizontal filter -->

    <!-- start recent properties -->
    <section class="properties" id="plotSaleSection">
    </section>
    <!-- end recent properties -->
    <!-- start top agents section --><!-- end top agents section -->

    <!-- start widgets section -->
    <section class="genericSection">
        <div class="container">
            <div class="row"></div><!-- end row -->
        </div><!-- end container -->
    </section>
    <!-- end widgets section -->

    <!-- start call to action --><!-- end call to action -->

    <div class="bottomBar">
        <div class="container">
            <p>ONLINE PLOT RENTAL COPYRIGHT 2014</p>
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
    <script src="js/tabs.js"></script>       <!-- tabs -->
    <script src="js/jquery.nouislider.min.js"></script>  <!-- price slider -->
    <script src="js/code/dhtmlxcommon.js"></script>
    <script src="js/code/jquery.search.min.js"></script>  <!-- Search js-->
    <script>
        //call bxslider for sub header section
        $(document).ready(function(){
            $('.bxslider').bxSlider({
                auto: true,
                pager: false,
                nextSelector: '.slider-next',
                prevSelector: '.slider-prev',
                nextText: '<img src="images/slider-next.png" alt="slider next" />',
                prevText: '<img src="images/slider-prev.png" alt="slider prev" />'
            });
        });
    </script>
 
    <script>
        //Setup price slider 
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
                    prefix: '' //$
                }
            }
        });  
    </script>

</body>
</html>
