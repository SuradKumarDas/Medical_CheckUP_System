<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Medical Form</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f8f8f8;
}

.container {
	width: 80%;
	margin: 50px auto;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

form {
	width: 100%;
	padding: 20px;
}

input[type="text"], input[type="number"], input[type="date"], input[type="radio"]
	{
	width: calc(100% - 24px);
	padding: 10px;
	margin-bottom: 15px;
	border-radius: 5px;
	border: 1px solid #ddd;
	font-size: 16px;
	transition: border-color 0.3s ease;
}

input[type="radio"] {
	margin-right: 10px;
}

label {
	font-weight: bold;
	color: #333;
}

.center-btn {
	text-align: center;
	margin-top: 20px;
}

button[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	padding: 12px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
	background-color: #45a049;
}

h2 {
	text-align: center;
	color: #333;
	margin-bottom: 30px;
}

.alert {
	margin-bottom: 20px;
	padding: 10px;
	border-radius: 5px;
	width: 100%;
	text-align: center;
}

.alert-success {
	background-color: #d4edda;
	color: #155724;
	border: 1px solid #c3e6cb;
}

.alert-danger {
	background-color: #f8d7da;
	color: #721c24;
	border: 1px solid #f5c6cb;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Medical Form</h2>
		<form name="form" action="updatedetails" method="post">
			<label for="patient_name">Patient Name:</label> <input type="text"
				id="patient_name" name="patient_name"
				placeholder="Enter patient name" required><br> <label
				for="age">Age:</label> <input type="number" id="age" name="age"
				placeholder="Enter your age" required><br> <label>Gender:</label>
			<input type="radio" id="male" name="gender" value="male" required>
			<label for="male">Male</label> <input type="radio" id="female"
				name="gender" value="female" required> <label for="female">Female</label><br>

			<label for="disease">Disease:</label> <input type="text" id="disease"
				name="disease" placeholder="Enter disease name" required><br>

			<label for="date">CheckUp Date:</label> <input type="date" id="date"
				name="date" required><br>

			<div class="center-btn">
				<button type="submit" value="submit">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>
