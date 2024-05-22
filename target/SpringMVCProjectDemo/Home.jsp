<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .container {
        width: 50%;
        margin: auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    form {
        width: 100%;
    }
    button{
    text-align: center;}

    input[type="text"],
    input[type="number"],
    input[type="date"],
    input[type=""] {
        width: calc(100% - 10px);
        padding: 10px;
        margin-bottom: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }

    .center-btn button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-align: center;
    }

    .center-btn button[type="submit"]:hover {
        background-color: #45a049;
    }
</style>

<script type="text/javascript">
	/* document.form.action="home";
	document.form.submit(); */
</script>
</head>
<body>
    <div class="container">
        <h2>Medical Form</h2>
        <form name="form" action="home" method="post">
            Patient Id:
            <input type="number" name="patient_id" placeholder="Enter patient id" ><br><br>
            Patient Name:
            <input type="text" name="patient_name" placeholder="Enter patient name"><br><br>
            Age:
            <input type="number" name="age" placeholder="Enter your age"><br><br>
            Gender:
            <input type="radio" name="gender" value="male">Male
            <input type="radio" name="gender" value="female">Female<br><br>
            Disease:
            <input type="text" name="disease" placeholder="Enter disease name"><br><br>
            CheckUp Date:
            <input type="date" name="date"><br><br>
            <div class="center-btn">
                <input type="submit" value="submit">
                
            </div>
        </form>
    </div>
</body>
</html>
