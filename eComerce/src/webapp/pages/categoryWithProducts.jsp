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
        <a href="/product/id/${product.getId()}">
          <img src="/resources/img/no-img.svg" alt="${product.getName()}">

          <div class="caption">
            <h3><c:out value="${product.getName()}"></c:out></h3>

            <p><c:out value="${product.getShortDesc()}"></c:out></p>

            <p>Price: <c:out value="${product.getPrice()}"></c:out></p>

          </div>
        </a>
      </div>
    </div>
  </c:forEach>
</div>

<%--end of body page--%>
<%@ include file="footer.jsp" %>