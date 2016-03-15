<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel='stylesheet' href='/webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
    <title>Insert title here</title>
</head>
<body>
<form action="/updateuserdone" method="POST">
    <input type="hidden" name="id" value="<c:out value="${userForUpdate.getId()}"></c:out>">
    First name : <input type="text" name="first-name" value="<c:out value="${userForUpdate.getFirstName()}"></c:out>">
    Last name : <input type="text" name="last-name" value="<c:out value="${userForUpdate.getLastName()}"></c:out>">
    Email : <input type="text" name="email" value="<c:out value="${userForUpdate.getEmail()}"></c:out>">">
    Age : <input type="text" name="age" value="<c:out value="${userForUpdate.getAge()}"></c:out>">
    Role : <select name="role" >
    <option selected value="USER">USER</option>
    <option value="ADMIN">ADMIN</option>
    <option value="SUPER-ADMIN">SUPER_ADMIN</option>
</select>
    <input type="submit" value="Update">
</form>

</body>
</html>