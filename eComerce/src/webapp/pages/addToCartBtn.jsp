<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<form id="add-to-cart" action="/cart/add" method="post">
  <input id="id" name="id" value="${product.getId()}" hidden>
  <button id="btn-add-to-cart" class="btn btn-success">Add to Cart</button>
</form>