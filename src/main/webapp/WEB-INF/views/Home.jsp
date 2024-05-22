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
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.container {
	width: 50%;
	margin: auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

form {
	width: 100%;
}

input[type="text"], input[type="number"], input[type="date"], input[type="radio"]
	{
	width: calc(100% - 20px);
	padding: 12px;
	margin-bottom: 20px;
	border-radius: 5px;
	border: 1px solid #ccc;
	font-size: 16px;
}

input[type="radio"] {
	margin-right: 10px;
}

.center-btn {
	text-align: center;
}

button[type="submit"] {
	background-color: #007bff;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
	background-color: #0056b3;
}

h2 {
	text-align: center;
	color: #007bff;
	margin-bottom: 30px;
}

.alert {
	margin-bottom: 20px;
	padding: 10px;
	border-radius: 5px;
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

/* Additional Styling */
input[type="text"], input[type="number"], input[type="date"], input[type="radio"],
	button[type="submit"] {
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

input[type="text"]:focus, input[type="number"]:focus, input[type="date"]:focus,
	input[type="radio"]:focus, button[type="submit"]:hover {
	border-color: #007bff;
	box-shadow: 0px 0px 5px rgba(0, 123, 255, 0.5);
}

input[type="radio"] {
	margin-right: 15px;
}

label {
	display: block;
	margin-bottom: 8px;
	font-weight: bold;
}
</style>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${patient_id ne null and patient_id ne 0}">
				<c:if test="${successmsg ne null and not empty successmsg}">
					<div class="alert alert-success" role="alert">
						<c:out value='${successmsg}' />
					</div>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${failuremsg ne null and not empty failuremsg}">
					<div class="alert alert-danger" role="alert">
						<c:out value='${failuremsg}' />
					</div>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="container">
		<h2>Medical Form</h2>
		<form name="form" action="home" method="post">
			<label for="patient_id">Patient Id:</label> <input type="number"
				id="patient_id" name="patient_id" placeholder="Enter patient id"
				required><br> <br> <label for="patient_name">Patient
				Name:</label> <input type="text" id="patient_name" name="patient_name"
				placeholder="Enter patient name" required><br> <br>
			<label for="age">Age:</label> <input type="number" id="age"
				name="age" placeholder="Enter your age" required><br> <br>
			<label>Gender:</label> <input type="radio" id="male" name="gender"
				value="male" required> <label for="male">Male</label> <input
				type="radio" id="female" name="gender" value="female" required>
			<label for="female">Female</label><br> <br> <label
				for="disease">Disease:</label> <input type="text" id="disease"
				name="disease" placeholder="Enter disease name" required><br>
			<br> <label for="date">CheckUp Date:</label> <input type="date"
				id="date" name="date" required><br> <br>

			<div class="center-btn">
				<button type="submit" value="submit">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>
