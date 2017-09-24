<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.fadein.css">
   <!-- <link rel="stylesheet" href="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.spinner.css"> -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="//raw.githubusercontent.com/ressio/lazy-load-xt/master/dist/jquery.lazyloadxt.js"></script>
    <script src="//ressio.github.io/lazy-load-xt/libs/error.js"></script>
    <script src="//ressio.github.io/lazy-load-xt/libs/jquery/jquery.js"></script>
    <script src="//ressio.github.io/lazy-load-xt/libs/bootstrap/js/bootstrap.min.js"></script>
    <script src="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.js"></script>
    <title>Produkty</title>

       <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.js"></script>
       <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.js"></script>
       <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.7.0/themes/base/jquery-ui.css">
       <!-- //code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css -->
                                    <script type="text/javascript">

                                        $(document).ready(function(){
                                            $('#productName').autocomplete({
                                                source : '${pageContext.request.contextPath}/products/search/search',
                                                minChars: 3,
                                                delay : 300

                                            });

                                        });

                                    </script>

                                    <style media="screen" type="text/css">
                                        .ui-autocomplete {
                                            margin:0;
                                            padding:0;
                                            list-style-type:none;
                                            border: solid 1px #ccc;
                                            background-color: #fff;
                                            width: 500px;
                                        }

                                        .ui-autocomplete li {
                                            font-family: Arial, Verdana, Sans-Serif;
                                            margin: 1px;
                                            cursor: pointer;
                                            display: block;
                                            height: 34px;
                                            padding: 6px 12px;
                                            font-size: 14px;
                                            line-height: 1.428571429;
                                        }


                                        .ui-autocomplete .ui-state-focus { background-color: #66afe9; }
                                        a#ui-active-menuitem .ui-corner-all .ui-state-hover { background-color: #66afe9; }
                                        ui-state-hover {
                                            background-color: #66afe9;
                                        }

                                        .ui-helper-hidden-accessible { display:none; }

                                    </style>

</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Produkty</h1>
            <p>Wszystkie produkty dostępne w naszym sklepie</p>
             Wyszukaj  <input type="text" id="productName">


        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                   <!-- <img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image" style = "width:100%"/> -->
                    <c:choose>
                        <c:when test="${empty product.base64Image}">
                        </c:when>
                        <c:otherwise>
                            <img id="profileImage" data-src="data:image/jpg;base64,${product.base64Image}" style = "width:100%"/>
                        </c:otherwise>
                    </c:choose>
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>${product.unitPrice} PLN</p>
                        <p>Liczba sztuk w magazynie:${product.unitsInStock}</p>
                        <p>
                            <a href=" <spring:url value="/products/product?id=${product.productId}" />" class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Szczegóły
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>