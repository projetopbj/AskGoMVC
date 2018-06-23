<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Cadastrar Enquete - AskGo</title>
</head>
<body>
	<c:url var="url" value="/enquete/save" />
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
			<a class="btn navbar-btn ml-2 text-white btn-secondary" href="/AskGO/enquete/listar">Enquetes<br>
			</a>
			<a class="btn navbar-btn ml-2 text-white btn-secondary" href="/AskGO/usuario/listar">Usu�rios<br>
			</a>
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
							Cadastrar Enquete<br>
						</div>
						<div class="card-body">
							<form:form method="post" action="${url}" modelAttribute="enquete">
								<form:hidden path="id"/>
								<div class="form-group">
									<label>T�tulo</label>
									<form:input type="text" path="titulo" class="form-control"
										id="inlineFormInput" placeholder="T�tulo da Enquete" />
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Descri��o</label>
									<form:textarea type="text" path="descricao" class="form-control"
										id="inlineFormInput" placeholder="Descri��o da Enquete" />
								</div>
								<div class="form-group">
									<label>Data Limite para Vota��o</label> 
									<form:input type="date" path="dataFim" class="form-control"
										id="inlineFormInput" placeholder="Data final de vota��o para Enquete" />
								</div>
								<div class="form-group form-row my-3">
									<label class="col-sm-2 col-form-label">Op��o&nbsp;</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="inlineFormInput"
											placeholder="Op��o da enquete">
									</div>
								</div>
								<a href="#" class="btn btn-outline-primary btn-block">Adicionar
									outra op��o <br>
								</a>
								<br>
								<input type='submit' value='Salvar' cssClass="btn btn-secondary" />
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