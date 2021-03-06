<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


    <title>Produkty</title>
        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post" >
            <input type="submit" value="Logout" class="btn btn-danger btn-mini pull-right"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <div class="pull-right" style="padding-right:50px">
            <a href="?language=pl" >polski</a>|<a href="?language=en">english</a>
        </div>
        <!-- Nie dziala
        <a href="<c:url var="logoutUrl" value="/logout"/>" class="btn btn-dangerbtn-mini pull-right">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            Wyloguj się
        </a> -->

<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data" >
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <fieldset>
        <legend>Dodaj nowy produkt</legend>
        <!--  <div class="form-group">
        <label class="control-label col-lg-2 col-lg-2" for="productId">Id produktu</label>
        <div class="col-lg-10">

        <form:input id="productId" path="productId" type="text" class="form:input-large" />
        <form:errors path="productId" cssClass="text-danger"/>
        </div>
        </div> -->

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name">
                <spring:message code="addProduct.form.name.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text" class="form:input-large"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                <spring:message code="addProduct.form.unitPrice.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                <form:errors path="unitPrice" cssClass="text-danger"/>
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
                <form:errors path="unitsInStock" cssClass="text-danger"/>
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
                <form:radiobutton path="conditionProduct" value="nowy" />
                <spring:message code="addProduct.form.conditionProductNew.label"/>
                <form:radiobutton path="conditionProduct" value="uzywany" />
                <spring:message code="addProduct.form.conditionProductUsed.label"/>
                <form:radiobutton path="conditionProduct" value="odnowiony"/>
                <spring:message code="addProduct.form.conditionProductRefurbished.label"/>
            </div>
        </div>
        <form:form modelAttribute="productImage" class="form-horizontal" enctype="multipart/form-data" >
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
                </div>
            </div>
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <a href="<spring:url value="/products" />" class="btn btn-primary">
                        <span class="glyphicon-hand-left glyphicon"></span> produkty
                    </a>
                    <input type="submit" id="btnAdd" class="btn btn-success" value ="Dodaj"/>
                </div>
            </div>
            </fieldset>
        </form:form>
    </form:form>
</section>
