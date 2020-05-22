<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<div class="container">

<h2> Grade Added</h2>
<p> The grade was added to the database.</p>
<h3> Details </h3>
<p> Name: ${grade.name} </p>
<p> Type: ${grade.type}</p>
<p> Score: ${grade.score}</p>
<p> Total: ${grade.total}</p>

<a href="/">Return to the grade list</a>

</div>

</body>
</html>