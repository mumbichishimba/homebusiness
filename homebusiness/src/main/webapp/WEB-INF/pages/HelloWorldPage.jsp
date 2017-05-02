<%-- 
    Document   : HelloWorldPage
    Created on : Sep 8, 2016, 4:41:51 PM
    Author     : Mumbi Chishimba Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="<c:url value="/resources/twitter-bootstrap/css/bootstrap.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/AdminLTE.min.css" />" >
        <link rel="stylesheet" href="<c:url value="/resources/dist/css/skins/_all-skins.min.css" />" >

        <script type="text/javascript" src="<c:url value="/resources/jquery/jquery.min.js" />" ></script>
        <script type="text/javascript"  src="<c:url value="resources/twitter-bootstrap/js/bootstrap.min.js" />"></script>

        <!-- AdminLTE App -->
        <script type="text/javascript" src="<c:url value="resources/dist/js/app.min.js" />"></script>

    </head>
    <body class="sidebar-mini skin-green-light wysihtml5-supported">
        <%@include file="static_header.jsp" %>
        <c:set var="average" scope="session" 
               value="${ (fn:length(sales) / fn:length(expenses))}"/>
        <!-- Widgets -->
        <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <div class="info-box-icon bg-aqua">
                        <i class="ion ion-ios-gear-outline">B</i>
                    </div>
                    <div class="info-box-content">
                        <div class="info-box-text">BUSES</div>
                        <div class="info-box-number" data-from="0">${fn:length(buses)}</div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <div class="info-box-icon bg-green">
                        <i class="ion ion-ios-gear-outline">S</i>
                    </div>
                    <div class="info-box-content">
                        <div class="info-box-text">SALES</div>
                        <div class="info-box-number" >${fn:length(sales)}</div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <div class="info-box-icon bg-red">
                        <i class="ion ion-ios-gear-outline">E</i>
                    </div>
                    <div class="info-box-content">
                        <div class="info-box-text">EXPENSES</div>
                        <div class="info-box-number">${fn:length(expenses)}</div>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="info-box">
                    <div class="info-box-icon bg-red">
                        <i class="ion ion-ios-gear-outline">T</i>
                    </div>
                    <div class="info-box-content">
                        <div class="info-box-text">SALES/EXPENSES</div>
                        <div class="info-box-number">${ratio}</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- #END# Widgets --> 

        <!----
        <div class="box box-info">
            <div class="box-header ui-sortable-handle"></div>
            <div class="box-body">
                <br/>
                <a href="/homebusiness/bus/addbus.html" class="btn btn-success">Add Bus</a>&nbsp;<a href="/homebusiness/bus/view/all.html" class="btn btn-success">View Buses</a>&nbsp;

                <a href="/homebusiness/bus/sale/add.html" class="btn btn-success">Add Bus Sale</a>&nbsp;<a href="/homebusiness/bussales/view/all.html" class="btn btn-success">View Bus Sales</a>&nbsp;

                <a href="/homebusiness/bus/expense/add.html" class="btn btn-success">Add Bus Expense</a>&nbsp;<a href="/homebusiness/busexpenses/view/all.html" class="btn btn-success">View Bus Expenses</a>&nbsp;

                <a href="/homebusiness/bussales/view/busmenu.html" class="btn btn-success">Sales Menu</a>
            </div>
            <div class="box-footer clearfix">
                &nbsp;
            </div>
        </div>
        ---->
        <div class="row">
            <div class="col-md-6">
                <!-- DIRECT CHAT -->
                <div class="box box-warning direct-chat direct-chat-warning">
                    <div class="box-header with-border">
                        <h3 class="box-title">LAST 10 SALES</h3>
                        <div class="box-tools pull-right">
                            
                            <span class="label label-danger"><a href="/homebusiness/bussales/view/all.html" style="color: white;">ALL</a></span>
                        </div>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Date</th>
                                        <th>Amount</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="sales" items="${sales}">
                                        <tr>
                                            <td><a href="/homebusiness/sale/${sales.id}/editsale.html">${sales.dateOfSale}</a></td>
                                            <td>K&nbsp;${sales.amount}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <a href="/homebusiness/bus/sale/add.html" class="btn btn-sm btn-info btn-flat pull-left">Add Bus Sale</a>
                        <a href="/homebusiness/bussales/view/busmenu.html" class="btn btn-sm btn-default btn-flat pull-right">View Sales</a>
                    </div>
                    <!-- /.box-footer-->
                </div>
                <!--/.direct-chat -->
            </div>
            <!-- /.col -->

            <div class="col-md-6">
                <!-- USERS LIST -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">BUSES</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Bus</th>
                                    <th>Number Plate</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="buses" items="${buses}">
                                    <tr>
                                        <td><a href="/homebusiness/bus/${buses.id}/editbus.html">${buses.name}</a></td>
                                        <td>&nbsp;${buses.numberplate}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <a href="/homebusiness/bus/addbus.html" class="btn btn-sm btn-info btn-flat pull-left">Add Bus</a>
                        <a href="/homebusiness/bus/view/all.html" class="btn btn-sm btn-default btn-flat pull-right">View All Buses</a>
                    </div>
                    <!-- /.box-footer -->
                </div>
                <!--/.box -->
            </div>
            <div class="col-md-6">
                <!-- USERS LIST -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">Expenses</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="expenses" items="${expenses}">
                                    <tr>
                                        <td><a href="/homebusiness/expense/${expenses.id}/editexpense.html">${expenses.dateOfExpense}</a></td>
                                        <td>K&nbsp;${expenses.amount}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <a href="/homebusiness/bus/expense/add.html" class="btn btn-sm btn-info btn-flat pull-left">Add Expense</a>
                        <a href="/homebusiness/busexpenses/view/all.html" class="btn btn-sm btn-default btn-flat pull-right">View All Expenses</a>
                    </div>
                    <!-- /.box-footer -->
                </div>
                <!--/.box -->
            </div>
            <!-- /.col -->
        </div>

        <%@include file="static_footer.jsp" %>

    </body>
</html>