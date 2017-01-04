<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link rel="stylesheet" href="css/nUser.css">

<form:form modelAttribute="user" action="saveUser" method="post">
<h1>Sign Up</h1>
	<form:input path="name" placeholder="user name" />
	<form:input path="email" placeholder="user email"/>
	<label for="email">${exception}</label>
	<form:input path="password" placeholder="user password"/>
	<!-- <input name="phone" placeholder="user phone"/> -->
	<button class="send">save user</button>
</form:form> 




<script src="js/newU.js"></script>


<%-- <form:form modelAttribute="user" action="saveUser" method="post">
	<form:input path="name" placeholder="user name" />
	<form:input path="email" placeholder="user email"/>
	<label for="email">${exception}</label>
	<form:input path="password" placeholder="user password"/>
	<input name="phone" placeholder="user phone"/>
	<button>save user</button>
</form:form> --%>