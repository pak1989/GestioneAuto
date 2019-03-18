<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci</title>
</head>
<body>

 <div class="container">

   <%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Creazione Automobile</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteInserisciAutomobileServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="marcaInputId">Marca:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="marcaInputId" name="marcaInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="modelloInputId">Modello:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="modelloInputId" name="modelloInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="coloreInputId">Colore:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="coloreInputId" name="coloreInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cilindrataInputId">Cilindrata:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cilindrataInputId" name="cilindrataInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Crea</button>
		      </div>
		    </div>
		</form>

    </div><!-- /.container -->

	

</body>
</html>