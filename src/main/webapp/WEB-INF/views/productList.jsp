<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: parvinder.kumar
  Date: 05-01-2017
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
        <div class="container">
            <div class="page-header">
               <h1>All Products</h1>
                <p class="lead">Check out all the available products here</p>
            </div>
            <table class="table table-striped table-hover" >
                <thead>
                <tr class="bg-success">
                    <th>Photo thumb</th>
                    <th>Product name</th>
                    <th>Product Category</th>
                    <th>Product Condition</th>
                    <th>Product Price</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="img" style="width: 100%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productId}"/>">
                        <span class="glyphicon glyphicon-info-sign">
                    </span></a> </td>
                </tr>
                </c:forEach>
            </table>
            
            <%@include file="/WEB-INF/views/template/footer.jsp"%>