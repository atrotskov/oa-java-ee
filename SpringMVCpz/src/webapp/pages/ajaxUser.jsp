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
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <%--<script src="<c:url value="/resources/js/jquery.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>--%>

    <title>Панель управления пользователями</title>
</head>
<body>
<form action="/adduser" method="POST">
    First name : <input type="text" name="first-name">
    Last name : <input type="text" name="last-name">
    Email : <input type="text" name="email">
    Age : <input type="text" name="age">
    Role : <select name="role">
    <option selected value="USER">USER</option>
    <option value="ADMIN">ADMIN</option>
    <option value="SUPER-ADMIN">SUPER_ADMIN</option>
</select>
    <input type="submit" value="Add">
</form>

<div class="user-list">

</div>

</body>
<script type="text/javascript">
    $.ajax({
        url: '/api/users/get/all',         	// указываем URL и
        dataType: "json",                 	// тип загружаемых данных
        success: function (data) { 		// вешаем свой обработчик на функцию success
            $.each(data, function (i, val) {	// обрабатываем полученные данные
                console.log(val.lastName);
            });
        }

    });


</script>
</html>
