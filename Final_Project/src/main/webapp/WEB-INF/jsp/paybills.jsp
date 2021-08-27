<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<body>
	<div class="container">

	<section>
		<header>
			<h2>Pay Bill</h2>
		</header>
		<form:form class="form" id="payBill"  action="payBill" method="post">
			<div>
				<form:label path="BillerName">Biller Name: </form:label>
				<form:input path="BillerName" name="BillerName" id="BillerName" />
			</div>
			<div>
				<form:label path="BillerAcctNo"> Biller Account No: </form:label>
				<form:input path="BillerAcctNo" name="BillerAcctNo" id="BillerAcctNo" />
			</div>
			<div>
				<form:label path="Amt"> Amt: </form:label>
				<form:input path="Amt" name="Amt" id="Amt" />
			</div>
			<div>
				<form:label path="CustomerId"> Customer Id: </form:label>
				<form:input path="CustomerId" name="CustomerId" id="CustomerId" />
			</div>

			<div>
				<form:button id="payBill" name="payBill">Pay Bill</form:button>
			</div>
		</form:form>
		<br>
		<center>${message}</center>
	</section>
	
	
	</div>
</body>
</html>