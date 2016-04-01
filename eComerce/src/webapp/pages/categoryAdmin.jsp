<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>

<p><a class="btn btn btn-primary" href="/category/add" role="button">Добавить категорию</a></p>

<form id="update" action=""></form>
<table class="table table-hover">
    <tbody>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>ID родительской категории</th>
        <th></th>
    </tr>
    <c:forEach items="${categoryList}" var="category">
        <tr>
            <td><c:out value="${category.getId()}"></c:out></td>
            <td><c:out value="${category.getName()}"></c:out></td>
            <td><c:out value="${category.getParentId()}"></c:out></td>
            <td>
                <form method="get">
                    <button class="btn btn-primary" formaction="/category/update/${category.getId()}">
                        Изменить
                    </button>
                    <button class="btn btn-danger" formaction="/category/delete/${category.getId()}">
                        Удалить
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%--end of body page--%>
<%@ include file="footer.jsp" %>