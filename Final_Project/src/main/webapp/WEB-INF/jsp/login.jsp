<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<body>
	<div class="container">

	<section>
		<header>
			<h2>Login</h2>
		</header>
	
		<form:form class="form" id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<div>
				<form:label path="LoginId"> Login Id: </form:label></td>
				<form:input path="LoginId" name="LoginId" id="LoginId" />
			</div>
			<div>
				<form:label path="password"> Password:</form:label>
				<form:password path="password" name="password" id="password" />
			</div>
			<div>
				<form:button id="login" name="login">Login</form:button>
			</div>
		</form:form>
		<br>
		<center>${message}</center>
	</section>
	
	<a href="/Final_Project/register">Not yet registered? register HERE</a>
	</div>
</body>
</html>