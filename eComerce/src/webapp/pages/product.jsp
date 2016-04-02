<%@ include file="header.jsp" %>
<%--start of body page--%>
<h1>${product.getName()}</h1>

<div class="row">
    <div class="col-md-4">
        <%--image insert here--%>
        <img src="..." alt="" class="img-thumbnail">
    </div>
    <div class="col-md-8">
        <div class="well well-sm">${product.getShortDesc()}</div>
        <dl class="dl-horizontal">
            <dt>Price</dt>
            <dd>${product.getPrice()}</dd>
            <dt>Quantity</dt>
            <dd>${product.getQuantity()}</dd>
        </dl>
        <form name="add-to-cart" action="/cart/add" method="post">
            <input name="id" value="${product.getId()}" hidden>
            <button class="btn btn-success">Add to Cart</button>
        </form>
    </div>
    <div class="col-md-12">
        <h3>Description</h3>

        <p>${product.getDesc()}</p>
    </div>
</div>

<%--end of body page--%>
<%@ include file="footer.jsp" %>
