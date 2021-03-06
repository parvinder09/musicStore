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
            <h1>Add Product</h1>
            <p class="lead">Fill the below information to add a new product</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/product/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name </label>
                    <form:errors path="productName" style="color:red"/>
                    <form:input path="productName" id="name" class="form-control"></form:input>

            </div>
            <div class="form-group">
                <label for="category">Category</label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="instrument"/>
                Instrument</label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="record"/>
                Record</label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory"/>
                Accessory</label>
            </div>
            <div class="form-group">
                <label for="description">Descriptioin</label>
                <form:textarea path="productDescription" id="description" class="form-control"></form:textarea>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <form:errors path="productPrice" style="color:#ff0000"/>
                <form:input path="productPrice" id="price" class="form-control"></form:input>
            </div>
            <div class="form-group">
                <label for="condition">Condition</label>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="new"/>
                    New</label>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="used"/>
                    Used</label>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active"/>
                    Active</label>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive"/>
                    Inactive</label>
            </div>
            <div class="form-group">
                <label for="unitinstock">Unit In Stock</label>
                <form:errors path="unitinstock" style="color:#ff0000"/>
                <form:input path="unitinstock" id="unitinstock" class="form-control"></form:input>
            </div>
            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <form:input path="productManufacturer" id="manufacturer" class="form-control"></form:input>
            </div>
            <div class="form-group">
                <label for="productImage">Upload Picture</label>
                <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
            </div>

            <input type="submit" value="submit" class="btn btn-default"/>
            <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>
       </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp"%>
    </div>
</div>