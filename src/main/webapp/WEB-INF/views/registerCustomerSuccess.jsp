<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <h1>Customer registered successfully.</h1>

            </div>
        </section>
    </div>
    <section class="container" ng-app="cartApp">
        <p>
            <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Products</a>
        </p>
    </section>


</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
