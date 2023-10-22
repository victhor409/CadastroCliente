<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import = "java.math.BigDecimal" %>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">

<!-- Adicione os links para os arquivos JavaScript do Bootstrap (JQuery é necessário) -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>

<title>Cadastro de Clientes</title>
</head>

<%



String nome = request.getParameter("nome");
String endereco = request.getParameter("endereco");
String valorContratoString = request.getParameter("valorContrato");
String ativoString = request.getParameter("ativo");



%>

<body>

	<div class="container-fluid">
		<h1>Cadastro de Clientes</h1>

		<form action="create">
		
		
			<div class="mb-3 mt-3">
			

		
			<div class="mb-3 mt-3">
				<label for="email">Nome:</label> <input type="text"
					class="form-control" id="nome" placeholder="nome" name="nome">
			</div>
			<div class="mb-3">
				<label for="pwd">Endereco:</label> <input type="text"
					class="form-control" id="endereco" placeholder="endereco"
					name="endereco">
			</div>

			<div class="mb-3">
				<label for="pwd">Valor Contrato:</label> <input type="number"
					class="form-control" id="valorContrato"
					placeholder="valor contrato" name="valorContrato">
			</div>

			<div class="form-check mb-3">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="ativo">
					Ativo
				</label>
			</div>

			<button type="submit" class="btn btn-primary">Salvar</button>
		</form>

	</div>


</body>
</html>