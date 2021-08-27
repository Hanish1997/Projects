<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add Customer Detail</h1>
       <form:form class="form" id="customerForm"  modelAttribute="command" action="save" method="post" >  
      	<table > 
      	<tr>  
         
         	<td>LoginId :</td>
			<td><form:input path="LoginId" /></td>
		</tr>
      	<tr>  
         
         	<td>CustomerId :</td>
			<td><form:input path="CustomerId" /></td>
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
          <td> </td>  
          <div>
				<form:button id="customer" name="customre">Add Customer</form:button>
			</div>
         </tr>  
        </table>  
       </form:form>