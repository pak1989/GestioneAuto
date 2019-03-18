<%@page import="it.gestioneauto.model.Automobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminina</title>
</head>
<body>

 <div class="container">

   <%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Elimina Automobile</h3>
	  <%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<h4 style="color:red;"> <%=  request.getAttribute("messaggioDiErrore") %> </h4>
	<% } %>
	</div>

		<%Automobile automobileDaEliminaServlet = (Automobile)request.getAttribute("automobileDaInviareAPaginaEliminaForm");%>

      	<form class="form-horizontal" action="ExecuteEliminaAutomobileServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="idInputId"></label>
	    		<div class="col-sm-4">
					<input class="form-control"  type="hidden" id="idInputId" name="idInput" value="<%=automobileDaEliminaServlet.getId()%>">
			 	</div>
  			</div>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="marcaInputId">
      			Sicuro di voler eliminare <%=automobileDaEliminaServlet.getMarca()%> - <%=automobileDaEliminaServlet.getModello()%>?<br>Scrivi la sua marca<br>per conferma...</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="marcaInputId" name="marcaInput" value="">
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Elimina</button>
		      </div>
		    </div>
		</form>

    </div><!-- /.container -->

	

</body>
</html>