<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
	<br>
		<h2>Add a Grade</h2>
		<br>
		<form action="/confirmation" method="post" >
			<table class="table">
				<tr>
					<th scope="row">Name</th>
					<td><input type="text" name="name" autofocus /></td>
				</tr>
				<tr>
					<th scope="row">Type</th>
					<td><select type="text" name="type" />
					    <option value="Assignment">Assignment</option>
                        <option value="Quiz">Quiz</option>
                        <option value="Exam">Exam</option>
					    </select>
					</td>
				</tr>
				<tr>
					<th scope="row">Score</th>
			
					<td><input type="number" name="score" /></td>
				</tr>
				<tr>	
					<th scope="row">Total</th>
					<td><input type="number" name="total" /></td>
			
				</tr>
			</table>
			<button type="submit" href = "/confirmation" class="btn btn-primary">Add</button>
			<a class="btn link" href="/">Cancel</a>
		</form>
	</div>


	</form>
</body>
</html>