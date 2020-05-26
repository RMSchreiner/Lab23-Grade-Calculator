<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="style.css" rel = "stylesheet">
<meta charset="ISO-8859-1">
<title>Delete Grade</title>
</head>
<body>
	<div class="container">
		<h2>Delete ${testName}?</h2>

		<p>Are you sure that you want to delete this grade?</p>

		<p>${testName}</p>

		<a href="/">No, go back.</a> <a
			href="/deleteapproval?deleteID=${deleteID}">Yes, I would like to
			delete.</a>
		<p>${deleteID}</p>
	</div>
</body>
</html>