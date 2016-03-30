<%@ include file="header.jsp" %>
<%--start of body page--%>

<form class="form-horizontal" action="/user/add" method="post">

  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">Name</label>

    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="Product Name" required>
    </div>
  </div>
  <div class="form-group">
    <label for="description" class="col-sm-2 control-label">Description</label>

    <div class="col-sm-10">
            <textarea class="form-control" rows="3" id="description" name="description"
                      placeholder="Description"><c:out value="${category.getDesc()}"></c:out></textarea>
      <%--<input type="text" class="form-control" id="description" name="description" placeholder="Description">--%>
    </div>
  </div>
  <div class="form-group">
    <label for="parent-name" class="col-sm-2 control-label">Choose parent Category</label>

    <div class="col-sm-10">
      <select class="form-control" id="parent-name" name="parent-name">
        <c:forEach items="${nameList}" var="name">
          <option
                  <c:choose>
                    <c:when test="${name == parentName}">
                      selected
                    </c:when>
                  </c:choose>>
            <c:out value="${name}"></c:out>
          </option>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-primary" value="Update">
    </div>
  </div>
</form>


<%--end of body page--%>
<%@ include file="footer.jsp" %>
