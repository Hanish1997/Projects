<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<body>
	<div class="container">

	<section>
		<header>
			<h2>Register</h2>
		</header>
	
		<form:form class="form" id="registerForm" modelAttribute="command" action="registerProcess" method="post">
			<div>
				<form:label path="LoginId"> Login Id: </form:label></td>
				<form:input path="LoginId" name="LoginId" id="LoginId" />
			</div>
			<div>
				<form:label path="password"> Password:</form:label>
				<form:password path="password" name="password" id="password" />
			</div>
			<div>
				<form:button id="register" name="register">Register</form:button>
			</div>
		</form:form>
		<br>
		<center>${message}</center>
	</section>
	
	
	</div>
</body>
</html>