<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">

	<!-- <a href="admin">admin page</a> -->
<h2>control panel</h2> 
	<br>
	<a href="newCountry">add country</a>
	<br>
	<a href="newPlayer">add player</a>
	<br>
	<a href="newTeam">add team</a>
	<br>
	<a href="newCategory">add team</a>
	<br>



</sec:authorize>
