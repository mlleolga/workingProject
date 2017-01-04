<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">

	<c:forEach var="user" items="${users}">
		<div style="background-color: aqua">
			${user.name} <a href="deleteUser/${user.id}">delete user</a>
		</div>
		<br>
	</c:forEach>

</sec:authorize>

