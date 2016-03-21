<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List of all users</title>
</head>
<body>
<form name="adduser" method="GET" action="/adduser">
    <button>Add User</button>
</form>
<table class="table">
    <tbody>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Age</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${userList}" var="user">
        <tr>
            <td><c:out value="${user.getId()}"></c:out></td>
            <td><c:out value="${user.getEmail()}"></c:out></td>
            <td><c:out value="${user.getFirstName()}"></c:out></td>
            <td><c:out value="${user.getLastName()}"></c:out></td>
            <td><c:out value="${user.getAge()}"></c:out></td>
            <td><c:out value="${user.getRole()}"></c:out></td>
            <td>
                <form name="deleteuser" method="POST" action="/deleteuser">
                    <button name="id" value="<c:out value="${user.getId()}"></c:out>">Delete</button>
                </form>
                <form name="updateuser" method="POST" action="/updateuser">
                    <button name="id" value="<c:out value="${user.getId()}"></c:out>">Update</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>