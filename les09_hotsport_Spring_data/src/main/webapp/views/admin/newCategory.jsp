<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:forEach var="category" items="${categories}">
	<div style="background-color: yellow">
		${category.title}<a href="deleteCategory/${category.id}">delete
			category</a>
	</div>
	<br>
</c:forEach>

<form:form modelAttribute="categoryIn" action="saveCategory" method="post">
	<form:input path="title" placeholder="category title" />

	<button>save category</button>
</form:form>