<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initialscale=1.0">
    <title><tiles:insertAttribute name="title" /></title>
    <%--  <link href="http://getbootstrap.com/dist/css/bootstrap.css"	rel="stylesheet">  razem z tym nie wyswietla animacji produktow, a bez tego nie wyswietla animacji koszyka ;(--%>
    <link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">

                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                <style>
                    .modal-header, h4, .close {
                        background-color: #5cb85c;
                        color:white !important;
                        text-align: center;
                        font-size: 30px;
                    }
                    .modal-footer {
                        background-color: #f9f9f9;
                    }
                </style>

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
<div class="container">
    <script>
        $(document).ready(function(){
            $("#myBtn").click(function(){
                $("#myModalLogin").modal();
            });
        });
    </script>

                    <!-- Modal -->
                    <div class="modal fade" id="myModalLogin" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
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
                                    <form role="form" action="<c:url value="/j_spring_security_check"></c:url>" method="post">
                                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                                        <div class="form-group">
                                            <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                                            <input class="form-control" placeholder="Nazwaużytkownika" name='j_username' type="text" placeholder="Enter email" id="usrname">
                                        </div>
                                        <div class="form-group">
                                            <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                                            <input class="form-control" placeholder="Hasło" name='j_password' type="password" value="" placeholder="Enter password" id="psw">
                                        </div>
                                        <div class="checkbox">
                                            <label><input type="checkbox" value="" checked>Remember me</label>
                                        </div>
                                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                                    <p>Not a member? <a href="#">Sign Up</a></p>
                                    <p>Forgot <a href="#">Password?</a></p>
                                </div>
                            </div>

                        </div>
                    </div>

    <div class="header">
        <ul class="nav nav-pills pull-right">
            <tiles:insertAttribute name="navigation" />
        </ul>
        <h3 class="text-muted">Sklep internetowy </h3>

    </div>
    <div class="jumbotron">
        <h1>
            <tiles:insertAttribute name="heading" />
        </h1>
        <p>
            <tiles:insertAttribute name="tagline" />
        </p>

        <form action="${pageContext.request.contextPath}/products/searchByName">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search" name="search" id="productName">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                </div>
            </div>
        </form>

    </div>
    <div class="row">
        <tiles:insertAttribute name="content" />
    </div>
    <div class="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>