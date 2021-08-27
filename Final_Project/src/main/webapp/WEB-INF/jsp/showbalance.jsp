<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Account Balance</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Account Number</th>
		<th>Account Type</th>
		<th>Current Balance</th>
		<th>Deposit</th>
		<th>Withdraw</th>
	</tr>
	<c:forEach items="${list}" var="cust">
		<tr>
			<td>${cust[0]}</td>
			<td>${cust[1]}</td>
			<td>${cust[2]}</td>
			<td><a href="/Final_Project/deposit">Deposit Money</a></td>
			<td><a href="/Final_Project/withdraw">Withdraw Money</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="/Final_Project/payBillForm">Pay my Bills</a>
<a href="/Final_Project/payFees">Pay my Fees</a>
<a href="/Final_Project/transfer">Transfer money between your accounts.</a>

