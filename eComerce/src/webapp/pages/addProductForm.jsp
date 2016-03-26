<%@ include file="header.jsp" %>
<%--start of body page--%>

<form class="form-horizontal" action="/product/add/action" method="get">
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
            <input type="text" class="form-control" id="description" name="description" placeholder="Description">
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
            <input type="submit" value="Add">
        </div>
    </div>
</form>

<%--end of body page--%>
<%@ include file="footer.jsp" %>
