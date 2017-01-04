<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:forEach var="player" items="${players}">
	<div style="background-color: yellow">
		${player.name} ${player.surname} <a href="deletePlayer/${player.id}">delete
			player</a>

		<%-- <a href="deleteTeamFromPlayer/${player.id}">delete team</a> --%>

		<%-- <c:forEach var="team" items="${player.teams}">
			${team.title}
			<a href="deleteTeamFromPlayer/${team.id}">delete team</a>

		</c:forEach> --%>

	</div>
	<%-- <c:forEach var="country" items="${player.countries}">
			${country.name}
			<a href="deleteCountryFromPlayer/${country.id}">delete country</a>
	</c:forEach> --%>

	<br>
</c:forEach>

<form:form modelAttribute="playerin" action="savePlayer" method="post">
	<form:input path="name" placeholder="player name" />
	<form:input path="surname" placeholder="player surname" />

	<form:select path="team">
		<c:forEach var="team" items="${teams}">
			<form:option value="${team.id}">${team.title}</form:option>
		</c:forEach>
	</form:select>


	<button>save player</button>
</form:form>

<!-- <form action="savePlayer" method="post">
	<input name="playerName" placeholder="player name">
	<input name="playerSurName" placeholder="player surname">
	<br>
	<button>save player</button>
</form> -->