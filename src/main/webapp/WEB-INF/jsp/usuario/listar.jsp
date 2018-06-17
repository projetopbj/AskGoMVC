<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para fun��es -->
 	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de usuarios</title>
</head>
<body>
    <c:url var="url" value="/usuario/form" />
	<a href='${url}'>Novo</a>
	<br />
		 <!--
			
			<c:if test="${mensagem != null}">
				
			<script>
				alert('${mensagem}');
			</script>
		    </c:if>
		    
		    <br />
		    <br />
		    <br />
		     -->
		     
		     <c:url var= "urlFiltro" value="/usuario/filtrar" />
		    <form:form method="get" action="${urlFiltro}" modelAttribute="filtro">
			    Nome:<form:input path="nome"/>
			    Email:<form:input path="email"/>
			    <input type="submit" value="pesquisar">
		    </form:form>
		    
		    <br />
		    <br />
		    <br />
	<table>
		<tr>
			<td>Nome</td>
			<td>Email</td>
		</tr>
		
		<c:forEach var="usuario" items="${usuarios}" >
			
		<tr>
			<td>${usuario.nome}</td>
			<td>${usuario.email}</td>
			<td>

				<a href='<c:url value="/usuario/${usuario.id}/remove" />'>remover</a>
				<a href='<c:url value="/usuario/${usuario.id}/form" />'>editar</a>

			</td>
		</tr>
		</c:forEach>

	</table>


</body>
</html>