<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update page</title>
</head>
<body style="align-content: center; text-align: center; margin-top: 5%; background: powderblue">
<pre>
<form action="update" >

<h2>
	Aadhar Number :      <input type="hidden" name="aadhar_Number" value="${data.aadhar_Number}">
	
	Account Number :     <input type="text" name="account_Number" value="${data.account_Number}">
	
	Account Holder Name: <input type="text" name="acc_Holder_Name" value="${data.acc_Holder_Name}">
	
	Mobile Number :      <input type="text" name="mobile_Number" value="${data.mobile_Number}">
	
	Address:             <input type="text" name="address" value="${data.address}">
	
	User Name:           <input type="text" name="user_Name" value="${data.user_Name}">
	
	PassWord:            <input type="text" name="password"  value="${data.password}"></h2>
	
	<h2><input type="submit" value="Update"></h2>

</form>
</pre>
</body>
</html>