<%-- 
    Document   : addbus
    Created on : Sep 9, 2016, 1:20:38 PM
    Author     : Mumbi Chishimba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Delete Expense</title>
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
                <div class="box-header with-border"><b>Are you  sure you want to delete this Bus?</b></div>
                <div class="box-body" style="padding-left: 5%;padding-right: 5%;">
                    <c:url var="addAction" value="/homebusiness/addbus.html" ></c:url>
                    <form:form modelAttribute="bus" method="POST" commandName="bus" cssClass="form-horizontal" >
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input name="name" value="${bus.name}" class="form-control" id="name"/>
                        </div> 
                        <div class="form-group">
                            <label for="busType">Bus Type</label>
                            <input name="busType" value="${bus.busType}" class="form-control" id="busType"/>
                        </div>
                        <div class="form-group">
                            <label for="manufacturer">Manufacturer</label>
                            <input name="manufacturer" value="${bus.manufacturer}" class="form-control" id="manufacturer"/>
                        </div>
                        <div class="form-group">
                            <label for="model">Model</label>
                            <input name="model" value="${bus.model}" class="form-control" id="model"/>
                        </div>
                        <div class="form-group">
                            <label for="numberplate">Number Plate</label>
                            <input name="numberplate" value="${bus.numberplate}" class="form-control" id="numberplate"/>
                        </div>
                        <div class="form-group">
                            <label for="originalCost">Original Cost</label>
                            <input name="originalCost" value="${bus.originalCost}" class="form-control" id="originalCost" />
                        </div>
                        <div class="form-group">
                            <label for="dateOfPurchase">Date of Purchase</label>
                            <input name="dateOfPurchase" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${bus.dateOfPurchase}"></fmt:formatDate>" class="form-control" id="dateOfPurchase"/>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-danger"> Yes</button>
                                <a href="/homebusiness/bus/view/all.html" class="btn btn-success"> No</a>
                            </div>
                            <input type="hidden" name="id" value="${buses.id}"/>
                    </form:form>
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
        <script type="text/javascript">
            $(function () {
                $('#dateOfExpense').datepicker({
                    format: 'mm/dd/yyyy'
                });
            });
        </script>
    </body>
</html>
