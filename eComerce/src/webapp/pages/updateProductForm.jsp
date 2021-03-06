<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>
<h1>Обновите информацию о подукте</h1>
<form class="form-horizontal" action="/product/update" method="post">
  <input hidden name="id" value="<c:out value="${product.getId()}"></c:out>">
  <div class="form-group">
    <label for="vendor" class="col-sm-2 control-label">Vendor Code</label>

    <div class="col-sm-10">
      <input type="text" class="form-control" id="vendor" name="vendor" placeholder="Vendor Code" value="<c:out value="${product.getVendorCode()}"></c:out>" required>
    </div>
  </div>
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">Name</label>

    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="Product Name" required value="<c:out value="${product.getName()}"></c:out>">
    </div>
  </div>
  <div class="form-group">
    <label for="short-desc" class="col-sm-2 control-label">Short Description</label>

    <div class="col-sm-10">
      <input type="text" class="form-control" id="short-desc" name="short-desc" placeholder="Short Description" value="<c:out value="${product.getShortDesc()}"></c:out>">
    </div>
  </div>
  <div class="form-group">
    <label for="description" class="col-sm-2 control-label">Description</label>

    <div class="col-sm-10">
            <textarea class="form-control" rows="3" id="description" name="description"
                      placeholder="Description"><c:out value="${product.getDesc()}"></c:out></textarea>
      <%--<input type="text" class="form-control" id="description" name="description" placeholder="Description">--%>
    </div>
  </div>
  <div class="form-group">
    <label for="exampleInputFile" class="col-sm-2 control-label">Product Picture</label>

    <div class="col-sm-10">
      <input type="file" id="exampleInputFile">

      <p class="help-block">Please select picture for product</p>
    </div>
  </div>

  <div class="form-group">
    <label for="categories" class="col-sm-2 control-label">Категории</label>

    <div class="col-sm-10">
      <select multiple class="form-control" id="categories" name="categories">
        <c:forEach items="${nameList}" var="name">
          <option value="<c:out value="${name}"></c:out>">
            <c:out value="${name}"></c:out>
          </option>
        </c:forEach>
      </select>
    </div>
  </div>

  <div class="form-group">
    <label for="price" class="col-sm-2 control-label">Цена</label>

    <div class="col-sm-10">
      <input type="number" min="0" class="form-control" id="price" name="price" placeholder="Price" required value="<c:out value="${product.getPrice()}"></c:out>">
    </div>
  </div>
  <div class="form-group">
    <label for="quantity" class="col-sm-2 control-label">Количество на складе</label>

    <div class="col-sm-10">
      <input type="number" min="0" max="10" step="1" class="form-control" id="quantity" name="quantity" required value="<c:out value="${product.getQuantity()}"></c:out>">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-primary" value="Обновить">
    </div>
  </div>
</form>

<%--end of body page--%>
<%@ include file="footer.jsp" %>
