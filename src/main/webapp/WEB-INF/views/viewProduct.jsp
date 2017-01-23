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
    <div class="container" >
        <div class="page-header">
            <h1>Product Details</h1>
            <p class="lead">Here are the product is in detail</p>
        </div>
     </div>
    <div class="container" ng-app="cartApp">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="img" style="width: 100%"/>
            </div>
            <div class="col-md-5">
                <p>${product.productName}</p>
                <p>${product.productDescription}</p>
                <p>${product.productCategory}</p>
                <p>${product.productCondition}</p>
                <p>${product.productManufacturer}</p>
                <p>${product.productPrice}</p>
                <br>

                <c:set var="role" scope="page" value="${param.role}"/>
                <c:set var="url" scope="page" value="/product/productList"/>
                <c:if test="${role=='admin'}">
                    <c:set var="url" scope="page" value="/admin/productInventory"/>
                </c:if>

                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                    <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
                        <span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                    <a href="<spring:url value="/customer/cart"/>"
                    class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart </a>
                </p>
            </div>
        </div>
        <script src="<c:url value="/resources/js/controller.js"/>"></script>
        <%@include file="/WEB-INF/views/template/footer.jsp"%>
    </div>
 </div>

