<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>

<spring:form action="Signup"  modelAttribute="emp" method="post">
Name : <spring:input path="name"/><br>
Email : <spring:input path="email"/><br>
Mobile : <spring:input path="mobile"/><br>
Password : <spring:input path="password"/><br>
<spring:button>Signup</spring:button>
</spring:form>

</body>

</html>