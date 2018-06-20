<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- para funções -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link href="<c:url value='/resources/css/theme.css' />" rel="stylesheet">
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<title>Usuários - AskGo</title>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-primary navbar-dark">
	<div class="container">
		<a class="navbar-brand" href="#">AskGO <br>
		</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbar2SupportedContent"
			aria-controls="navbar2SupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse text-center justify-content-end"
			id="navbar2SupportedContent">
			<ul class="navbar-nav">
				<a class="btn btn-primary" href="#">Agenda <br>
				</a>
				<a class="btn btn-primary" href="#">Contatos <br>
				</a>
				<div class="btn-group">
					<button class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">Notificações</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Sem novas notificações <br>
						</a>
					</div>
				</div>
			</ul>
			<a class="btn navbar-btn ml-2 text-white btn-secondary"> <i
				class="fa d-inline fa-lg fa-user-circle-o"></i>&nbsp;&nbsp;Perfil <br>
			</a>
		</div>
	</div>
	</nav>
	<div class="py-5">
		<div class="container">
		
			<div class="row">
        		<div class="col-md-12">
          			<div class="card">
          				<div class="card-header bg-primary">
							Filtrar <br>
						</div>
						<div class="card-body">
	          				<c:url var="urlFiltro" value="/usuario/filtrar" />
							<form:form method="get" action="${urlFiltro}" modelAttribute="filtro">
							    Nome:<form:input path="nome" />
							    Email:<form:input path="email" />
								<input type="submit" value="Pesquisar">
							</form:form>
						</div>
          			</div>
          			
          			<br>
          			<div class="card">
		          			<c:url var="url" value="/usuario/form" />
							<a class="btn btn-success" href="${url}">Adicionar Usuário</a>
					</div>
					<br>
					
          		</div>
          	</div>

			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header bg-primary">
							Usuários Cadastrados <br>
						</div>
					</div>
					<table class="table">
						<tbody>
							<c:forEach var="usuario" items="${usuarios}">
								<tr>
									<td><i class="d-block  fa fa-2x fa-user-circle"></i></td>
									<td class="w-75">${usuario.nome}</td>
									<td class="w-75">${usuario.email}</td>
									<td class="btn-group"> <a
										href="<c:url value="/usuario/${usuario.id}/form" />"
										class="btn btn-outline-primary">Editar</a> <a
										href="<c:url value="/usuario/${usuario.id}/remove" />"
										class="btn btn-outline-primary">Remover</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>