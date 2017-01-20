<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: parvinder.kumar
  Date: 05-01-2017
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>



<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Cutomer</h1>
            <p class="lead">Please fill in your information</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="customer">

            <h3>Basic Info</h3>

            <div class="form-group">
                <label for="name">Name </label>
                <form:input path="customerName" id="name" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="customerEmail" id="email" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="phoneno">Phone no</label>
                <form:input path="customerPhone" id="phoneno" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="username">Username</label>
                <form:input path="username" id="username" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <form:password path="password" id="password" class="form-control"></form:password>
            </div>

            <h3>Billing Address</h3>

            <div class="form-group">
                <label for="billingStreet">Street Name</label>
                <form:input path="billingAddress.streetName" id="billingStreet" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="billingApartmentNumber">Apartment Number</label>
                <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="billingCity">City</label>
                <form:input path="billingAddress.city" id="billingCity" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="billingState">State</label>
                <form:input path="billingAddress.state" id="billingState" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="billingCountry">Country</label>
                <form:input path="billingAddress.country" id="billingCountry" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="billingZip">Zipcode</label>
                <form:input path="billingAddress.zipCode" id="billingZip" class="form-control"></form:input>
            </div>

            <h3>Shipping Address</h3>

            <div class="form-group">
                <label for="shippingStreet">Street Name</label>
                <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="shippingApartmentNumber">partment Number</label>
                <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="shippingCity">City</label>
                <form:input path="shippingAddress.city" id="shippingCity" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="shippingState">State</label>
                <form:input path="shippingAddress.state" id="shippingState" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="shippingCountry">Country</label>
                <form:input path="shippingAddress.country" id="shippingCountry" class="form-control"></form:input>
            </div>

            <div class="form-group">
                <label for="shippingZip">Zipcode</label>
                <form:input path="shippingAddress.zipCode" id="shippingZip" class="form-control"></form:input>
            </div>

            <input type="submit" value="submit" class="btn btn-default"/>
            <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp"%>
    </div>
</div>
