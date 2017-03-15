
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <meta  charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/proveedores.htm"/>">Proveedores</a></li>
                <li class="active">Agregar</li>
               
            </ol>
                <div class="panel panel-primary">
                    <div class="panel-heading">Formulario</div>
                    <div class="panel-body">
             
                <form:form method="post"  commandName="proveedor"> 
                 <h1 style="text-align: center">Registro de Proveedores</h1>
                 <br>
                 <form:errors path="*" element="div" cssClass="alert alert-danger"/>
            <p>
                <form:label path="Nombre">Nombre</form:label>
                <form:input path="Nombre" cssClass="form-control"/> 
            </p>
            
            <p> 
                <form:label path="Tipo_Persona">Tipo Persona</form:label>
                <form:input path="Tipo_Persona" cssClass="form-control"/> 
            </p>
            <p> 
                <form:label path="Cedula">Cedula/RNC</form:label>
                <form:input path="Cedula" cssClass="form-control"/> 
            </p>
            <p> 
                <form:label path="Balance">Balance(RD$)</form:label>
                <form:input path="Balance" cssClass="form-control"/> 
            </p>
             <p> 
                <form:label path="Estado">Estado</form:label>
                <form:input path="Estado" cssClass="form-control"/> 
            </p>
             
            <hr>
            <input type="submit" value="Registrar" class="btn btn-danger">
        </form:form>
            
           </div>  
        </div> 
      </div>
    </body>
</html>
