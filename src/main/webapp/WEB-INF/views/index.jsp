<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="style.css" rel = "stylesheet">
</head>
<body>

<div class="container">
<br>
<h2> Welcome to Earth</h2>
<br>
<table style=width:60%>
    <tr>
        <th>Name</th>  <!--  padding needed-->
        <th>Type</th>
        <th>Score</th>
        <th>Total</th>
        <th>     </th>
    </tr>
     <c:forEach items="${grades}" var="grade">
    <tr>
        <td>
            <c:out value="${grade.name}" />
        </td>
        <td>
            <c:out value="${grade.type}" />
        </td>
        <td>
            <c:out value="${grade.score}" />
        </td>
         <td>
            <c:out value="${grade.total}" />
        </td>
        <td> 
        <c:out value ="${grade.percentage}%"/>
        </td> 
         <td>
      
            <a href ="/delete?id=${grade.id}">Delete</a>
         </td>
    </tr>
    </c:forEach>  
</table>
<br>
<p> Overall Grade: ${percent}% </p>  <!--  casted to a integer so there is no decimal place -->
<a href="/form">Add a Grade</a>
</div>
</body>




</html>