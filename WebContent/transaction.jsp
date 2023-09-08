<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.tech.model.Account"%>
<%@page import="com.tech.model.AccountTransaction"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function back() {

		document.myhome.action = "index.jsp";
		document.myhome.submit();

	}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="myhome" style="text-align: center;">
		<table border="2" style="margin: auto; width: 60%;margin-top: 5%">

			<tr style="background: #F5B7B1; height: 30px;">
				<td>Transaction Id</td>
				<td>Transaction Date</td>
				<td>Transaction Amount</td>
				<td>Transaction Status</td>
				<td>Account Balance</td>

			</tr>
			<c:forEach items="${data}" var="tr">
				<tr style="height: 25px;background: powderblue;">
					<td><c:out value="${tr.t_Id}"></c:out></td>
					<td><c:out value="${tr.date}"></c:out></td>
					<td><c:out value="${tr.amount}"></c:out></td>
					<td><c:out value="${tr.debit_credit}"></c:out></td>
					<td><c:out value="${tr.total_Balance}"></c:out></td>

				</tr>

			</c:forEach>

			<tr style="height: 30px;">
				<td><input type="button" value="Back" onclick="back()"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>