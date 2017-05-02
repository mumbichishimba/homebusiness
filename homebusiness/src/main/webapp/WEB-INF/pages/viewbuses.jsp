<%-- 
    Document   : viewbuses
    Created on : Sep 9, 2016, 1:20:49 PM
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
        <title>Buses</title>
        <link rel="stylesheet" href="<c:url value="/resources/twitter-bootstrap/css/bootstrap.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/AdminLTE.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/skins/_all-skins.min.css" />" >

        <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.min.js" />" ></script>
        <script type="text/javascript"  src="<c:url value="/resources/twitter-bootstrap/js/bootstrap.min.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js" />"></script>
    <!-- AdminLTE App -->
        <script type="text/javascript" src="<c:url value="/resources/dist/js/app.min.js" />"></script>
    </head>
    <body class="sidebar-mini skin-green-light wysihtml5-supported">

        <%@include file="static_header.jsp" %>
        <div class="container-fluid">
            <div class="box box-primary">
                <div class="box-header with-border">Add Bus Expense</div>
                <div class="box-body" style="padding-left: 5%;padding-right: 5%;">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Bus Type</th>
                                <th>Manufacturer</th>
                                <th>Model</th>
                                <th>Number Plate</th>
                                <th>Original Cost</th>
                                <th>Date of Purchase</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="buses" items="${buses}">
                                <tr>
                                    <td>${buses.name}</td>
                                    <td>${buses.busType}</td>
                                    <td>${buses.manufacturer}</td>
                                    <td>${buses.model}</td>
                                    <td>${buses.numberplate}</td>
                                    <td>${buses.originalCost}</td>
                                    <td>${buses.dateOfPurchase}</td>
                                    <td>
                                        <a class="btn btn-warning" href="/homebusiness/bus/${buses.id}/editbus.html"><span class="glyphicon glyphicon-edit" ></span>&nbsp;Edit</a>&nbsp;|&nbsp;
                                        <a class="btn btn-danger" href="/homebusiness/bus/${buses.id}/deletebus.html"><span class="glyphicon glyphicon-remove-circle" ></span>&nbsp;Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <a class="btn btn-success" href="/homebusiness/bus/addbus.html">+&nbsp;Add Bus</a>
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
        <%@include file="static_footer.jsp" %>
</body>
</html>
