<%@ include file="common/commonStyling.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${requestScope.Title}</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="/user">Add Tasks</a><li>
			<li><a href="/admin">View All Tasks</a></li>
		</ul>
	</div>
</nav>

</body>
</html>