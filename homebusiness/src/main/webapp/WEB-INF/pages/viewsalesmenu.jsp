<%-- 
    Document   : viewsalesmenu
    Created on : Sep 12, 2016, 2:27:02 PM
    Author     : Mumbi Chishimba Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bus Sales</title>
        <link rel="stylesheet" href="<c:url value="/resources/twitter-bootstrap/css/bootstrap.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/AdminLTE.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/skins/_all-skins.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/datatables/css/jquery.dataTables.css" />" >

        <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.min.js" />" ></script>
        <script type="text/javascript"  src="<c:url value="/resources/twitter-bootstrap/js/bootstrap.min.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js" />"></script>
        <!-- AdminLTE App -->
        <script type="text/javascript" src="<c:url value="/resources/dist/js/app.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/datatables/js/jquery.dataTables.min.js" />"></script>
    </head>
    <body class="sidebar-mini skin-green-light wysihtml5-supported">

        <%@include file="static_header.jsp" %>
        <div class="container-fluid">
            <div class="box box-primary">
                <div class="box-header with-border">Bus Sales</div>
                <div class="box-body" style="padding-left: 5%;padding-right: 5%;">
                    <div class="header"><div class="form-inline">
                            <div class="form-group">
                                <label for="busId">Bus</label>

                                <select  class="btn-group bootstrap-select form-control" id="busId">
                                    <option value="0">All Buses</option>
                                    <c:forEach var="buses" items="${buses}">
                                        <option class="" value="${buses.id}" >${buses.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <button id="go" class="btn btn-success">Load</button>
                            </div>
                        </div>
                    </div>
                    <div class="body">

                        <p id="loading"></p>
                        <div id="data" style="width: 100%;">

                        </div>

                    </div>
                </div>
            </div>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <%@include file="static_footer.jsp" %>
            <script>

                $("#go").click(function () {
                    console.log("/homebusiness/bus/sales/" + $("#busId").val() + "/view.html");
                    index = $('option:selected', $("#busId")).index();

                    if (index != 0) {
                        $("#loading").text("Loading......");
                        $("#data").load("/homebusiness/bus/sales/" + $("#busId").val() + "/view.html", function () {
                            $("#loading").text("");
                            $('#tables').DataTable();
                        });
                    } else {
                        $("#loading").text("Loading......");
                        $("#data").load("/homebusiness/bus/sales/view.html", function () {
                            $("#loading").text("");
                            $('#tables').DataTable();
                        });
                    }

                });
                $(document).ready(function () {
                    $('#tables').DataTable();
                    $("#loading").text("Loading......");

                    $("#data").load("/homebusiness/bus/sales/view.html", function () {
                        $("#loading").text("");
                    });
                });

            </script>
    </body>
</html>
