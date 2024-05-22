<!DOCTYPE html>
<html>
<head>
<title>Update Book Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 50%;
	margin: 50px auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #333;
}

label {
	font-weight: bold;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	border-radius: 3px;
	border: 1px solid #ccc;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Update Book Details</h2>
		<form action="updateform" method="post">
			<label for="patientId">Enter Patient ID:</label> <input type="text"
				id="patient_id" name="patient_id" placeholder="Patient ID" required>
			<input type="submit" value="Update Details">
		</form>
	</div>
</body>
</html>
