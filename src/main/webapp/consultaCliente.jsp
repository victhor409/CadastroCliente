<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="com.model.Cliente"%>

<%
List<Cliente> list = (ArrayList<Cliente>)

request.getAttribute("clientes");
%>




<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">

<!-- Adicione os links para os arquivos JavaScript do Bootstrap (JQuery é necessário) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>
<title>Consulta de Clientes</title>
</head>
<body>

	<div class="container mt-3">
		<h2>Consulta de Clientes</h2>
		<form action="read">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>Nome</th>
						<th>Endereco</th>
						<th>Valor Contrato</th>
						<th>Ativo</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Cliente clientes : list) {
					%>
					<tr>
						<td><%=clientes.getId()%></td>
						<td><%=clientes.getNome()%></td>
						<td><%=clientes.getEndereco()%></td>
						<td><%=clientes.getValorContrato()%></td>
						<td><%=clientes.isAtivo()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</form>

	</div>

</body>
</html>