<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gerenciador de Espaços</title>

    <link href="/Pre-Prova/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/Pre-Prova/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/Pre-Prova/css/app.css" rel="stylesheet">

    

</head>

<body>
<c:import url="topo.jsp"></c:import>
<div class="container">
<div class="page-header">
<h1> Lista Reservas </h1>
</div>

<table class="table" >
<tr>
<th> Titulo </th>
<th> Descrição </th>
<th> Justificativa</th>
<th> Solicitante </th>
<th> Telefone </th>
<th> Data </th>
<th> Hr inicio </th>
<th> Hr fim </th>
<th> Espaço </th>
 
</tr>

<c:forEach var="e" items="${lista}">
<tr>
 <td> ${e.titulo} </td>
 <td> ${e.descricao} </td>
 <td> ${e.justificativa} </td>
 <td> ${e.solicitante} </td>
 <td> ${e.telefone} </td>
 <td> ${e.data} </td>
 <td> ${e.hora_inicio} </td>
 <td> ${e.hora_fim} </td>
 <td> ${e.espaco.identificacao} </td>
<tr>

<h1> ${e.hora_fim}</h1>
<h1> ${e.espaco.id}</h1>

</c:forEach>
</table>
</div>

<c:import url="rodape.jsp"></c:import>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="/Pre-Prova/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>