<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>Cadastrar Usuário - AskGo</title>
</head>
<body>
	<c:url var="url" value="/usuario/save" />
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
			<a class="btn navbar-btn ml-2 text-white btn-secondary"> <i
				class="fa d-inline fa-lg fa-question-circle-o"></i>&nbsp; Sobre <br>
			</a>
		</div>
	</div>
	</nav>
	<div class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="card text-white p-5 bg-primary">
						<div class="card-body">
							<h1 class="mb-4">Cadastrar Usuário</h1>
							<form:form method="post" action="${url}" modelAttribute="usuario">
								<form:hidden path="id" />
								<div class="form-group">
									<label>Nome</label> 
									<form:input type="text" path="nome" class="form-control" id="inlineFormInput" placeholder="Seu nome"/>
								</div>
								<div class="form-group">
									<label>Email</label>
									<form:input path="email" type="email" class="form-control"
										placeholder="Seu email" />
								</div>
								<div class="form-group">
									<label>Senha</label>
									<form:input path="senha" type="password" class="form-control"
										placeholder="Senha" />
									<form:errors path="senha" class="error" />
								</div>
								<input type='submit' value='Salvar' type="submit" cssClass="btn btn-secondary" />
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src='<c:url  value="https://code.jquery.com/jquery-3.2.1.slim.min.js" />'
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src='<c:url  value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" />'
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src='<c:url  value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"  />'
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>