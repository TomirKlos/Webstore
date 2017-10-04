<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.7.0/themes/base/jquery-ui.css">
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $('#productName').autocomplete({
            source : '${pageContext.request.contextPath}/products/search/search',
            minChars: 3,
            delay : 300,
        });
    });
</script>
<script>
    $('li a').click(function(e) {
        e.preventDefault();
        $('a').removeClass('active');
        $(this).addClass('active');
    });
</script>
<script>
    $(document).ready(function(){
        $("#myBtn").click(function(){
            $("#myModalLogin").modal();
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
<div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand active" href="#">KlasterStore</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
           <!-- <li class="active"><a href="#">Home</a></li> -->
            <li><a href="<spring:url value="/products"/>">Home</a></li>
            <li><a href="<spring:url value="/products"/>">Strona główna</a></li>
            <li><a href="<spring:url value="/products"/>">Produkty</a></li>
            <li><a href="<spring:url value="/products/add"/>">Dodaj produkt</a></li>
            <li><a href="<spring:url value="/list"/>">Uzytkownicy</a></li>
        </ul>

        <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/products/searchByName">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search" name="search" id="productName">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit">
                        <i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.authenticated}">
                    <li><a href="#" id="myBtn"><span class="glyphicon glyphicon-user"></span> Zalogowano jako ${username}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="#" id="myBtn"><span class="glyphicon glyphicon-user"></span> Logowanie</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="<spring:url value="/cart/"/>"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        </ul>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModalLogin" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.authenticated}">
                    <div class="alert alert-success">
                        Jesteś już zalogowany.<br>
                    </div>
                    <c:url var="logoutUrl" value="/logout"/>
                    <form action="${logoutUrl}" method="post" >
                        <input type="submit" value="Logout" class="btn btn-danger btn-mini pull-right"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </c:when>
                <c:otherwise>


            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
                </div>
            </c:if>
            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
            </div>
            <div class="modal-body" style="padding:40px 50px;">
                <form role="form" action="<c:url value="/login"></c:url>" method="post">

                    <div class="form-group">
                        <label for="usrname"><span class="glyphicon glyphicon-user"></span> Nazwa użytkownika</label>
                        <input class="form-control" placeholder="Nazwa użytkownika" name='ssoId' type="text" placeholder="Enter email" id="usrname">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Hasło</label>
                        <input class="form-control" placeholder="Hasło" name='password' type="password" value="" placeholder="Enter password" id="psw">
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" value="" checked>Zapamiętaj mnie</label>
                    </div>
                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Anuluj</button>

                <p>Nie masz konta? <a href="#">Zarejestruj się</a></p>
                <p>Zapomniałeś <a href="#">hasła?</a></p>
            </div>

                </c:otherwise>
            </c:choose>
        </div>

    </div>
</div>

