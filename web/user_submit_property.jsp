<%@include file="map_header_03.jsp"%>
<%@page errorPage="error.jsp"%>
<!-- End Header -->
<!-- start subheader -->
<body>
    <!-- start subheader -->

    <section class="subHeader map">
        <input id="pac-input" class="controls" type="text"
               placeholder="Search Box">
        <div id="mapDiv" style="height: 200px"></div>
    </section>
    <!-- end subheader section -->

    <!-- start my properties list -->
    <section class="properties">
        <div class="container">
            <div class="row">

                <%
                    if (request.getParameter("status") != null && request.getParameter("status").equals("success")) {%>
                <div id="msg" class="notification success closeable">
                    <p><span style="padding-right: 10px;">Success!</span> Property added Successfully.</p>
                </div>
                <%} else if (request.getParameter("status") != null && request.getParameter("status").equals("failed")) {%>
                <div id="msg" class="notification error closeable">
                    <p><span style="padding-right: 10px;">Error!</span> Failed to add Property. Please fill the required fields.</p>
                </div>
                <%}%>

                <form method="post" action="PropertySubmitServlet" enctype="multipart/form-data"
                      name="submitForm" id="submitForm" onsubmit=" return checkProof()">
                    <!-- start property info -->
                    <div class="col-lg-4 col-md-4">
                        <h3>PROPERTY INFO</h3>
                        <div class="divider"></div>
                        <div class="sidebarWidget submission">
                            <!-- 						<form method="post" action="#"> -->
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="prop_title">Property Name</label><br /> <input
                                            type="text" name="prop_title" id="prop_title" placeholder="Enter property name"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="location">Location</label><br /> <input
                                            type="text" name="location" id="location" placeholder="Select location from map"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="image">Image</label><br />
                                        <input id="prop_image" name="prop_image" type="file"/>
                                    </div>
                                </div>


                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock select">
                                        <label for="prop_type">Property Type</label><br /> <select
                                            name="prop_type" id="prop_type" class="formDropdown">
                                            <option value="SINGLE_HOUSE">SINGLE HOUSE</option>
                                            <option value="FAMILY_HOUSE">FAMILY HOUSE</option>
                                            <option value="VILLA">VILLA</option>
                                            <option value="APARTMENT">APARTMENT</option>
                                            <option value="BUNGALOW">BUNGALOW</option>
                                            <option value="OFFICE BUILDING" >OFFICE BUILDING</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="city">City</label><br /> 
                                        <input type="text" name="city" id="city" placeholder="Enter city address"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="pub_location">Public Location</label><br /> <input
                                            type="text" name="pub_location" id="pub_location" placeholder="Enter the public location"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="distance">Distance to public Location</label><br />
                                        <input type="text" name="distance" id="distance" placeholder="Enter distance to the public location"/>
                                    </div>
                                </div>

                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="description">Address</label><br />
                                        <textarea name="address" id="address" class="formDropdown" placeholder="Enter the address"></textarea>
                                        <br /> <br />
                                    </div>
                                </div>
                                <div style="clear: both;"></div>
                            </div>
                            <!-- end row -->
                            <!-- 						</form> -->
                            <!-- end form -->
                        </div>
                    </div>
                    <!-- end property info -->

                    <!-- start amenities -->
                    <div class="col-lg-4 col-md-4">
                        <h3>AMENITIES</h3>
                        <div class="divider"></div>
                        <div class="sidebarWidget submission">
                            <!-- 						<form method="post" action="#"> -->
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="amenityCheckList formBlock">
                                        <label>Amenities</label><br /> <br />
                                        <div class="row">
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="ac" name="ac"><label
                                                    for="1">Air Conditioning</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="balcony" name="balcony"><label
                                                    for="2">Balcony</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="bedding" name="bedding"><label
                                                    for="3">Bedding</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="cable" name="cable"><label
                                                    for="4">Cable TV</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="coffee" name="coffee"><label
                                                    for="5">Coffee Pot</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="fridge" name="fridge"><label
                                                    for="7">Fridge</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="heating" name="heating"><label
                                                    for="9">Heating</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="internet" name="internet"><label
                                                    for="10">Internet</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="microwave" name="microwave"><label
                                                    for="11">Microwave</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="oven" name="oven"><label
                                                    for="12">Oven</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="parking" name="parking"><label
                                                    for="13">Parking</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div class="amenityCheck col-lg-6 col-md-12">
                                                <input type="checkbox" id="pool" name="pool"><label
                                                    for="14">Pool</label>
                                            </div>
                                            <div style="clear: both;"></div>
                                            <div style="clear: both;"></div>
                                            <div style="clear: both;"></div>
                                        </div>
                                    </div>
                                </div>
                                <div style="clear: both;"></div>

                            </div>
                            <!-- end row -->
                            <!-- 						</form> -->
                            <!-- end form -->
                            <br></br>
                            <h3>PROOF</h3>
                            <div class="divider"></div>
                            <div class="amenityCheckList formBlock">
                                <div class="amenityCheck col-lg-4 col-md-12">
                                    <label for="11">License</label> 
                                    <input type="radio" name="proof" id="license" value="license" checked="true"/>
                                </div>
                                <div class="amenityCheck col-lg-4 col-md-12">
                                    <label for="11">Aadar</label>
                                    <input type="radio" id="aadar" name="proof" value="aadar"/>
                                </div>
                                <div class="amenityCheck col-lg-4 col-md-12">
                                    <label for="11">VoterId</label>
                                    <input type="radio" id="voter_id" name="proof" value="voter_id"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label id="proof_msg" for="proof_id">Proof Id</label><br /> 
                                        <input type="text" name="proof_id" id="proof_id" placeholder="Enter your proof"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end amenities -->

                    <!-- start additional info -->
                    <div class="col-lg-4 col-md-4">
                        <h3>ADDITIONAL INFO</h3>
                        <div class="divider"></div>
                        <div class="sidebarWidget submission">
                            <!-- 						<form method="post" action="#"> -->
                            <div class="row">

                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="rate">Price</label><br /> 
                                        <input type="text" name="rate" id="rate" onkeydown="return isNumber(event)" placeholder="Enter the rate of Property"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="area">Area</label><br /> 
                                        <input type="text" name="area" id="area" onkeydown="return isNumber(event)" placeholder="Enter area in Sqft" />
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for="bedrooms">BedRooms</label><br /> <input
                                            type="text" name="bedrooms" id="bedrooms" onkeydown="return isNumber(event)" placeholder="Enter no of bedrooms"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <label for=bathrooms>BathRooms</label><br /> <input
                                            type="text" name="bathrooms" id="bathrooms" onkeydown="return isNumber(event)" placeholder="Enter no of bathrooms"/>
                                    </div>
                                </div>

                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock select">
                                        <label for="contract_type">Contract Type</label><br /> <select
                                            name="contract_type" id="contract_type" class="formDropdown">
                                            <option value="For_Sale">For Sale</option>
                                            <option value="For_Rent">For Rent</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <!-- <div class="formBlock"> -->
                                        <label>Photos</label><br /> 
                                        <input type="file" id="photo1" name="photo1"/>
                                        <input type="file" id="photo2" name="photo2"/> 
                                        <input type="file" id="photo3" name="photo3"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="formBlock">
                                        <!-- <div class="formBlock"> -->
                                        <label>Video</label><br /> 
                                        <input type="file" id="video" name="video"/>
                                    </div>
                                </div>
                                <div style="clear: both;"></div>
                            </div>
                            <!-- end row -->
                            <!-- 						</form> -->
                            <!-- end form -->
                        </div>
                    </div>
                    <!-- end additional info -->

                    <div class="col-lg-4 col-lg-offset-4 col-md-4">
                        <div class="formBlock">
                            <input class="buttonColor" type="submit" value="REQUEST PROPERTY">
                        </div>
                    </div>
                </form>
            </div>
            <!-- end row -->
        </div>
        <!-- end container -->
    </section>
    <!-- end my properties list -->

    <!-- start call to action -->

    <!-- end call to action -->



    <%@include file="footer.jsp"%>

    <!-- JavaScript file links -->
    <script src="js/jquery.js"></script>
    <!-- Jquery -->
    <script src="js/bootstrap.min.js"></script>
    <!-- bootstrap 3.0 -->
    <script src="js/respond.js"></script>
    <script src="js/tabs.js"></script>
    <!-- tabs -->


    <script src="js/code/jquery.maploader.js"></script>
    <script src="js/code/user_fn_1.3.1.min.js"></script>
    <script src="js/code/jquery.validate.js"></script>
    <script src="js/code/jquery.submit.js"></script>

</body>
</html>
