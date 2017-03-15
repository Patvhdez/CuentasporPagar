 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <meta  charset="UTF-8">
        <title>Pagos JSP</title>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/pago.htm"/>">Conceptos de Pago</a></li>
                <li class="active">Agregar</li>
               
            </ol>
                <div class="panel panel-primary">
                    <div class="panel-heading">Formulario</div>
                    <div class="panel-body">
             
                <form:form method="post"  commandName="pago"> 
                 <h1 style="text-align: center">Editar Pago</h1>
                 <br>
                 <form:errors path="*" element="div" cssClass="alert alert-danger"/>
            <p>
                <form:label path="Descripcion">Descripcion</form:label>
                <form:input path="Descripcion" cssClass="form-control"/> 
            </p>
            
            <p> 
                <form:label path="Estado">Estado</form:label>
                <form:input path="Estado" cssClass="form-control"/> 
            </p>
            
            <hr>
            <input type="submit" value="Actualizar" class="btn btn-danger">
        </form:form>
            
           </div>  
        </div> 
      </div>
    </body>
</html>
