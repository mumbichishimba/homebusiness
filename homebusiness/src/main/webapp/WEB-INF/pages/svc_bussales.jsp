<%-- 
    Document   : viewbuses
    Created on : Sep 9, 2016, 1:20:49 PM
    Author     : Mumbi Chishimba Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table class="table table-striped" id="tables">
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
                    <a class="btn btn-danger" href="/homebusiness/sale/${sales.id}/delete.html"><span class="glyphicon glyphicon-remove-circle" ></span>&nbsp;Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a class="btn btn-success" href="/homebusiness/bus/sale/add.html">+&nbsp;Add Sale</a>


