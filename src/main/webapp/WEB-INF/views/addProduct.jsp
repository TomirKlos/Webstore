<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Produkty</h1>
            <p>Dodaj produkty</p>
        </div>

        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post" class="btn btn-dangerbtn-mini pull-right">
            <input type="submit" value="Logout"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <!-- Nie dziala
        <a href="<c:url var="logoutUrl" value="/logout"/>" class="btn btn-dangerbtn-mini pull-right">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            Wyloguj się
        </a> -->
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data" >
        <fieldset>
        <legend>Dodaj nowy produkt</legend>
        <!--  <div class="form-group">
        <label class="control-label col-lg-2 col-lg-2" for="productId">Id produktu</label>
        <div class="col-lg-10">

        <form:input id="productId" path="productId" type="text" class="form:input-large" />
        </div>
        </div> -->

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name">
                <spring:message code="addProduct.form.name.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                <spring:message code="addProduct.form.unitPrice.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
                <spring:message code="addProduct.form.manufacturer.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="category">
                <spring:message code="addProduct.form.category.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="category" path="category" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                <spring:message code="addProduct.form.unitsInStock.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="description">
                <spring:message code="addProduct.form.description.label"/>
            </label>
            <div class="col-lg-10">
                <form:textarea id="description" path="description" rows ="2"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="conditionProduct">
                <spring:message code="addProduct.form.conditionProduct.label"/>
            </label>
            <div class="col-lg-10">
                <form:radiobutton path="conditionProduct" value="nowy" />Nowy
                <form:radiobutton path="conditionProduct" value="uzywany" />Używany
                <form:radiobutton path="conditionProduct" value="odnowiony"/>Odnowiony
            </div>
        </div>
        <form:form modelAttribute="productImage" class="form-horizontal" enctype="multipart/form-data" >
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProdcut.form.productImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
                </div>
            </div>
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
                </div>
            </div>
            </fieldset>
        </form:form>
    </form:form>
</section>
</body>
</html>