<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:forEach var="country" items="${countries}">
	<div style="background-color: yellow">
		${country.name} <a href="deleteCountry/${country.id}">delete
			country</a>

		<c:forEach var="team" items="${country.teamsCountry}">
			${team.title}
			<a href="deleteTeamFromCountry/${team.id}">delete team</a>

		</c:forEach>

	</div>
	<br>
</c:forEach>


<%-- <form action="saveCountry" method="post">
	<input name="name" placeholder="country name">
	<br>
	<button>save country</button>
</form> --%>

<form:form modelAttribute="country" action="saveCountry" method="post">
	<form:input path="name" type="text" placeholder="name country" />
	<br>
	<button>save country</button>
</form:form>
