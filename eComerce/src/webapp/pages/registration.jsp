<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%--start of body page--%>

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-8">
        <form class="form-horizontal">

            <div class="form-group">
                <label for="login" class="col-sm-2 control-label">Логин</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="login" placeholder="Логин" required>
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email</label>

                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" placeholder="Email" required>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Пароль</label>

                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" placeholder="Пароль" required>
                </div>
            </div>

            <div class="form-group">
                <label for="first-name" class="col-sm-2 control-label">Имя</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="first-name" placeholder="Имя">
                </div>
            </div>

            <div class="form-group">
                <label for="last-name" class="col-sm-2 control-label">Фамилия</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="last-name" placeholder="Фамилия">
                </div>
            </div>

            <div class="form-group">
                <label for="birthday" class="col-sm-2 control-label">Дата вашего рождения</label>

                <div class="col-sm-10">
                    <input type="date" class="form-control" id="birthday" >
                </div>
            </div>

            <div class="form-group">
                <label for="telephone" class="col-sm-2 control-label">Телефон</label>

                <div class="col-sm-10">
                    <input type="tel" class="form-control" id="telephone" required>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Сохранить</button>
                </div>
            </div>
        </form>
    </div>
</div>


<%--end of body page--%>
<%@ include file="footer.jsp" %>
