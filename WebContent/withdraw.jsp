<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw page</title>
</head>
<body>
<pre>
<form action="withdrawbalance" style="text-align: center; background: #FDEBD0 ">

<h2>Aadhar Number:            <input type="text" name="aadhar_Number" value="${data.aadhar_Number }" readonly style="font-size: large;"></h2>

<h2>Enter Withdraw Amount:    <input type="text" name="account_Balance" style="font-size: large;" ></h2>



<h2><input type="submit" value="Withdraw" style="width: 120px; height: 25px;font-weight: bold;background-color: #AED6F1 "></h2>
</form>


</pre>

</body>
</html>