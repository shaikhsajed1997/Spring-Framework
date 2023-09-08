<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.tech.model.Account"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function deleteAccount() {
		document.acc.action = "delete";
		document.acc.submit();

	}
	function editMoney() {
		document.acc.action = "balance";
		document.acc.submit();
	}
	function withdraw() {
		document.acc.action = "withdraw";
		document.acc.submit();

	}
	function updateAccount() {

		document.acc.action = "editaccount";
		document.acc.submit();

	}
	function addAccount() {
		document.acc.action = "createacc.jsp";
		document.acc.submit();
	}
	function login() {
		document.acc.action = "index.jsp";
		document.acc.submit();
	}
	function transaction() {
		document.acc.action = "transactionhistory";
		document.acc.submit();
		
	}
</script>
<meta charset="ISO-8859-1">
<title>display page</title>
</head>
<body style="background: #FEF5E7">
	<form name="acc">
		<table border="2" style="margin: auto; margin-top: 5%; width: 82%;">
			<tr
				style="height: 35px; font-weight: bold; font-size: medium; text-align: center;background: #AED6F1;border-style: solid;">
				<td></td>
				<td>Aadhar Number</td>
				<td>Account Number</td>
				<td>Account Type</td>
				<td>Account Holder Name</td>
				<td>Mobile Number</td>
				<td>Email Id</td>
				<td>Address</td>
				<td>Account Balance</td>
				<td>UserName</td>
				<td>Password</td>

			</tr>

			<c:forEach items="${data}" var="ac">
				<tr style="height: 35px; text-align: center;background: #D5F5E3">
					<td><input type="radio" name="rd" value="${ac.aadhar_Number }"></td>
					<td><c:out value="${ac.aadhar_Number }"></c:out></td>
					<td><c:out value="${ac.account_Number }"></c:out></td>
					<td style="width: 150px"><c:out value="${ac.account_Type }"></c:out></td>
					<td><c:out value="${ac.acc_Holder_Name }"></c:out></td>
					<td><c:out value="${ac.mobile_Number }"></c:out></td>
					<td><c:out value="${ac.email_Id }"></c:out></td>
					<td><c:out value="${ac.address }"></c:out></td>
					<td><c:out value="${ac.account_Balance }"></c:out></td>
					<td><c:out value="${ac.user_Name }"></c:out></td>
					<td><c:out value="${ac.password }"></c:out></td>
				</tr>
			</c:forEach>

			<tr style="height: 35px; text-align: center;background: #EAEDED">
				<td><input type="button" value="Delete" onclick="deleteAccount()" style="background-color: #DC7633;font-weight: bold;"></td>
				<td><input type="button" value="AddMoney" onclick="editMoney()" style="background-color: #5DADE2;font-weight: bold;"></td>
				<td><input type="button" value="Withdraw" onclick="withdraw()" style="background-color: #EDBB99;font-weight:bold;"></td>
				<td><input type="button" value="Update" onclick="updateAccount()" style="background-color: #5499C7;font-weight: bold;color: white;"></td>
				<td><input type="button" value="CreateAccount" onclick="addAccount()" style="background: #82E0AA;font-weight: bold;"></td>
				<td><input type="button" value="Home" onclick="login()" style="background: #80669d; font-weight: bold;color: white;"></td>
				<td><input type="button" value="Transaction" onclick="transaction()"></td>
			</tr>

		</table>
	</form>
</body>
</html>