<%@include file="header_02.jsp" %>
<!-- End Header -->
<!-- start subheader -->
<body>

    <!-- start subheader -->
    <section class="subHeader page">
        <div class="container">
            <h1>Property Listing Grid Masonry</h1>
            <form class="searchForm" method="post" action="#">

            </form>
        </div><!-- end subheader container -->
    </section><!-- end subheader section -->

    <!-- start recent properties -->
    <section class="properties">
        <div class="container">
            <ul class="propertyCat_list option-set" style="width:30%">
                <li><a href="#" data-filter="*" class="current triangle" id="all">ALL</a></li>
                <li><a href="#" data-filter=".sale" id="sale">FOR SALE</a></li>
                <li><a href="#" data-filter=".rent" id="rent">FOR RENT</a></li>
            </ul>
            <ul class="propertySort_list">
                <li style="padding-right:0px;">
                    <form id="gridForm" style="margin-top:-10px;">
                        <div class="formBlock select">
                            <select name="property type" id="propertyType" class="formDropdown" style="padding:6px;">
                                <option>Any</option>
                                <option value="SINGLE_HOUSE">SINGLE HOUSE</option>
                                <option value="FAMILY_HOUSE">FAMILY HOUSE</option>
                                <option value="VILLA">VILLA</option>
                                <option value="APARTMENT">APARTMENT</option>
                                <option value="BUNGALOW">BUNGALOW</option>
                                <option value="OFFICE_BUILDING">OFFICE BUILDING</option>
                            </select>
                        </div>
                    </form>
                </li>
                <li><p>Property Type:</p></li>
                <li><div style="width:1px; height:45px; margin-top:-12px; background-color:#c5c5c5;"></div></li>
                <li><a href=""><img src="images/icon-grid.png" alt="" /></a></li>
                <li><a href=""><img src="images/icon-row.png" alt="" /></a></li>
            </ul>
            <div class="divider"></div>
            

            <section  id="gridContainer">
            </section>

            <ul class="pageList">
                <li><a href="#">&lt;</a></li>
                <li><a href="#" class="current">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">&gt;</a></li>
            </ul>
        </div><!-- end container -->
    </section>
    <!-- end recent properties -->

    <!-- start call to action -->
  
    <!-- end call to action -->

     <%@include file="footer.jsp"%>

    <!-- JavaScript file links -->
    <script src="js/jquery.js"></script>			<!-- Jquery -->
    <script src="js/bootstrap.min.js"></script>  <!-- bootstrap 3.0 -->
    <script src="js/respond.js"></script>
    <script src="js/jquery.isotope.min.js"></script>       <!-- isotope (for masonry layout) -->
    <!-- isotope (for masonry layout) -->
    <script>
        //intialize isotope plugin
        $('.masonryRow').imagesLoaded(function() {
            $('.masonryRow').isotope({
                // options
                itemSelector : '.col-lg-3',
                animationEngine : 'jquery',
                resizable: true,
                resizesContainer: true,
                masonry: { }
            });
        });

        // filter items when filter link is clicked
        $('.propertyCat_list a').click(function(){
            var selector = $(this).attr('data-filter');
            $('.masonryRow').isotope({ filter: selector });
            return false;
        });

        // set selected category
        var $optionSets = $('.option-set'),
        $optionLinks = $optionSets.find('a');
 
        $optionLinks.click(function(){
            var $this = $(this);
            // don't proceed if already selected
            if ( $this.hasClass('current') ) {
                return false;
            }
            var $optionSet = $this.parents('.option-set');
            $optionSet.find('.current').removeClass('current');
            $this.addClass('current'); 
        });
    </script>
    <script src="js/code/dhtmlxcommon.js"></script>       <!-- isotope (for masonry layout) -->
    <!--    <script src="js/code/jquery-1.3.1.min.js"></script>        isotope (for masonry layout) -->
    <script src="js/code/jquery.grid_search.min.js"></script>
</body>
</html>