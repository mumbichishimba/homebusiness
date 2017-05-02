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
        <title>Bus Sales</title>
        <link rel="stylesheet" href="<c:url value="/resources/twitter-bootstrap/css/bootstrap.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/AdminLTE.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/skins/_all-skins.min.css" />" >

        <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.min.js" />" ></script>
        <script type="text/javascript"  src="<c:url value="/resources/twitter-bootstrap/js/bootstrap.min.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/bootstrap-datepicker/js/bootstrap-datepicker.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/dist/js/app.min.js" />"></script>
    </head>
    <body class="sidebar-mini skin-green-light wysihtml5-supported">

        <%@include file="static_header.jsp" %>
        <div class="box box-primary">
            <div class="box-header with-border">View Farm Sales</div>
            <div class="box-body" style="padding-left: 5%;padding-right: 5%;">
                <form:form modelAttribute="farm" method="POST" commandName="farm"  cssClass="form-horizontal" >
                    <div class="form-group">
                        <div class="form-line">
                            <input name="name" readonly="" class="form-control"  value="${farm.name}" placeholder="Name" id="name">
                        </div>
                    </div> 
                    <div class="form-group">
                        <div class="form-line">
                            <input name="town" readonly="" class="form-control"  value="${farm.town}" placeholder="Town" id="town">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-line">
                            <input name="location" readonly="" class="form-control" value="${farm.location}" placeholder="Location" id="location">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-line">
                            <input name="price" readonly="" class="form-control" value="${farm.price}" placeholder="Price" id="price">
                        </div>
                    </div>
                    <div class="form-group">
                        <a class="btn btn-primary" href="/homebusiness/farm/${farm.id}/viewfarm.html"><span class="glyphicon glyphicon-asterisk" ></span>&nbsp;Areas</a>&nbsp;&nbsp;
                        <a class="btn btn-danger" href="/homebusiness/farm/${farm.id}/viewfarmexpenses.html"><span class="glyphicon glyphicon-asterisk" ></span>&nbsp;Expenses</a>&nbsp;&nbsp;
                        <a class="btn btn-info" href="/homebusiness/farm/${farm.id}/viewfarmsales.html"><span class="glyphicon glyphicon-euro" ></span>&nbsp;Sales</a>&nbsp;&nbsp;
                    </div>
                </form:form>
                <h2>Farm Sales</h2>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Amount</th>
                            <th>Date</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="farmSales" items="${farmSales}">
                            <tr>
                                <td>${farmSales.amount}</td>
                                <td><fmt:formatDate pattern="dd MMMM yyyy" value="${farmSales.dateOfSales}"></fmt:formatDate></td>
                                <td>${farmSales.description}</td>
                                <td>
                                    <a class="btn btn-warning" href="/homebusiness/farm/${farmSales.id}/editfarm.html"><span class="glyphicon glyphicon-edit" ></span>&nbsp;Edit</a>&nbsp;|&nbsp;
                                    <a class="btn btn-danger" href="/homebusiness/farm/${farmSales.id}/deletefarm.html"><span class="glyphicon glyphicon-remove-circle" ></span>&nbsp;Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a class="btn btn-success" href="/homebusiness/farm/${farm.id}/sale/add.html?id=${farm.id}">+&nbsp;Add Sales</a>
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
        <%@include file="static_footer.jsp" %>
    </body>

</html>
