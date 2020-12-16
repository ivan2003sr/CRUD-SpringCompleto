<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/> 

</head>
<body>

<h1>Lista de clientes</h1>


<table border="1">

	<tr>
	 		<th>Nombre</th>
			<th>Apellido</th>
			<th>E-mail</th>
	
	
	
	</tr>

<c:forEach var="clienteTemp" items="${clientes }">


<tr>
		<td>${clienteTemp.nombre}</td>
		<td>${clienteTemp.apellido}</td>
		<td>${clienteTemp.email}</td>
		
</tr>


</c:forEach>
</table>

<br/>

<input type="button" value="Agregar Cliente" onClick="window.location.href='muestraFormularioAgregar'; return false"/>


</body>
</html>