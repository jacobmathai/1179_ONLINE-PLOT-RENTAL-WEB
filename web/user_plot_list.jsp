<%@page import="com.opr.bean.PropertyBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.opr.model.SearchModel"%>
<%@ page errorPage="error.jsp"%>
<%@include file="header_03.jsp"%>
<!-- End Header -->
<!-- start subheader -->
<body>
    <section class="subHeader page">
        <div class="container">
            <h1>My Plots/Lands</h1>
        </div>
        <!-- end subheader container -->
    </section>
    <!-- end subheader section -->

    <!-- start my properties list -->
    <section class="genericSection">
        <div class="container">
            <h3>MY PROPERTIES</h3>
            <div class="divider"></div>
            <table class="myProperties">
                <tr class="myPropertiesHeader">
                    <td class="myPropertyImg">Image</td>
                    <td class="myPropertyAddress">Address</td>
                    <td class="myPropertyType">Type</td>
                    <td class="myPropertyStatus">Contract</td>
                    <td class="myPropertyDate">Date Created</td>
                    <td class="myPropertyActions">Actions</td>
                </tr>
                <%
                    ArrayList<PropertyBean> propertyList = null;
                    propertyList = new SearchModel().getUsersPlotList(username);
                    if (propertyList.size() > 0) {
                        for (PropertyBean bean : propertyList) {
                %>
                <tr>
                    <td class="myPropertyImg"><a
                            href="user_plot_single.jsp?prop_id=<%=bean.getPropertyId()%>">
                            <img class="smallThumb"
                                 src="<%=AppConstants.REAL_FOLDER + "/"
                                         + AppConstants.PHOTO_ONE + bean.getPropertyId()%>.jpg"
                                 alt="" />
                        </a></td>
                    <td class="myPropertyAddress"><a
                            href="user_plot_single.jsp?prop_id=<%=bean.getPropertyId()%>">
                            <h4><%=bean.getPropTitle()%></h4>
                        </a></td>
                    <td class="myPropertyType"><%=bean.getPropType()%></td>
                    <td class="myPropertyStatus"><%=bean.getContractType()%></td>
                    <td class="myPropertyDate"><%=bean.getPostDate()%></td>
                    <td class="myPropertyActions"><span> <a
                                href="UserDeleteProperty?prop_id=<%=bean.getPropertyId()%>">
                                <img class="icon" src="images/icon-cross.png" alt="" />REMOVE
                            </a></span> <span><a
                                href="user_plot_single.jsp?prop_id=<%=bean.getPropertyId()%>"><img
                                    class="icon" src="images/icon-view.png" alt="" />VIEW</a></span></td>
                </tr>
                <%
                    }
                } else {%>
                <tr class="myPropertiesHeader">
                    <td class="myPropertyImg"  colspan="6">No pixels were found.</td>
                    
                </tr>
                <%  }
                %>
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
