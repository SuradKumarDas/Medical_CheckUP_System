<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Patients</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #E8E8E8;
}
</style>
</head>
<body>
	<h1>All Patients</h1>
	<a href="ui">click here</a>
	<h1>For the Operation Page</h1>
	<form>
		<table>
			<thead>
				<tr>
					<th>Patient ID</th>
					<th>Patient Name</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Disease</th>
					<th>CheckUp Date</th>

				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty patients}">
						<c:forEach items="${patients}" var="patient">
							<tr>
								<td><c:out value="${patient.patient_id}" /></td>
								<td><c:out value="${patient.patient_name}" /></td>
								<td><c:out value="${patient.age}" /></td>
								<td><c:out value="${patient.gender}" /></td>
								<td><c:out value="${patient.disease}" /></td>
								<td><c:out value="${patient.date}" /></td>

							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="7">No patients found</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</form>
</body>
</html>
