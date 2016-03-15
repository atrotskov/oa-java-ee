<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <title>Insert title here</title>
</head>
<body>
<form action="/adduser" method="POST">
    First name : <input type="text" name="first-name">
    Last name : <input type="text" name="last-name">
    Email : <input type="text" name="email">
    Age : <input type="text" name="age">
    Role : <select name="role">
    <option selected value="USER">USER</option>
    <option value="ADMIN">ADMIN</option>
    <option value="SUPER-ADMIN">SUPER_ADMIN</option>
</select>
    <input type="submit" value="Add">
</form>

</body>
</html>