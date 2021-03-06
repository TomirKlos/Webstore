<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.js"></script>
<script src="//raw.githubusercontent.com/ressio/lazy-load-xt/master/dist/jquery.lazyloadxt.js"></script>
<link rel="stylesheet" href="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.fadein.css">

<script src="/resource/js/controllers.js"></script>

<section class="container" ng-app="cartApp">

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Sukces! Produkt został dodany do koszyka</h4>
                </div>
                <div class="modal-body">
                    <p>Nazwa:<b>${product.name}</b> <br> Cena za sztukę: <b>${product.unitPrice}PLN </b></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Zamknij</button>
                </div>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-md-5">

            <c:choose>
                <c:when test="${empty productPicture.base64Image}">
                    <img class="img-responsive" id="profileImage" data-src="http://v-ie.uek.krakow.pl/~s193340/noImageAvailable.png" style = "width:100%"/>
                </c:when>
                <c:otherwise>
                    <img class="img-responsive" id="profileImage" data-src="data:image/jpg;base64,${productPicture.base64Image}" alt="image" style = "width:100%"/>
                </c:otherwise>
            </c:choose>

        </div>
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong>Kod produktu: </strong><span class="label-warning">${product.productId}</span>
            </p>
            <p>
                <strong>Producent</strong>: ${product.manufacturer}
            </p>
            <p>
                <strong>Kategoria</strong>: ${product.category}
            </p>
            <p>
                <strong>Dostępna liczba sztuk</strong>:${product.unitsInStock}
            </p>
            <h4>${product.unitPrice}PLN</h4>
            <p>

            <p ng-controller="cartCtrl">
                <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')" data-toggle="modal" data-target="#myModal">
                    <span class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz </a>

                <a href="<spring:url value="/products" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a>
                <a href="<spring:url value="/cart" />" class="btn btn-default">
                    <span class="glyphicon-hand-right glyphicon"></span> Koszyk
                </a>
            </p>
        </div>
    </div>
</section>

