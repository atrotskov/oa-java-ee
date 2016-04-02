<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>
<h1>Новый продукт</h1>
<form class="form-horizontal" action="/product/add/action" method="post">
    <div class="form-group">
        <label for="vendor" class="col-sm-2 control-label">Vendor Code</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="vendor" name="vendor" placeholder="Vendor Code" required>
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name" placeholder="Product Name" required>
        </div>
    </div>
    <div class="form-group">
        <label for="short-desc" class="col-sm-2 control-label">Short Description</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="short-desc" name="short-desc" placeholder="Short Description">
        </div>
    </div>
    <div class="form-group">
        <label for="description" class="col-sm-2 control-label">Description</label>

        <div class="col-sm-10">
            <textarea class="form-control" rows="3" id="description" name="description"
                      placeholder="Description"></textarea>
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
        <label for="price" class="col-sm-2 control-label">Price</label>

        <div class="col-sm-10">
            <input type="number" min="0" class="form-control" id="price" name="price" placeholder="Price" required>
        </div>
    </div>
    <div class="form-group">
        <label for="quantity" class="col-sm-2 control-label">Quantity</label>

        <div class="col-sm-10">
            <input type="number" min="0" max="10" step="1" class="form-control" id="quantity" name="quantity" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-primary" value="Add">
        </div>
    </div>
</form>

<%--end of body page--%>
<%@ include file="footer.jsp" %>
