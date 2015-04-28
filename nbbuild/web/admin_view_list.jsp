<%@page import="com.opr.bean.PropertyBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.opr.model.SearchModel"%>
<%@ page errorPage="error.jsp"%>
<%@include file="header_02.jsp"%><!-- End Header -->

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
        <ul class="propertyCat_list option-set" style="width:33.7%">
            <li><a href="#" data-filter="*" class="current triangle" id="all">ALL</a></li>
            <li><a href="#" data-filter=".building" id="building">BUILDINGS</a></li>
            <li><a href="#" data-filter=".plot" id="plot">PLOT OR LANDS</a></li>
        </ul>
        <ul class="propertySort_list">
            <li style="padding-right:0px;">
                <form style="margin-top:-10px;">
                    <div class="formBlock select">
                        <select name="property type" id="propertyType" class="formDropdown" style="padding:6px;">
                            <option>Any</option>
                            <option value="SINGLE_HOUSE">SINGLE HOUSE</option>
                            <option value="FAMILY_HOUSE">FAMILY HOUSE</option>
                            <option value="VILLA">VILLA</option>
                            <option value="APARTMENT">APARTMENT</option>
                            <option value="BUNGALOW">BUNGALOW</option>
                            <option value="OFFICE_BUILDING">OFFICE BUILDING</option>

                            <option value="FARM_LAND">FARM LAND</option>
                            <option value="ASSOCIATED_LAND">ASSOCIATED LAND</option>
                            <option value="NON_URBAN_LAND">NON URBAN LAND</option>
                            <option value="MULTY_STORY_BUILDINGS">MULTY STORY BUILDINGS</option>
                        </select>
                    </div>
                </form>
            </li>
            <li><p>Property Type:</p></li>
            <li><div style="width:1px; height:45px; margin-top:-12px; background-color:#c5c5c5;"></div></li>
            <!--            <li><a href="listing_grid.html"><img src="images/icon-grid.png" alt="" /></a></li>
                        <li><a href="listing_row.html"><img src="images/icon-row.png" alt="" /></a></li>-->
        </ul>
        <div class="divider"></div>
        <section  id="gridContainer">
        </section>
        <div class="row masonryRow">
            <!--            <div id="plot"></div>-->
            <!--            <div class="col-lg-3 col-md-7 col-sm-6 wide building" style="width:100%">
                            <h3>PROPERTY DETAILS</h3>
                            <div class="divider"></div>
                            <table class="myProperties">
                                <tbody id="buildingBody">
                                </tbody>
                            </table>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 wide plot" style="width:100%">
                            <br><br>
                            <h3>PLOT DETAILS</h3>
                            <div class="divider"></div>
                            <table class="myProperties">
                                <tbody id="plotBody">
                                </tbody>
                            </table>
                        </div>-->



        </div><!-- end row -->
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



<%@include file="footer.jsp"%>

<!-- JavaScript file links -->
<script src="js/jquery.js"></script>			<!-- Jquery -->
<script src="js/bootstrap.min.js"></script>  <!-- bootstrap 3.0 -->
<script src="js/respond.js"></script>
<script src="js/jquery.isotope.min.js"></script>       <!-- isotope (for masonry layout) -->
<script src="js/code/dhtmlxcommon.js"></script><!-- Ajax plugin -->
<script src="js/code/jquery.admin.complete_search.min.js"></script>  <!-- Search js-->
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

</body>
</html>