<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('select').material_select('destroy');	
		});
	</script>
	<title>Cadastro de Vendas</title>
</head>
<body>
	<jsp:include page="../cadastroVenda"></jsp:include>
	<div class="container">
		<div class="row">
		<form class="col s12" action="../cadastroVenda" method="post">
			<h1>Cadastro de Vendas</h1>
			<div class="row">
				<div class="input-field col s6">					
					<select name="funcionario">
						<option value="" disabled selected>Selecione o funcionário</option>
						<c:forEach var="f" items="${lista}">
							<option value="${f.id}"><c:out value="${f.nome}"></c:out></option>
						</c:forEach>
					</select>					
				</div>
			</div>	
			<div class="row">
				<div class="input-field col s6">
          			<input id="venda" name="venda" type="number" step="0.01">
          			<label for="nome">Valor da Venda</label>
        		</div>			
			</div>
														
			<div class="row">
				<button class="btn waves-effect waves-teal" type="submit">Cadastrar Venda<i class="material-icons right">send</i></button>
			</div>			
			<a class="btn waves-effect waves-teal" href="../index.jsp">
			<i class="material-icons left">cloud</i>Voltar</a>	
		</form>
	</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
	    	$('select').material_select();
	    	$('.modal').modal();
		});
	</script>
</body>
</html>