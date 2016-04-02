<%--
  Created by IntelliJ IDEA.
  User: alexey
  Date: 15.03.16
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <%--Padding for NavBar--%>
    <style>
        body {
            padding-top: 70px;
        }
    </style>

    <title>${pageTitle}</title>
</head>
<body>
<header class="header">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">My shop</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/product">Товары</a></li>
                    <li><a href="/category">Категории</a></li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Поиск">
                    </div>
                    <button type="submit" class="btn btn-default">Найти</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="/admin" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Панель Администратора<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/product/admin">Товары</a></li>
                            <li><a href="/category/admin">Категории</a></li>
                            <li><a href="/order/admin">Заказы</a></li>
                            <li><a href="/user/admin">Пользователи</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Войти</a></li>
                    <li><a href="#">Регистрация</a></li>
                    <li class="dropdown">
                        <a href="/cart" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Корзина<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <%@ include file="cartNavPanel.jsp" %>
                            <%--<li><a href="/cart">Перейти в корзину</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>--%>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</header>

<div class="row">
    <div class="col-md-8">
