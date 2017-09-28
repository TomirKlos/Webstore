<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


    <script   src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>

    <script src="/resource/js/controllers.js"></script>


<section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

        <div>
            <a class="btn btn-danger pull-left"
               ng-click="clearCart()"> <span
                    class="glyphicon glyphicon-remove-sign"></span> Wyczyść koszyk
            </a> <a href="<spring:url value="/checkout?cartId=${cartId}"/>" class="btn btn-success pull-right"> <span
                class="glyphicon-shopping-cart glyphicon"></span> Kupuję
        </a>
        </div>
        <table class="table table-hover">
            <tr>
                <th>Produkt</th>
                <th>Cena za sztukę</th>
                <th>Ilość</th>
                <th>Cena</th>
                <th>Działanie</th>
            </tr>
            <tr ng-repeat="item in cart.cartItems">
                <td>{{item.product.productId}}-{{item.product.name}}</td>
                <td>{{item.product.unitPrice}}</td>
                <td>{{item.quantity}}</td>
                <td>{{item.totalPrice}}</td>
                <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)"> <span
                        class="glyphicon glyphicon-remove" /></span> Usuń
                </a></td>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th>Kwota</th>
                <th>{{cart.grandTotal}}</th>
                <th></th>
            </tr>
        </table>

        <a href="<spring:url value="/products" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span> Powrót do strony produktów
        </a>
    </div>
</section>
