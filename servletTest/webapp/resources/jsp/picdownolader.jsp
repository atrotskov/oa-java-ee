<%--
  Created by IntelliJ IDEA.
  User: jdev
  Date: 07.02.2016
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Picters Downloader</title>
</head>
<body>
<div>
    <h1>File Upload</h1>

    <form method="post" action="/upload"
          enctype="multipart/form-data">
        Select file to upload: <input type="file" name="file" size="60"/><br/>
        <br/> <input type="submit" value="Upload"/>
    </form>
</div>
<div class="message"><c:out value="${message}"></c:out></div>
<div>
    <c:forEach items="${imgList}" var="img">
        <img src="<c:out value="${img}"></c:out>" width="250" />
    </c:forEach>
</div>
</body>
</html>
