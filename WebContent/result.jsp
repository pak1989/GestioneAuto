<%@page import="it.gestioneauto.model.Automobile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>risultati</title>
</head>
<body>

	<div class="container">

  	<%@ include file="header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Automobile> listaAutomobili = (List<Automobile>)request.getAttribute("listaPersone.attribute.name"); 
			for(Automobile automobileItem:listaAutomobili){ %>
			<tr>
				<td><%=automobileItem.getMarca() %></td>
				<td><%=automobileItem.getModello() %></td>
				<td>
					<a href="VisualizzaDettaglioAutomobileServlet?idAutomobile=<%=automobileItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PreparaModificaAutomobileServlet?idAutomobile=<%=automobileItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PreparaEliminaAutomobileServlet?idAutomobile=<%=automobileItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PrepareInserisciAutomobileServlet" class="btn btn-info">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>