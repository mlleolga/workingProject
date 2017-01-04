<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:forEach var="news" items="${news}">
		<div style="background-color: yellow">
			${news.title} <a href="deleteNews/${news.id}">delete news</a>
		
		
		
		
		
		</div>
		<br>
	</c:forEach>

	<form:form modelAttribute="newsIn" action="saveNews" method="post">
		<form:input path="title" placeholder="title of news" />
		<input name="date" type="date">

		<!-- ADDING TEAM1 & TEAM2 -->
		<%-- <form:select path="team1">
			<c:forEach var="team1" items="${teams1}">
				<form:option value="${team1.id}">${team1.title}</form:option>
			</c:forEach>
		</form:select>
		
		<form:select path="team2">
			<c:forEach var="team2" items="${teams2}">
				<form:option value="${team2.id}">${team2.title}</form:option>
			</c:forEach>
		</form:select> --%>
		
		<!-- WAS CHANGED FOR DTOs -->
		<form:select path="team1" items="${teams1DTOs}" itemLabel="title"
			itemValue="id">
		</form:select>
		<form:select path="team2" items="${teams2DTOs}" itemLabel="title"
			itemValue="id">
		</form:select>
		<form:select path="categories">
			<c:forEach var="team1" items="${categor}">
				<form:option value="${team1.id}">${team1.title}</form:option>
			</c:forEach>
		</form:select>
		
		



		<button>save news</button>
	</form:form>