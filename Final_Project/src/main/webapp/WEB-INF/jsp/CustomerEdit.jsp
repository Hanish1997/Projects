<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Customer Information</h1>

<form:form method="POST" action="/Final_Project/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="CustomerId" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="Name" /></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><form:input path="Address" /></td>
		</tr>
		<tr>
			<td>State :</td>
			<td><form:input path="State" /></td>
		</tr>

		<tr>
			<td>postalCode :</td>
			<td><form:input path="postalCode" /></td>
		</tr>

		<tr>
			<td>Country :</td>
			<td><form:input path="Country" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
