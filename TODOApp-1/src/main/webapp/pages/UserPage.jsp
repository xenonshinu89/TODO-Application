<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ include file="common/UserNavigation.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${requestScope.Title}</title>
</head>
<body>
<h1>Hello ${requestScope.userName}</h1>


</body>
</html>