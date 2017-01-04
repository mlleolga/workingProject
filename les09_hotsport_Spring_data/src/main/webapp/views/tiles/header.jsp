<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link rel="stylesheet" href="css/top.css">






<!-- <h1 style="text-align: center; background-color: grey">header</h1> -->

<div class="h_Top">

	<div class="hucLeft">
		<ul class="mLeft">
			<li><a href="http://hotsport.tv/"><img
					src="" alt=""></a></li>
		</ul>
	</div>

	<div class="hucCenter">
		<ul class="hucCenterContacts">
			<li><a href=""><i class="fa fa-google-plus-square  fa-2x "
					aria-hidden="true"></i></a></li>
		
		</ul>
	</div>
	<div class="hucRight">
		<ul class="mRight">
		
			<li><sec:authorize access="!isAuthenticated()">
					<div id="hid1" style="display: none">
						<form:form action="loginprocesing" method="post">
							<input name="username" type="text" placeholder="login" />
							<input name="password" type="password" placeholder="password" />
							<button>login</button>   
							
							<!-- <div id="hid4" onclick='showlogin()'></div>  -->
						</form:form>
						
					</div>

				</sec:authorize></li>

			
				
			<li><sec:authorize access="!isAuthenticated()">
			<div id="hid3">
					<a href="newUser">SignUp<i class="fa fa-angle-down"
						aria-hidden="true"></i></a>
						</div>
				</sec:authorize></li>
				
				<li><sec:authorize access="!isAuthenticated()">
					<div id="hid2" onclick='showlogin()'>LogIn</div> 
					
				</sec:authorize></li>

			<li><sec:authorize access="isAuthenticated()">
					<a href="profile">profile<i class="fa fa-angle-down"
						aria-hidden="true"></i></a>
				</sec:authorize></li>

			<li><sec:authorize access="isAuthenticated()">

					<form:form action="logout" method="post">
						<button>logout</button>
					</form:form>
				</sec:authorize></li>

		</ul>

	</div>
</div>
<script>
	var i = 1;
	function showlogin() {
		i += 1;
		if (i % 2 == 0) {
			document.getElementById('hid1').style.display = 'block'
				document.getElementById('hid2').style.display = 'none'
					document.getElementById('hid3').style.display = 'none'
		} else {
			document.getElementById('hid1').style.display = 'none'
				document.getElementById('hid2').style.display = 'block'
					document.getElementById('hid3').style.display = 'block'
		}

	}
</script>




























