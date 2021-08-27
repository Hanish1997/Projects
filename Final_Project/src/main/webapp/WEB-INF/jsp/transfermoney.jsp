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
	
		<form:form class="form" id="transferForm" modelAttribute="transfermoney" action="transferProcess" method="post">
			<div>
				<form:label path="accWithdraw"> Account Number to withdraw from: </form:label></td>
				<form:input path="accWithdraw" name="accWithdraw" id="accWithdraw" />
			</div>
			<div>
				<form:label path="accDeposit"> Account Number to deposit in:</form:label>
				<form:input path="accDeposit" name="accDeposit" id="accDeposit" />
			</div>
			<div>
				<form:label path="amount"> Enter Amount:</form:label>
				<form:input path="amount" name="amount" id="amount" />
			</div>
			<div>
				<form:button id="transfermoney" name="transfermoney">Transfer</form:button>
			</div>
		</form:form>
		<br>
		<center>${message}</center>
	</section>
	
	
	</div>
</body>
</html>