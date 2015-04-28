<%@include file="header_01.jsp"%>
<body>
    <!-- start subheader -->
    <section class="subHeader page">
        <div class="container">
            <h1>Contact Us Wide</h1>
            <form class="searchForm" method="post" action="#"></form>
        </div>
        <!-- end subheader container -->
    </section>
    <!-- end subheader section -->

    <!-- start map -->
    <section>
        <!--		<div id="map-canvas-one-pin" class="mapContact"></div>-->
        <iframe width="100%" height="350" frameborder="0" scrolling="no"
                marginheight="0" marginwidth="0"
                src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Ocean&amp;sll=9.931233,76.267304&amp;sspn=9.931233,76.267304&amp;ie=UTF8&amp;hq=&amp;hnear=Ocean,+New+Jersey&amp;t=m&amp;z=16&amp;ll=9.931233,76.267304&amp;output=embed"></iframe>
    </section>
    <!-- end map -->

    <!-- start main content -->
    <section class="properties">

        <%
            if (request.getParameter("status") != null
                    && request.getParameter("status").equals("send")) {
        %>
        <div id="msg" class="notification success closeable">
            <p>
                <span style="padding-right: 10px;">Success!</span>Your mail has been sent successfully.
            </p>
        </div>
        <%}%>

        <div class="container">
            <div class="row">

                <!-- start left column -->
                <div class="col-lg-4 col-md-4">
                    <img class="contactImg" src="images/office-building.jpg" alt="" />
                    <p>Need Help? For site related issues, check out our Help
                        section or email us at info.opr@gmail.com You can also call our
                        support team@ 022-67797979 (M-F: 10AM to 6PM)</p>

                    <p>Online house rental web portal is an internet portal along
                        with an android application dedicated to meet every aspect of the
                        consumers needs in the real estate industry. This is a form where
                        the owner's brokers and customers can exchange information's
                        quickly effectively and inexpensively.</p>
                </div>
                <!-- end left column -->

                <!-- start contact form -->
                <div class="col-lg-8 col-md-8">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <h3>GET IN TOUCH</h3>
                            <div class="divider"></div>
                            <ul class="contactDetails">
                                <li><img src="images/icon-mail.png" alt="" />opr.infos@gmail.com</li>
                                <li><img src="images/icon-phone.png" alt="" />1-800-192-0978</li>
                                <li><img src="images/icon-pin.png" alt="" />Your Head
                                    Mr.Name</li>
                            </ul>
                            <form method="post" action="ContactServlet" id="contactForm">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="formBlock">
                                            <label for="name">Your Name</label><br /> <input type="text"
                                                                                             name="name" id="name" />
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="formBlock">
                                            <label for="email">Your Email</label><br /> <input
                                                type="text" name="email" id="email" />
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="formBlock">
                                            <label for="message">Your Message</label><br />
                                            <textarea name="message" id="message" class="formDropdown"></textarea>
                                        </div>
                                    </div>
                                    <div
                                        class="col-lg-3 col-lg-offset-9 col-md-4 col-md-offset-8 col-sm-4 col-sm-offset-8">
                                        <div class="formBlock">
                                            <input class="buttonColor" type="submit" value="SEND" />
                                        </div>
                                    </div>
                                </div>
                                <!-- end row -->
                            </form>
                            <!-- end form -->
                        </div>
                        <!-- col -->
                    </div>
                    <!-- end row -->
                </div>
                <!-- end contact form -->

            </div>
            <!-- end row -->
        </div>
        <!-- end container -->
    </section>
    <!-- end main content -->

    <!-- start call to action -->

    <!-- end call to action -->

    <%@include file="footer.jsp"%>



    <!-- JavaScript file links -->
    <script src="js/jquery.js"></script>
    <!-- Jquery -->
    <script src="js/bootstrap.min.js"></script>
    <!-- bootstrap 3.0 -->
    <script src="js/respond.js"></script>
    <script type="text/javascript"
    src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    <!-- google maps -->
    <script type="text/javascript" src="js/code/map-one-pin.js"></script>
    <!-- map script -->
    <script src="js/code/jquery.validate.js"></script>
    <script src="js/code/contact_validator.js"></script>

</body>
</html>