<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>

<p><a class="btn btn btn-primary" href="/product/add" role="button">Добавить продукт</a></p>

<form id="update" action=""></form>
<table class="table table-hover">
    <tbody>
    <tr>
        <th>ID</th>
        <th>Vendor Code</th>
        <th>Имя</th>
        <th>Цена</th>
        <th>Наличие</th>
        <th></th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td><c:out value="${product.getId()}"></c:out></td>
            <td><c:out value="${product.getVendorCode()}"></c:out></td>
            <td><c:out value="${product.getName()}"></c:out></td>
            <td><c:out value="${product.getPrice()}"></c:out></td>
            <td><c:out value="${product.getQuantity()}"></c:out></td>
            <td>
                <form method="get">
                    <button class="btn btn-primary" formaction="/product/update/${product.getId()}">
                        Изменить
                    </button>
                    <button class="btn btn-danger" formaction="/product/delete/${product.getId()}">
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