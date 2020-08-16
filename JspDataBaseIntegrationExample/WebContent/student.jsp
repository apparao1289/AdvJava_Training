<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/JspDataBaseIntegrationExample/registration.jsp" method="post">
	Student Registration Form: <br>
	<table>
		<tr>
		    <td>First Name</td>
		    <td>:</td>
		    <td> <input type="text" name="fname" id="fname"></td>
		</tr>
		
		<tr>
		    <td>Last Name</td>
		    <td>:</td>
		    <td> <input type="text" name="lname" id="lname"></td>
		</tr>
	
		<tr>
		    <td>Age</td>
		    <td>:</td>
		    <td> <input type="text" name="age" id="age"></td>
		</tr>
		
		<tr>
		    <td>Address</td>
		    <td>:</td>
		    <td> <input type="text" name="address" id="address"></td>
		</tr>
		
		<tr>
		    <td>Class:</td>
		    <td>:</td>
		    <td> <input type="text" name="stand" id="stand"></td>
		</tr>
		
	</table>
	<input type="submit" value="Regsistration">
</form>
	
</body>
</html>