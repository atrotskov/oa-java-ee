<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>

<h1>${category.getName()}</h1>
<div class="well well-sm">${category.getDesc()}</div>

<div class="row">
  <c:forEach items="${productList}" var="product">
    <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
        <img src="..." alt="...">

        <div class="caption">
          <h3><c:out value="${product.getName()}"></c:out></h3>

          <p><c:out value="${product.getShortDesc()}"></c:out></p>

          <p>Price: <c:out value="${product.getPrice()}"></c:out></p>

          <p>Quantity: <c:out value="${product.getQuantity()}"></c:out></p>

          <p><a href="/product/id/${product.getId()}" class="btn btn-primary" role="button">Read moore...</a>
          <form name="add-to-cart" action="/tocart" method="post">
            <input name="id" value="${product.getId()}" hidden>
            <button class="btn btn-success">Add to Cart</button>
          </form>
          </p>
        </div>
      </div>
    </div>
  </c:forEach>
</div>

<%--end of body page--%>
<%@ include file="footer.jsp" %>