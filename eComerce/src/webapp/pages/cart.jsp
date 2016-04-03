<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>
<h1>Корзина</h1>
<h3>Списко заказанных товаров</h3>
<%--вывести список продуктов--%>

<table class="table table-hover">
  <tbody>
  <tr>
    <th>ID</th>
    <th>Имя</th>
    <th>Цена</th>
    <th>Наличие</th>
    <th></th>
  </tr>
  <c:forEach items="${cartImpl.getAll()}" var="product">
    <tr>
      <td><c:out value="${product.getId()}"></c:out></td>
      <td><c:out value="${product.getName()}"></c:out></td>
      <td><c:out value="${product.getPrice()}"></c:out></td>
      <td><c:out value="${product.getQuantity()}"></c:out></td>
      <td>
        <form method="post" action="/cart/fromcart">
          <input name="id" value="${product.getId()}" hidden>
          <button class="btn btn-danger">Удалить</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>



<%--end of body page--%>
<%@ include file="footer.jsp" %>
