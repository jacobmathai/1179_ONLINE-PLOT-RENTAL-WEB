<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.opr.bean.PropertyBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.opr.model.SearchModel"%>
<%@ page errorPage="error.jsp"%>
<%@include file="header_02.jsp"%>
<!-- End Header -->
<!-- start subheader -->
<body>
    <section class="subHeader page">
        <div class="container">
            <h1>Suggested Properties</h1>
        </div>
        <!-- end subheader container -->
    </section>
    <!-- end subheader section -->

    <!-- start my properties list -->
    <section class="genericSection">
        <div class="container">
            <h3>BOOKED PROPERTIES</h3>
            <div class="divider"></div>
            <table class="myProperties">
                <tr class="myPropertiesHeader">
                    <td class="myPropertyImg">Image</td>
                    <td class="myPropertyAddress">Client Name</td>
                    <td class="myPropertyAddress">Address</td>
                    <td class="myPropertyType">Type</td>
                    <td class="myPropertyStatus">Contract</td>
                    <td class="myPropertyDate">Booked Date</td>
                    <td class="myPropertyDate">Option</td>
                </tr>
                <%
                    JSONArray bookedArray = new SearchModel().getBookedList();
                    if (bookedArray.size() > 0) {

                        for (Object object : bookedArray) {
                            JSONObject obj = (JSONObject) object;
                %>
                <tr>

                    <td class="myPropertyImg"><a
                            href="admin_view_property.jsp?prop_id=<%=obj.get("prop_id")%>">
                            <img class="smallThumb"
                                 src="<%=AppConstants.REAL_FOLDER + "/"
                                         + AppConstants.PHOTO_ONE + obj.get("prop_id")%>.jpg"
                                 alt="" />
                        </a></td>
                    <td class="myPropertyType"><%=obj.get("booked_one")%></td>
                    <td class="myPropertyAddress"><a
                            href="admin_view_property.jsp?prop_id=<%=obj.get("prop_id")%>">
                            <h4><%=obj.get("prop_title")%></h4>
                        </a></td>
                    <td class="myPropertyType"><%=obj.get("type")%></td>
                    <td class="myPropertyStatus"><%=obj.get("contract_type")%></td>
                    <td class="myPropertyDate"><%=obj.get("booking_date")%></td>
                    <td class="myPropertyActions"> <span><a
                                href="RemoveBooking?bookId=<%=obj.get("bookId")%>">Remove</a></span></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td class="myPropertyImg" colspan="7" style="text-align: center">  No pixel were found.</td>
                </tr>
                <%}%>
            </table>
            <ul class="pageList">
                <li><a href="#">&lt;</a></li>
                <li><a href="#" class="current">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">&gt;</a></li>
            </ul>
        </div>
        <!-- end container -->
    </section>
    <!-- end my properties list -->


    <%@include file="footer.jsp"%>

    <!-- JavaScript file links -->
    <script src="js/jquery.js"></script>
    <!-- Jquery -->
    <script src="js/bootstrap.min.js"></script>
    <!-- bootstrap 3.0 -->
    <script src="js/respond.js"></script>
    <script src="js/tabs.js"></script>
    <!-- tabs -->

</body>
</html>
