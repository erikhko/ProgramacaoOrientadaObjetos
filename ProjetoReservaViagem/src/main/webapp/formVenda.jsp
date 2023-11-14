<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Venda de Passagens</h1>
	<form action="" method="post">
		<label>Região de Deswtino</label>
		<select name="destino">
			<option value="sul">Sul</option>
			<option value="sudeste">Sudeste</option>
			<option value="centro_oeste">Centro Oeste</option>
			<option value="nordeste">Nordeste</option>
			<option value="norte">Norte</option>
		</select>
		<br>
		<label>Tipo de Viagem</label>
		<input type="radio" name="tipoViagem" value="Ida e volta">
		<input type="radio" name="tipoViagem" value="Ida">
		<br>
		<label>Incluir seguro?</label>
		<input type="radio" name="seguro" value="Sim">
		<input type="radio" name="seguro" value="Não">
		<br>
		<button type="submit">Comprar</button>
	</form>
</body>
</html>