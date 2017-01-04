<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<h2>DETAILED NEWS</h2>

news from id =${news.id} , title =  ${news.title} , date of public = ${news.dateofPublic}, 
			categories of news = 
			 <c:forEach var="categor" items="${news.categories}">
			${categor.title}
			</c:forEach> , 
			team1 = ${news.team1.title}, team2 = ${news.team2.title}