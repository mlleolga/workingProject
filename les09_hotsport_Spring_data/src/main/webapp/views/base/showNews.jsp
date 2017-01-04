<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
    <!-- <h2>SHOW NEWS</h2> -->
    <c:forEach var="news" items="${news}">
	<div style="background-color: yellow; width: 1100px">
			news from id = ${news.id} , title =  ${news.title} , date of public = ${news.dateofPublic}, 
			categories of news = 
			 <c:forEach var="categor" items="${news.categories}">
			${categor.title}
			</c:forEach>, 
			team1 = ${news.team1.title}
			<a href="detailed/${news.id}">details</a>
			
			
			</div>
	</c:forEach>
    
    