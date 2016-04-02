<%@ include file="header.jsp" %>
<%--start of body page--%>

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