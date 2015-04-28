
<%@page import="com.opr.utils.AppVariable"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.opr.model.SearchModel"%>
<%@ include file="header_01.jsp" %>
<%@page errorPage="error.jsp" %>

<body>
    <%! public void jspInit() {
            AppVariable.REAL_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.REAL_FOLDER);
            AppVariable.NAVIGATE_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.NAVIGATE_FOLDER);
            AppVariable.SEARCH_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.SEARCH_FOLDER);
            AppVariable.VIDEO_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.VIDEO_FOLDER);
            AppVariable.TEMP_SERVLET_CONTEXT = getServletContext().getRealPath(AppConstants.TEMP_FOLDER);
        }
    %>
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
        <div class="container" >

            <div class="filterHeader" id="filter">
                <ul class="filterNav tabs">
                    <li><a class="current triangle" href="#" id="tabs1">ALL PROPERTIES</a></li>
                    <li><a href="#" id="tabs2">FOR SALE</a></li>
                    <li><a href="#" id="tabs3">FOR RENT</a></li>
                </ul>
                <div class="filterHeadButton"><a class="buttonGrey" href="#" id="plot_btn">SEARCH PLOT</a></div>
                <div class="filterHeadButton"><a class="buttonGrey" href="#" id="building_btn">SEARCH BUILDING</a></div>

            </div>
            <!-- Start Custome Design -->
            <div id="searchDiv"></div>
            <!-- End Custome Design -->
            
            <!-- END TAB1 -->
            <!-- END TAB 2 -->
            <!-- END TAB 3 -->
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

    <!-- start services section -
    include file="service.jsp" %>
    <!-- end services section -->

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

    <script src="js/code/jquery.normal_search.min.js"></script>  <!-- Search js-->
    <script type="text/javascript" src="js/code/jquery_search_design_1.0.1.min.js"></script>  <!-- Search js-->
    <!--    <script>
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
        </script> -->



</body>
</html>
