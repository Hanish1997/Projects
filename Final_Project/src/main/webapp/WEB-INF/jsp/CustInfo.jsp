    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Customer Account Information</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>CustomerId</th><th>Name</th><th>Address</th><th>State</th><th>postalCode</th><th>Country</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="cust" items="${list}"> 
    <tr>
    <td>${cust.getCustomerId()}</td>
    <td>${cust.getName()}</td>
    <td>${cust.getAddress()}</td>
    <td>${cust.getState()}</td>
     <td>${cust.getPostalCode()}</td>
    <td>${cust.getCountry()}</td>
    <td><a href="/Final_Project/editcust/${cust.getCustomerId()}">Edit</a></td>
      <td><a href="/Final_Project/deletecust/${cust.getCustomerId()}">Delete</a></td>
 
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="custform">Add New Customer</a>
    <a href="addAccount">Add New Account</a>