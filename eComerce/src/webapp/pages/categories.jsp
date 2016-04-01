<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<%--start of body page--%>


<div class="list-group">
    <c:forEach items="${categoriesList}" var="category">
        <a href="/category/id/<c:out value="${category.getId()}"></c:out>" class="list-group-item">
            <h4 class="list-group-item-heading"><c:out value="${category.getName()}"></c:out></h4>
            <p class="list-group-item-text"><c:out value="${category.getDesc()}"></c:out></p>
        </a>
    </c:forEach>
</div>


<%--end of body page--%>
<%@ include file="footer.jsp" %>