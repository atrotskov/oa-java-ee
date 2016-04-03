<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>
  <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
  <style>
    body {
      padding-top: 70px;
    }
  </style>
  <title>Вход</title>
</head>
<body>

<div class="row">
  <div class="col-md-4"></div>
  <div class="col-md-4">
    <form class="form-horizontal" method="post" action="/login">
    <div class="form-group">
      <label for="username" class="col-sm-2 control-label">Логин</label>
      <div class="col-sm-10">
        <input type="text" id="username" name="username" class="form-control" placeholder="Имя пользователя">
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-sm-2 control-label">Пароль</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Вход</button>
      </div>
    </div>
  </form>

    <c:if test="${param.error != null}">
      <div class="alert alert-danger" role="alert">
        <p><strong>О черт.</strong> Неверно введен логин или пароль</p>
      </div>
    </c:if>
  </div>
  <div class="col-md-4"></div>
</div>

</body>
</html>
