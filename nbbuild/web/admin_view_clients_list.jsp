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
            <h1>OPR Clients</h1>
        </div>
        <!-- end subheader container -->
    </section>
    <!-- end subheader section -->

    <!-- start my properties list -->
    <section class="genericSection">
        <div class="container">
            <h3>OUR MEMBERS</h3>
            <div class="divider"></div>
            <table class="myProperties">
                <tr class="myPropertiesHeader">
                    
                    <td class="myPropertyAddress">Client Name</td>
                    <td class="myPropertyAddress">UserName</td>
                    <td class="myPropertyAddress">phone</td>
                    <td class="myPropertyType">Email</td>
                    <td class="myPropertyStatus">City</td>
                    <td class="myPropertyDate">Option</td>
                </tr>
                <%
                    JSONArray clientArray = new SearchModel().getClientList();
                    if (clientArray.size() > 0) {

                        for (Object object : clientArray) {
                            JSONObject obj = (JSONObject) object;
                %>
                <tr>

                   
                    <td class="myPropertyType"><%=obj.get("name")%></td>
                    <td class="myPropertyAddress"><%=obj.get("username")%></td>
                    <td class="myPropertyType"><%=obj.get("phone")%></td>
                    <td class="myPropertyStatus"><%=obj.get("email")%></td>
                    <td class="myPropertyDate"><%=obj.get("city")%></td>
                    <td class="myPropertyActions"> <span><a
                                href="RemoveUserServlet?userId=<%=obj.get("username")%>">Remove</a></span></td>
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
