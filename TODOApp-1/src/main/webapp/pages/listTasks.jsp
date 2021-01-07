<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/UserNavigation.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello ${requestScope.name} </h1>
	<br/>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of TODO's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="30%">Task Name</th>
						<th width="30%">Description</th>
						<th width="30%">Target Date</th>
						<th width="10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tasks}" var="tasks">
						<tr>
							<td>${tasks.taskName}</td>
							<td>${tasks.taskDescription}</td>
							<td>${tasks.taskDate}</td>
							<td><a type="button" class="btn btn-warning" href="/deleteTask?id=${tasks.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>