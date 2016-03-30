<%@ include file="header.jsp" %>
<%--start of body page--%>
<form id="update" action=""></form>
<table class="table table-hover">
    <tbody>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Parent Category Id</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${categoryList}" var="category">
        <tr>
            <td><c:out value="${category.getId()}"></c:out></td>
            <td><c:out value="${category.getName()}"></c:out></td>
            <td><c:out value="${category.getParentId()}"></c:out></td>
            <td>
                <form method="get">
                    <button class="btn btn-primary" formaction="/category/update/${category.getId()}">
                        Update
                    </button>
                    <button class="btn btn-danger" formaction="/category/delete/${category.getId()}">
                        Delete
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%--end of body page--%>
<%@ include file="footer.jsp" %>