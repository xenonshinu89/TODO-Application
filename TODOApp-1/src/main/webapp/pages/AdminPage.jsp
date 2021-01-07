<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="common/commonStyling.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${requestScope.Title}</title>
</head>
<body>
<h1>Hello ${requestScope.user}</h1>
<nav role="navigation" class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/">Home</a></li>
		</ul>
		<ul class="nav navbar-nav">
			<li><a href="/logout">Logout</a></li>
		</ul>
	</div>
</nav>

<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of TODO's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="25%">User Name</th>
						<th width="25%">Task Name</th>
						<th width="25%">Description</th>
						<th width="25%">Target Date</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tasks}" var="tasks">
						<tr>
							<td> ${tasks.userName} </td>
							<td>${tasks.taskName}</td>
							<td>${tasks.taskDescription}</td>
							<td>${tasks.taskDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>