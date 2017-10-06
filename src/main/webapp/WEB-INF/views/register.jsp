<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
<link
        href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css"
        rel="stylesheet"  type='text/css'>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
<style>
    body, html{
        height: 100%;
        background-repeat: no-repeat;
        background-color: #d3d3d3;
        font-family: 'Oxygen', sans-serif;
    }

    .main{
        margin-top: 20px;
    }

    h1.title {
        font-size: 50px;
        font-family: 'Passion One', cursive;
        font-weight: 400;
    }

    hr{
        width: 10%;
        color: #fff;
    }

    .form-group{
        margin-bottom: 15px;
    }

    label{
        margin-bottom: 15px;
    }

    input,
    input::-webkit-input-placeholder {
        font-size: 11px;
        padding-top: 3px;
    }

    .main-login{
        background-color: #fff;
        /* shadows and rounded borders */
        -moz-border-radius: 2px;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

    }

    .main-center{
        margin-top: 30px;
        margin: 0 auto;
        max-width: 330px;
        padding: 40px 40px;

    }

    .login-button{
        margin-top: 5px;
    }

    .login-register{
        font-size: 11px;
        text-align: center;
    }
    #success_message{ display: none;}

</style>
<script>
    $(document).ready(function() {
        $('#registerForm').bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                ssoId: {
                    validators: {
                        stringLength: {
                            min: 5,
                            max: 20,
                            message: 'Login musi być w przedziale 5-20 znaków'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9]+$/,
                            message: 'Nazwa użytkownika może składać się jedynie ze znaków alfanumerycznych'
                        },
                        notEmpty: {
                            message: 'Proszę podać swoją nazwę użytkownika'
                        }
                    }
                },
                firstName: {
                    validators: {
                        stringLength: {
                            min: 2,
                            message: 'Imię zbyt krótkie'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z]+$/,
                            message: 'Imię może składać się jedynie ze znaków alfabetu'
                        },
                        notEmpty: {
                            message: 'Proszę podać swoje imię'
                        }
                    }
                },
                lastName: {
                    validators: {
                        stringLength: {
                            min: 2,
                            message: 'Proszę podać swoje Nazwisko'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z]+$/,
                            message: 'Nazwisko może składać się jedynie ze znaków alfabetu'
                        },
                        notEmpty: {
                            message: 'Proszę podać swoje Nazwisko'
                        }
                    }
                },
                password: {
                    validators: {
                        stringLength: {
                            min: 5,
                            max: 20,
                            message: 'Hasło musi składać się z minimum 5 znaków'
                        },
                        notEmpty: {
                            message: 'Proszę podać hasło'
                        }
                    }
                },
                confirm: {
                    validators: {
                        stringLength: {
                            min: 5,
                            max: 20,
                        },
                        identical: {
                            field: 'password',
                            message: 'Hasła nie są identyczne'
                        },
                        notEmpty: {
                            message: 'Proszę wpisać hasło jeszcze raz'
                        }
                    }
                },
                email: {
                    validators: {
                        stringLength: {
                            min: 5,
                            max: 100,
                            message: 'Adres e-mail musi składać sie z mniej niż 100 znaków'
                        },
                        notEmpty: {
                            message: 'Proszę wpisać adres e-mail'
                        },
                        emailAddress: {
                            message: 'Proszę wpisać poprawny adres e-mail'
                        }
                    }
                },
                acceptTerms: {
                    validators: {
                        notEmpty: {
                            message: 'Zaakceptuj regulamin'
                        }
                    }
                },
            }
        })
            .on('success.form.bv', function(e) {
                $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#registerForm').data('bootstrapValidator').resetForm();

                // Prevent form submission
                e.preventDefault();

                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function(result) {
                    console.log(result);
                }, 'json');
            });
    });
</script>
<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Rejestracja</h1>
                <hr />
            </div>
        </div>
        <div class="main-login main-center">
            <form:form method="POST" modelAttribute="user" id="registerForm" class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>

                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label" for="ssoId">Nazwa użytkownika</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <c:choose>
                                <c:when test="${edit}">
                                    <form:input name="username" type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
                                </c:when>
                                <c:otherwise>
                                    <form:input name="username" type="text" path="ssoId" id="ssoId" class="form-control input-sm" placeholder="Wpisz Login" />
                                    <div class="has-error">
                                        <form:errors path="ssoId" class="help-inline"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Email</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input name="email" type="text" path="email" id="email" class="form-control input-sm" placeholder="Wpisz adres e-mail" />
                            <div class="has-error">
                                <form:errors path="email" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Imię</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input name="name" type="text" path="firstName" id="firstName" class="form-control input-sm" placeholder="Podaj swoje imię"/>
                            <div class="has-error">
                                <form:errors path="firstName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="surname" class="cols-sm-2 control-label">Nazwisko</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>

                            <form:input name="surname" type="text" path="lastName" id="lastName" class="form-control input-sm" placeholder="Podaj swoje nazwisko" />
                            <div class="has-error">
                                <form:errors path="lastName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Hasło</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input name="password" type="password" path="password" id="password" class="form-control input-sm" placeholder="Wpisz hasło" />
                            <div class="has-error">
                                <form:errors path="password" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="confirm" class="cols-sm-2 control-label">Potwierdź hasło</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="confirm" id="confirm"   placeholder="Potwierdź hasło"/>
                        </div>
                    </div>
                </div>
                <form:select style="visibility: hidden" type="hidden" path="userProfiles" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" >
                    <form:option style="visibility: hidden" type="hidden" value="1" selected="1">USER</form:option>
                </form:select>
                <div class="has-error">
                    <form:errors path="userProfiles" class="help-inline"/>
                </div>
                <div class="form-group">
                    <div class="col-lg-11 col-lg-offset-1">
                        <div class="checkbox">
                            <input type="checkbox" name="acceptTerms" /> Akceptuję regulamin
                        </div>
                    </div>
                </div>


                    <button type="submit" href="<c:url value='/register' />" class="btn btn-primary btn-lg btn-block login-button">Zarejestruj!</button>
                </div>

                <div class="login-register">
                    <a href="<spring:url value="/login"/>">Login</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
