<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.js"></script>
<script src="//raw.githubusercontent.com/ressio/lazy-load-xt/master/dist/jquery.lazyloadxt.js"></script>
<link rel="stylesheet" href="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.fadein.css">
<style>
    .description {
        white-space: nowrap;
        width: 100%;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    #testLink{
        position:absolute;
        width:89%;
        height:95%;
        top:0;
        left:15px;
        right:35px;
        margin-right:80px;

        z-index: 1;

    /* fixes overlap error in IE7/8,
       make sure you have an empty gif */
        background-image: url('empty.gif');

    }
    .box {
        position: relative;
        display: inline-block;
        width: 100%;
        height: 100%;
        background-color: #fff;
        border-radius: 2px;
        box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
        border-radius: 3px;
        -webkit-transition: all 0.3s cubic-bezier(0.165, 0.84, 0.44, 1);
        transition: all 0.3s cubic-bezier(0.165, 0.84, 0.44, 1);
    }

    .box::after {
        content: "";
        border-radius: 2px;
        position: absolute;
        z-index: -1;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        opacity: 0;
        -webkit-transition: all 0.5s cubic-bezier(0.165, 0.84, 0.44, 1);
        transition: all 0.5s cubic-bezier(0.165, 0.84, 0.44, 1);
    }

    .box:hover {
        -webkit-transform: scale(1.03, 1.03);
        transform: scale(1.03, 1.03);
    }

    .box:hover::after {
        opacity: 1;
    }

 /*   #borderproduct{
        border:1px solid #dd;
        border-radius: 2px;
        box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.2);
        transition: all 70ms ease-out;
    }
    #borderproduct:hover {
        box-shadow: 0 0 6px rgba(35, 173, 278, 1);
    }
*/
</style>
<div class="row">
    <c:forEach items="${products}" var="product">
        <div class="col-sm-3">


            <div class="panel panel-default box" id="borderproduct">
                <a href=" <spring:url value="/products/product?id=${product.productId}" />">
                    <span id="testLink"></span>
                </a>
                <div class="panel-heading">
                    <h3 class="panel-title description">${product.name}</h3>
                </div>
                <div class="panel-body">
                    <c:forEach items="${productThumbnails}" var="productThumbnail">
                        <c:if test="${product.productId eq productThumbnail.productId}">
                                <c:choose>
                                    <c:when test="${empty productThumbnail.base64Image}">
                                        <img class="img-responsive" id="profileImage" data-src="http://v-ie.uek.krakow.pl/~s193340/noImageAvailable.png" style = "width:100%"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img class="img-responsive" id="profileImage" data-src="data:image/jpg;base64,${productThumbnail.base64Image}" style = "width:100%"/>
                                    </c:otherwise>
                                </c:choose>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="panel-footer">
                    <p id="description" class="description">${product.description}</p>
                    <p>${product.unitPrice} PLN</p>
                    <p>Liczba sztuk w magazynie:${product.unitsInStock}</p>

                        <a href=" <spring:url value="/products/product?id=${product.productId}" />" class="btn btn-primary">
                            <span class="glyphicon-info-sign glyphicon"/></span> Szczegóły
                        </a>

                </div>
            </div>
        </div>
    </c:forEach>
</div><br><br>



