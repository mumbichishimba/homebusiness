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
                                    <th>Date of Sale</th>
                                    <th>Description</th>
                                    <th>Amount</th>
                                    <th>Bus</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="sales" items="${sales}">
                                    <tr>
                                        <td><fmt:formatDate value="${sales.dateOfSale}" pattern="dd MMM yyyy"></fmt:formatDate></td>
                                        <td>${sales.description}</td>
                                        <td>${sales.amount}</td>
                                        <td>${sales.bus.name}</td>
                                        <td>
                                            <a class="btn btn-warning" href="/homebusiness/sale/${sales.id}/editsale.html"><span class="glyphicon glyphicon-edit" ></span>&nbsp;Edit</a>&nbsp;|&nbsp;
                                            <a class="btn btn-danger" href="/homebusiness/sale/${sales.id}/delete.html"  data-toggle="modal" data-target="#delmodal"><span class="glyphicon glyphicon-remove-circle" ></span>&nbsp;Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <a class="btn btn-success" href="/homebusiness/bus/sale/add.html">+&nbsp;Add Sale</a>
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
        <!-- Modal -->
        <div id="delmodal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <html:form action="deleteprerequisite">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Delete</h4>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Yes</button>
                            <button type="button" class="btn btn-info" data-dismiss="modal">No</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </html:form>
                </div>

            </div>
        </div>
        <%@include file="static_footer.jsp" %>
        <script type="text/javascript">
            
        </script>
    </body>
</html>
