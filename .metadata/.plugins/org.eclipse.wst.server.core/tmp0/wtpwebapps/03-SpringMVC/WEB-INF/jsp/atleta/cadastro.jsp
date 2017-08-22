<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de atleta</title>
</head>
<body>
<h1>Cadastro de Atleta</h1>
<form action="cadastrar" method="post">

<div>
	<div>
		<label for="id-nome">Nome: </label>
		<input id="id-nome "type="text" name="nome" placeholder="Digite o Nome">
	</div>
	<div>
		<label for="id-altura">Altura: </label>
		<input id="id-altura" type="text" name="altura" placeholder="Digite a Altura">
	</div>
	<div>
		<label for="id-peso">Peso: </label>
		<input id="id-peso" type="text" name="peso" placeholder="Digite o Peso">
	</div>
	<div>
		<input type="submit" value="cadastrar">
	</div>

</div>
</form>
</body>
</html>