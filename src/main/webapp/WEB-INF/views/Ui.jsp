<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Medical Slot Booking</title>
<style>

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

img {
	height: 100%;
	width: 100%;
}

body {
	font-family: Arial, sans-serif;
}

/* Styling for navbar */
.navbar {
	background-color: #3498db;
	overflow: hidden;
}

.navbar a {
	float: left;
	display: block;
	color: #fff;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
	font-size: 18px;
	transition: background-color 0.3s;
}

.navbar a:hover:not(.home) {
	background-color: #2980b9;
}

.content {
	text-align: center;
	padding: 20px;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 18px;
	border: none;
	outline: none;
	color: #fff;
	background-color: inherit;
	margin: 0;
	padding: 14px 20px;
	cursor: pointer;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown-content a {
	color: black;
	text-align: center;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	border-bottom: 1px solid #ddd; 
}

.dropdown-content a:last-child {
	border-bottom: none; 
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}
</style>
</head>

<body>

	<div class="navbar">
		<a href="#">Home</a> <a href="home">Book Appointment</a>
		<div class="dropdown">
			<button class="dropbtn">Services</button>
			<div class="dropdown-content">
				<a href="home">Create</a> <a href="getDetails">Read</a> <a
					href="updateId">Update</a> <a href="delete">Delete</a>
			</div>
		</div>
		<a href="about">About Us</a> <a href="contact">Contact Us</a>
		<a href="getpdf">Download Booking</a> <!-- Added download button -->
	</div>

	<div class="content">
		<h1>Welcome to Medical Slot Booking</h1>
		<img alt=""
			src="https://gov-web-sing.s3.ap-southeast-1.amazonaws.com/uploads/2023/1/Wordpress-featured-images-48-1672795987342.jpg">
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
			aliquet ligula at erat dapibus hendrerit.</p>
	</div>

</body>

</html>
