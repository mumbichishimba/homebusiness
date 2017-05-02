<%-- 
    Document   : farms
    Created on : Dec 24, 2016, 11:31:44 AM
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
        <title>Farms</title>

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
            <div class="box-header with-border">Farms</div>
            <div class="box-body" style="padding-left: 5%;padding-right: 5%;">
                <div class="box-body" style="padding-left: 5%;padding-right: 5%;">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Town</th>
                                <th>Location</th>
                                <th>Farm Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="farms" items="${farms}">
                                <tr>
                                    <td>${farms.name}</td>
                                    <td>${farms.name}</td>
                                    <td>${farms.location}</td>
                                    <td>${farms.price}</td>
                                    <td>
                                        <a class="btn btn-success" href="/homebusiness/farm/${farms.id}/viewfarm.html"><span class="glyphicon glyphicon-eye-open" ></span>&nbsp;View</a>&nbsp;|&nbsp;
                                        <a class="btn btn-warning" href="/homebusiness/farm/${farms.id}/editfarm.html"><span class="glyphicon glyphicon-edit" ></span>&nbsp;Edit</a>&nbsp;|&nbsp;
                                        <a class="btn btn-danger" href="/homebusiness/farm/${farms.id}/deletefarm.html"><span class="glyphicon glyphicon-remove-circle" ></span>&nbsp;Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <a class="btn btn-success" href="/homebusiness/farm/add.html">+&nbsp;Add Farm</a>
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
