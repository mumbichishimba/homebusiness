<%-- 
    Document   : report_bus
    Created on : Dec 28, 2016, 10:42:42 AM
    Author     : Mumbi Chishimba Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <script type="text/javascript" src="<c:url value="/resources/Chart.js/Chart.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/Chart.js/Chart.bundle.min.js" />"></script>
    </head>
    <body class="sidebar-mini skin-green-light wysihtml5-supported">
        <%@include file="static_header.jsp" %>

        <div class="container-fluid">
            <!-------- Basic details ------->
            <div class="col-md-6" style="width: 100%;">
                <!-- USERS LIST -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">BUSES: ${fn:length(buses)}</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Bus</th>
                                    <th>Number Plate</th>
                                    <th>Bus Type</th>
                                    <th>Manufacturer</th>
                                    <th>Model</th>
                                    <th>Original Cost</th>
                                    <th>Date of Purchase</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="buses" items="${buses}">
                                    <tr>
                                        <td>&nbsp;${buses.name}</td>
                                        <td>&nbsp;${buses.numberplate}</td>
                                        <td>&nbsp;${buses.busType}</td>
                                        <td>&nbsp;${buses.manufacturer}</td>
                                        <td>&nbsp;${buses.model}</td>
                                        <td>&nbsp;${buses.originalCost}</td>
                                        <td>&nbsp;<fmt:formatDate value="${buses.dateOfPurchase}" pattern="dd MMMM yyyy"></fmt:formatDate></td>
                                        </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!--/.box -->
            </div>

            <!-------- Bus sales ------->
            <div class="col-md-6" style="width: 100%;">
                <!-- USERS LIST -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">&nbsp;Sales and Expenses</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table class="table">
                            <tbody>

                                <tr>
                                    <th>Total Sales</th>
                                    <td>&nbsp;${fn:length(sales)}</td>
                                </tr>
                                <tr>
                                    <th>Sales Amount</th>
                                    <td>&nbsp;${sales_amount}</td>
                                </tr>
                                <tr>
                                    <th>Total Expenses</th>
                                    <td>&nbsp;${fn:length(expenses)}</td>
                                </tr>
                                <tr>
                                    <th>Expenses Amount</th>
                                    <td>&nbsp;${expenses_amount}</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!--/.box -->
            </div>

            <!-------- Year sales ------->
            <div class="col-md-6" style="width: 100%;">
                <!-- USERS LIST -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">Year Sales: K&nbsp;${sales_amount_total}</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">

                        <h1>Chart here</h1>
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="chart-responsive">
                                        <div id="canvas-holder" style="width:90%">
                                            <canvas id="chart-area" />
                                        </div>
                                    </div>
                                    <!-- ./chart-responsive -->
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </div>

                        <table class="table">
                            <tbody>
                                <c:forEach var="sales" items="${sales}">
                                    <tr>
                                        <th>${sales.name}</th>
                                        <td>K&nbsp;${sales.value}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!--/.box -->
            </div>

            <!-------- Year sales ------->
            <div class="col-md-6" style="width: 100%;">
                <!-- USERS LIST -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">Year Expenses: K&nbsp;${expenses_amount_total}</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">

                        <h1>Chart here</h1>
                        <div class="box-body" >
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="chart-responsive">
                                        <div id="canvas-holder" style="width:100%">
                                            <canvas id="chart-area-expenses" />
                                        </div>
                                    </div>
                                    <!-- ./chart-responsive -->
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </div>

                        <table class="table">
                            <tbody>

                                <c:forEach var="expenses" items="${expenses}">
                                    <tr>
                                        <th>${expenses.name}</th>
                                        <td>K&nbsp;${expenses.value}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!--/.box -->
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

        <script type="text/javascript">

            var salesData = new Array();
            var expensesData = new Array();
            var colours = ["red", "orange", "yellow", "green", "blue", "indigo", "violet", "brown", "lightgreen", "pink", "lightblue", "aqua"];
            var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

            <c:forEach var="sales" items="${sales}">
            salesData.push(${sales.value});
            </c:forEach>

            <c:forEach var="expenses" items="${expenses}">
            expensesData.push(${expenses.value});
            </c:forEach>

            var randomScalingFactor = function () {
                return Math.round(Math.random() * 100);
            };


            var sales = {
                type: 'pie',
                data: {
                    datasets: [{
                            data: salesData,
                            backgroundColor: colours,
                            label: 'Dataset 1'
                        }],
                    labels: months
                },
                options: {
                    responsive: true
                }
            };

            var expenses = {
                type: 'pie',
                data: {
                    datasets: [{
                            data: expensesData,
                            backgroundColor: colours,
                            label: 'Dataset 1'
                        }],
                    labels: months
                },
                options: {
                    responsive: true
                }
            };

            window.onload = function () {

                var ctx = document.getElementById("chart-area").getContext("2d");
                var ctex = document.getElementById("chart-area-expenses").getContext("2d");

                window.myPie = new Chart(ctx, sales);
                window.myPie = new Chart(ctex, expenses);
            };

            document.getElementById('randomizeData').addEventListener('click', function () {
                sales.data.datasets.forEach(function (dataset) {
                    dataset.data = dataset.data.map(function () {
                        return randomScalingFactor();
                    });
                });

                window.myPie.update();
            });

            var colorNames = Object.keys(window.chartColors);
            document.getElementById('addDataset').addEventListener('click', function () {
                var newDataset = {
                    backgroundColor: [],
                    data: [],
                    label: 'New dataset ' + sales.data.datasets.length,
                };

                for (var index = 0; index < sales.data.labels.length; ++index) {
                    newDataset.data.push(randomScalingFactor());

                    var colorName = colorNames[index % colorNames.length];
                    ;
                    var newColor = window.chartColors[colorName];
                    newDataset.backgroundColor.push(newColor);
                }

                sales.data.datasets.push(newDataset);
                window.myPie.update();
            });

            document.getElementById('removeDataset').addEventListener('click', function () {
                sales.data.datasets.splice(0, 1);
                window.myPie.update();
            });
        </script>
    </body>
</html>
