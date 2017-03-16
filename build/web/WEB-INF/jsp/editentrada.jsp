<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <meta  charset="UTF-8">
        <title>Entrada JSP</title>
        
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/entrada.htm"/>">Entrada Documentos</a></li>
                <li class="active">Agregar</li>
               
            </ol>
                <div class="panel panel-primary">
                    <div class="panel-heading">Formulario</div>
                    <div class="panel-body">
             
                <form:form method="post"  commandName="entrada"> 
                 <h1 style="text-align: center">Editar entrada</h1>
                 <br>
                 <form:errors path="*" element="div" cssClass="alert alert-danger"/>
            <p>
                <form:label path="Fecha_doc">Fecha Documento</form:label>
                <form:input path="Fecha_doc" cssClass="form-control"/> 
            </p>
            
             <p>
                <form:label path="Monto">Monto (RD$)</form:label>
                <form:input path="Monto" cssClass="form-control"/> 
            </p>
            
             <p>
                <form:label path="Fecha_registro">Fecha Registro</form:label>
                <form:input path="Fecha_registro" cssClass="form-control"/> 
            </p>
            
            <p>
                <form:label path="Proveedor">Proveedor</form:label>
                <form:input path="Proveedor" cssClass="form-control"/> 
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
