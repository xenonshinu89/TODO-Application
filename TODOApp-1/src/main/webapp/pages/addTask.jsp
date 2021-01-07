<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="common/UserNavigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add tasks</title>
</head>
<body>
<h1>Hello  ${requestScope.userName} </h1>
	<h1>Add tasks</h1>
	<form method="post" action="/addTaskItem" >
		Task Name : <input type="text"  name="taskName" required="required"></input>
	 	Task Description : <input type="text"  name="taskDescription" required="required"></input>
	 	Task Date : <input type="date" placeholder="dd-mm-yyyy"  name="taskDate" required="required"></input>
		 <input type="submit"/>
	</form>
</body>
</html>