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
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal">
    <fieldset>
        <legend>Dodaj nowy produkt</legend>
      <!--  <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="productId">Id produktu</label>
            <div class="col-lg-10">
                <form:input id="productId" path="productId" type="text" class="form:input-large"/>
            </div>
        </div> -->
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="name">name</label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="unitPrice">cena</label>
            <div class="col-lg-10">
                <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="manufacturer">manufacturer</label>
            <div class="col-lg-10">
                <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="category">category</label>
            <div class="col-lg-10">
                <form:input id="category" path="category" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">unitsInStock</label>
            <div class="col-lg-10">
                <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="description">Opis</label>
            <div class="col-lg-10">
                <form:textarea id="description" path="description" rows ="2"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="conditionProduct">Stan</label>
            <div class="col-lg-10">
                <form:radiobutton path="conditionProduct" value="nowy" />Nowy
                <form:radiobutton path="conditionProduct" value="uzywany" />Używany
                <form:radiobutton path="conditionProduct" value="odnowiony"/>Odnowiony
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
            </div>
        </div>
    </fieldset>
    </form:form>
</section>
</body>
</html>