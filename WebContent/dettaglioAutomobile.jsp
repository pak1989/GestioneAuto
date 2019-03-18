<%@page import="it.gestioneauto.model.Automobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Automobile</title>
</head>
<body>

	<%
		Automobile automobileInPagina = (Automobile) request.getAttribute("automobileSingola.attribute.name");
	%>

	<div class="container">

		<%@ include file="header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=automobileInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Marca</dt>
				<dd class="col-sm-9"><%=automobileInPagina.getMarca()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Modello</dt>
				<dd class="col-sm-9"><%=automobileInPagina.getModello()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Colore</dt>
				<dd class="col-sm-9"><%=automobileInPagina.getColore()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cilindrata</dt>
				<dd class="col-sm-9"><%=automobileInPagina.getCilindrata()%></dd>
			</dl>
		</div>

	</div>

</body>
</html>