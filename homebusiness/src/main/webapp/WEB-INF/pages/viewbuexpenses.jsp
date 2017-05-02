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
        <title>Bus Expenses</title>
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
                <div class="box-header with-border">Bus Expenses</div>
                <div class="box-body" style="padding-left: 5%;padding-right: 5%;">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Date of Expense</th>
                                    <th>Description</th>
                                    <th>Amount</th>
                                    <th>Bus</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="expenses" items="${expenses}">
                                    <tr>
                                        <td><fmt:formatDate value="${expenses.dateOfExpense}" pattern="dd MMM yyyy"></fmt:formatDate></td>
                                        <td>${expenses.expenseType}</td>
                                        <td>${expenses.amount}</td>
                                        <td>${expenses.bus.name}</td>
                                        <td>
                                            <a class="btn btn-warning" href="/homebusiness/expense/${expenses.id}/editexpense.html"><span class="glyphicon glyphicon-edit" ></span>&nbsp;Edit</a>&nbsp;|&nbsp;
                                            <a class="btn btn-danger" href="/homebusiness//expense/${expenses.id}/delete.html"><span class="glyphicon glyphicon-remove-circle" ></span>&nbsp;Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <a class="btn btn-success" href="/homebusiness/bus/expense/add.html">+&nbsp;Add Expense</a>
                    </div>
                </div>
            </div> <br/>
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
