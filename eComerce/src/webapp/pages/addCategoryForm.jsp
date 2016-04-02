<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>
<h1>Новая категория</h1>
<form class="form-horizontal" action="/category/add/action" method="post">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Имя</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name" placeholder="Имя категории" required>
        </div>
    </div>
    <div class="form-group">
        <label for="description" class="col-sm-2 control-label">Описание</label>

        <div class="col-sm-10">
            <textarea class="form-control" rows="3" id="description" name="description"
                      placeholder="Описание"></textarea>
            <%--<input type="text" class="form-control" id="description" name="description" placeholder="Description">--%>
        </div>
    </div>
    <div class="form-group">
        <label for="parent-name" class="col-sm-2 control-label">Выберите родительскую категорию</label>

        <div class="col-sm-10">
            <select class="form-control" id="parent-name" name="parent-name">
                <c:forEach items="${nameList}" var="name">
                    <option><c:out value="${name}"></c:out></option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-primary" value="Добавить">
        </div>
    </div>
</form>


<%--end of body page--%>
<%@ include file="footer.jsp" %>
