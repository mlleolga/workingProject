<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>



<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<input type="hidden" name="csrf_name" value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value" value="${_csrf.token}" />

<%-- <sec:authentication property="name" /> --%>

<%-- <sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</sec:authorize> --%>

<%-- <sec:authorize access="!isAuthenticated()">
	<br>
	<a href="loginpage">login</a>
	<br>
	<a href="newUser">registration</a>
	<br> 
</sec:authorize>
 --%>




<sec:authorize access="hasRole('ROLE_ADMIN')">

	<!-- <a href="admin">admin page</a> -->

	<h2>control panel</h2>

	<a href="newCountry">add country</a>
	<br>
	<a href="newPlayer">add player</a>
	<br>
	<a href="newTeam">add team</a>
	<br>
	<a href="newCategory">add category</a>
	<br>

	<br>
	<a href="allUsers">all Users</a>
	<br>
	<br>
	<a href="newNews">add news</a>
	<br>
	<br>
</sec:authorize>


<br>


<h2>News categories</h2>
<c:forEach var="category" items="${categories}">

	<a href="showNews/${category.id}">${category.title} </a>
	<br>
</c:forEach>

<br>
<h2>All news</h2>
<c:forEach var="news" items="${news}">
	<div style="background-color: yellow; width: 1100px">
		news from id =${news.id} , title = ${news.title} , date of public =
		${news.dateofPublic}, categories of news =
		<c:forEach var="categor" items="${news.categories}">
			${categor.title}
			</c:forEach>
		, <a href="detailed/${news.id}">details</a>
	</div>
</c:forEach>



<button id="start"
	onclick='startFilter()'>
	start</button>

<div id="retNewsById">


</div>
<br>
<div id="retNewsByDate">


</div>
<script type="text/javascript">


function startFilter(){
var id = 5;	
	 console.log('Click');
	  var s = '';
	   $.ajax({
		     url: 'listFilter?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
	         method: 'POST',
	         contentType: 'application/json; charset=UTF-8',
	         dataType: 'json',
	         data: JSON.stringify(id),
	         success: function (res) {
	        	 console.log('questions.returned' + res);
	        	
	        	 for (var i = 0; i < res.length; i++) {
	        	s+=res[i].id + 'news Name: ' + res[i].title + '<br>';	 
	 
	        	 }  document.querySelector('#retNewsById').innerHTML = s;
	        	 
	        	 
	        	 
	        	 
	        
	         }
	         
	         	
	        	   }); 
	   
	   var s2 = '';
	   
		/* var news ={
	    		
    			
				title : 'title news 900',
				shortStory : 'story',
				
			}	  
	    */
	   
	   
	   
	   $.ajax({
		     url: 'listDateFilter?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
	         method: 'POST',
	         contentType: 'application/json; charset=UTF-8',
	         dataType: 'json',
	    /*      data: JSON.stringify(news), */
	         data: JSON.stringify(id),
	         success: function (res) {
	        	 console.log('questions.returned' + res);
	        	
	        	 for (var i = 0; i < res.length; i++) {
	        	s2+=res[i].id + 'news Name: ' + res[i].title + '<br>';	 
	 
	        	 }  document.querySelector('#retNewsByDate').innerHTML = s2;
 
	         }
	         
	         	
	        	   });
	   
	   
	   
	   
	   
	   }









</script>




























