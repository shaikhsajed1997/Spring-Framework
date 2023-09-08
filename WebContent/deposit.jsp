<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
<form action="updatebalance" style="text-align: center;background: #FDEDEC">

<h2>Aadhar Number:   <input type="text" name="aadhar_Number" value="${data.aadhar_Number }" readonly style="font-size: large;"></h2>

<h2>Enter Amount:    <input type="text" name="account_Balance" style="font-size: large;"></h2>



<h2><input type="submit" value="AddMoney" style="width: 100px;height: 25px;background: #D5F5E3"></h2>
</form>


</pre>
</body>
</html>