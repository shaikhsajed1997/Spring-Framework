<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<pre>
<form action="update" style="text-align: center; background: #D6EAF8">
<table>
<h2>Aadhar Number:			<input type="text" name="aadhar_Number" value="${data.aadhar_Number }" readonly style="width: 270px;height: 25px">

Account Number: 		<input type="text" name="account_Number" value="${data.account_Number }" readonly style="width: 270px;height: 25px">

Account Type:			<input type="text" name="account_Type" value="${data.account_Type }"style="width: 270px;height: 25px">

Account Holder Name:	        <input type="text" name="acc_Holder_Name" value="${data.acc_Holder_Name }"style="width: 270px;height: 25px">

Mobile Number:  		<input type="text" name="mobile_Number" value="${data.mobile_Number }"style="width: 270px;height: 25px">

Email Id:  		   	<input type="text" name="email_Id" value="${data.email_Id }"style="width: 270px;height: 25px">

Address: 			<input type="text" name="address" value="${data.address }"style="width: 270px;height: 25px">

Account Balance:                <input type="text" name="account_Balance"  value="${data.account_Balance }" readonly style="width: 270px;height: 25px">

User Name:  			<input type="text" name="user_Name" value="${data.user_Name }" style="width: 270px;height: 25px">

Password:			<input type="text" name="password" value="${data.password }" style="width: 270px;height: 25px"></h2>

</form>
</table>
<h2><input type="submit" value="Update" style="width: 100px;height: 25px;background: #48C9B0;font-size: large;font-weight: bold;border-radius: 4px;"></h2>
</pre>
</body>
</html>