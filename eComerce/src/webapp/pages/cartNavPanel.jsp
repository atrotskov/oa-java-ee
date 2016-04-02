<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<c:choose>
  <c:when test="${cartImpl.getAll().size() > 0}">
    <li><a href="/cart">Перейти в корзину</a></li>
    <c:forEach items="${cartImpl.getAll()}" var="product">
      <li><c:out value="${product.getName()}"></c:out>
        <c:out value="${product.getPrice()}"></c:out></li>
    </c:forEach>
  </c:when>
  <c:otherwise>
  <li><a href="#">Ваша корзина пуста</a></li>
</c:otherwise>
</c:choose>