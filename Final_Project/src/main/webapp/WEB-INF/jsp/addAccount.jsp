<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<body>
	<div class="container">

	<section>
		<header>
			<h2>Add Account</h2>
		</header>
	
		<form:form class="form" id="accountForm" modelAttribute="acc" method="post" action="/Final_Project/addCustomerAccount" >
			<div>
				<form:label path="AcctNo"> Account Number: </form:label></td>
				<form:input path="AcctNo" name="AcctNo" id="AcctNo" />
			</div>
			<div>
				<form:label path="AcctType"> Account Type: </form:label></td>
				<form:input path="AcctType" name="AcctType" id="AcctType" />
			</div>
			<div>
				<form:label path="CustomerId"> Customer Id: </form:label></td>
				<form:input path="CustomerId" name="CustomerId" id="CustomerId" />
			</div>
			
			<div>
				<form:button id="addAccount" name="addAccount">Add Account</form:button>
			</div>
		</form:form>
		<br>
		<center>${message}</center>
		
	</section>
	
	
	</div>
</body>
</html>