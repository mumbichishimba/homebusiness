<%-- 
    Document   : addfarm
    Created on : Sep 9, 2016, 1:20:38 PM
    Author     : Mumbi Chishimba Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Farm Expense</title>

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
        <div class="box box-primary">
            <div class="box-header with-border">Add Farm Expense</div>
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
                </form:form>
                <form:form modelAttribute="farmExpense" method="POST" commandName="farmExpense"  cssClass="form-horizontal" >
                    <div class="form-group">
                        <div class="form-line">
                            <input name="expenseName" class="form-control" placeholder="Expense Name" id="expenseName">
                        </div>
                    </div> 
                    <div class="form-group">
                        <div class="form-line">
                            <input name="expenseType" class="form-control" placeholder="Expense Type" id="expenseType">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-line">
                            <input name="amount" class="form-control" placeholder="Amount" id="amount">
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success">+ Submit</button>
                    </div>
                </form:form>
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
        <%@include file="static_footer.jsp" %>
        <script type="text/javascript">
            $(function () {
                $('#dateOfPurchase').datepicker({
                    format: 'mm/dd/yyyy'
                });
            });
        </script>
    </body>
</html>
