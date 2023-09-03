<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="com.tech.model.Account" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function addData() {
	alert("Do you want to add data ?");
	document.myform.action="registration.jsp";
	document.myform.submit();
}
function deleteData() {
	alert("Do you want to delete data permenantly?");
	document.myform.action="delete";
	document.myform.submit();
	
}
function updateData() {
	alert("Do you want to update this data?")
	document.myform.action="edit";
	document.myform.submit();
	
}

</script>
<meta charset="ISO-8859-1">
<title>result data</title>
</head>
<body style="background: #ffeee6">
<form name="myform">
<h2 style="margin-left:45%;">Account Details</h2>
<table  border="2" style="margin: auto; margin-top: 50px; width: 70%; background: pink">
<thead style="background-color:lime; width: 70%; text-align: center; height: 40px">
	<tr style="font-size: larger;">
	<th></th>
	<th>aadhar_Number</th>
	<th>account_Number</th>
	<th>acc_Holder_Name</th>
	<th>mobile_Number</th>
	<th>address</th>
	<th>user_Name</th>
	<th>password</th>
	</tr>

</thead>
		<c:forEach items="${data}" var="ac">
	<tr style="background: powderblue; height: 35px; text-align: center; font-size: larger; color: #0000b3;">	
			<td><input type="radio" name="rd" value="${ac.aadhar_Number}"; style="resize: both;"> </td>
			<td><c:out value="${ac.aadhar_Number}"></c:out></td>
			<td><c:out value="${ac.account_Number}"></c:out></td>
			<td><c:out value="${ac.acc_Holder_Name}"></c:out></td>
			<td><c:out value="${ac.mobile_Number}"></c:out></td>
			<td><c:out value="${ac.address}"></c:out></td>
			<td><c:out value="${ac.user_Name}"></c:out></td>
			<td><c:out value="${ac.password}"></c:out></td>	
			
	</tr>
	</c:forEach>
	<tr style="height: 35px; text-align: center; background: SkyBlue">
			<td><input type="button" value="Delete" style="background-color: Chocolate; color:white; font-weight: bold;width: 90px; height: 25px;" onclick="deleteData()"></td>
			<td><input type="button" value="Update" style="background-color: black; color: white; font-weight: bold;width: 90px;height: 25px "onclick="updateData()"></td>
			<td><input type="button" value="Add" style="background-color: DodgerBlue; color: white; font-weight: bold;width: 90px; height: 25px
			" onclick="addData()"></td>
	</tr>
</table>
</form>
</body>
</html>