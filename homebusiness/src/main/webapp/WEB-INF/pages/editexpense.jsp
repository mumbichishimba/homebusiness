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
        <title>Edit Sale</title>
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
                        <form:form modelAttribute="busExpense" method="POST" commandName="busExpense" cssClass="form-horizontal" >
                            <div class="form-group">
                                <label for="dateOfExpense">Date of Expense</label>
                                <input name="dateOfExpense"  class="form-control" id="dateOfExpense" value="<fmt:formatDate value="${busExpense.dateOfExpense}" pattern="MM/dd/yyyy"></fmt:formatDate>" />
                                </div>
                                <div class="form-group">
                                    <label for="expenseType">Expense Type</label>
                                    <input name="expenseType" value="${busExpense.expenseType}" class="form-control" id="description"/>
                            </div> 
                            <div class="form-group">
                                <label for="amount">Amount</label>
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">K</span>
                                    <input name="amount" value="${busExpense.amount}" class="form-control" id="amount"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="busId">Bus</label>

                                <select name="busId" class="form-control" id="busId">
                                    <c:forEach var="buses" items="${buses}">
                                        <c:if test="${buses.id==busExpense.id}">
                                            <option class="form-control" value="${buses.id}" selected="" >${buses.name}</option>
                                        </c:if>
                                        <c:if test="${buses.id!=busExpense.id}">
                                            <option class="form-control" value="${buses.id}" >${buses.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success">+ Save</button>
                            </div>
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
