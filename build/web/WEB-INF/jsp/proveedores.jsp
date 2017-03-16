
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <meta  charset="UTF-8"/>
        <title>Proveedores JSP</title>
    </head>
    <body>
        <h1 style="text-align: center">Gestion de Proveedores</h1>
        
        <div class="container">
            <div class="row">
                <p>
                    <a href="<c:url value="add.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                    <a href="<c:url value="index.htm"/>" class="btn btn-info" ><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
                </p>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Tipo Persona</th>
                            <th>Cedula/RNC</th>
                            <th>Balance (RD$)</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                        
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato"> 
                            <tr>
                                <td><c:out value="${dato.id}"/></td>
                                <td><c:out value="${dato.Nombre}"/></td>
                                <td><c:out value="${dato.Tipo_Persona}"/></td>
                                <td><c:out value="${dato.Cedula_Rnc}"/></td>
                                <td><c:out value="${dato.Balance}"/></td>
                                 <td><c:out value="${dato.Estado}"/></td>
                                 <td>
                                      <a href="<c:url value="edit.htm?id=${dato.id}"/>" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                      <a href="<c:url value="delete.htm?id=${dato.id}"/>" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                 </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                    
                </table>
            </div>
            
        </div>
        
    </body>
</html>
