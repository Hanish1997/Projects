<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<body>
	<div class="container">

	<section>
		<header>
			<h2>Draw Money</h2>
		</header>
	
		<form:form class="form" id="depositForm" action="withdrawProcess" method="post">
			<div>
				<form:label path="BillerName"> Name of Account Holder : </form:label></td>
				<form:input path="BillerName" name="AcBillerNamectNo" id="BillerName" />
			</div>
			<div>
				<form:label path="BillerAcctNo"> Account Number to Withdraw from : </form:label></td>
				<form:input path="BillerAcctNo" name="BillerAcctNo" id="BillerAcctNo" />
			</div>
			<div>
				<form:label path="CustomerId"> Customer Id: </form:label></td>
				<form:input path="CustomerId" name="CustomerId" id="CustomerId" />
			</div>
			<div>
				<form:label path="Amt"> Enter Amount:</form:label>
				<form:input path="Amt" name="Amt" id="Amt" />
			</div>
			<div>
				<form:button id="withdrawProcess" name="withdrawProcess">Transfer</form:button>
			</div>
		</form:form>
		<br>
		<center>${message}</center>
	</section>
	
	
	</div>
</body>
</html>