<%@ include file="header.jsp" %>
<%--start of body page--%>


  <div class="row">
<c:forEach items="${productList}" var="product">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="..." alt="...">
      <div class="caption">
        <h3><c:out value="${product.getName()}"></c:out></h3>
        <p><c:out value="${product.getShortDesc()}"></c:out></p>
        <p><c:out value="${product.getPrice()}"></c:out></p>
        <p><c:out value="${product.getQuantity()}"></c:out></p>
        <p><a href="#" class="btn btn-primary" role="button">Add to Cart</a></p>
      </div>
    </div>
  </div>
</c:forEach>
  </div>

<%--end of body page--%>
<%@ include file="footer.jsp" %>