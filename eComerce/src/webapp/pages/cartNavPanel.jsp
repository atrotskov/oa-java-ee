<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>



<c:choose>
  <c:when test="${cartImpl.getAll().size() > 0}">
    <li><a href="/cart">Перейти в корзину</a></li>
<table class="table">
  <tr>
    <th>ID</th>
    <th>Наименование товара</th>
    <th>Цена</th>
  </tr>


      <c:forEach items="${cartImpl.getAll()}" var="product">
        <tr>
          <td>
            <c:out value="${product.getId()}"></c:out>
          </td>
          <td>
            <c:out value="${product.getName()}"></c:out>
          </td>
          <td>
            <c:out value="${product.getPrice()}"></c:out>
          </td>

        </tr>

      </c:forEach>
      <tr>
        <td></td>
        <td><strong>Сумма заказа: </strong></td>
        <td><c:out value="${cartImpl.getTotalPrice()}"></c:out></td>
      </tr>
    </c:when>
    <c:otherwise>
      <li>Ваша корзина пуста</li>
    </c:otherwise>
  </c:choose>

</table>