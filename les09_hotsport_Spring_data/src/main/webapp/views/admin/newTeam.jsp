<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:forEach var="team" items="${teams}">
		${team.title}
		<a href="deleteTeam/${team.id}">delete team</a>

		<c:forEach var="player" items="${team.players}">
			${player.name} ${player.surname}
			<a href="deletePlayerFromTeam/${player.id}">delete player</a>

		</c:forEach>
		<br>
	</c:forEach>

<form:form modelAttribute="teamNew" action="saveTeam" method="post">
	<form:input path="title" placeholder="team name"/>

	<!-- WAS CHANGED FOR DTOs -->
<%-- <form:select path="country">
			<c:forEach var="country" items="${countriesDTOs}">
				<form:option value="${country.id}">${country.name}</form:option>
			</c:forEach>
		</form:select> --%>
		
<form:select path="country" items="${countriesDTOs}" itemLabel="name"
			itemValue="id">
		</form:select>


	


	
	
	<button>save team</button>
</form:form>

<%-- <form:select path="country" items="${countriesDTOs}" itemLabel="name"
			itemValue="id">
		</form:select> --%>
<%-- <form:select path="country">
			<c:forEach var="country" items="${country}">
				<form:option value="${country.id}">${country.title}</form:option>
			</c:forEach>
		</form:select>  --%>

	<%-- <form action="saveTeam" method="post">

		<input name="teamName" placeholder="team name">
		<select name="playerId" multiple="multiple">

			<c:forEach var="player" items="${players}">

				<option value="${player.id}">${player.name}
					${player.surname}</option>

			</c:forEach>


		</select>


		<button>save team</button>
	</form> --%>
