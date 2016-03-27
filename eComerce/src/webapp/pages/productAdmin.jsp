<%@ include file="header.jsp" %>
<%--start of body page--%>

<table class="table table-hover">
  <tbody>
  <tr>
    <th>ID</th>
    <th>Vendor Code</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${productList}" var="product">
    <tr>
      <td><c:out value="${product.getId()}"></c:out></td>
      <td><c:out value="${product.getVendorCode()}"></c:out></td>
      <td><c:out value="${product.getName()}"></c:out></td>
      <td><c:out value="${product.getPrice()}"></c:out></td>
      <td><c:out value="${product.getQuantity()}"></c:out></td>
      <td>
        <form name="update-user" method="get" action="/product/update/${product.getId()}">
          <button>Update</button>
        </form>
        <form name="delete-user" method="get" action="/updateuser">
          <button>Delete</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<%--end of body page--%>
<%@ include file="footer.jsp" %>