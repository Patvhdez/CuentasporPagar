
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <meta  charset="UTF-8">
        <title>entrada JSP </title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 style="text-align: center">Entrada de Documentos</h1>
                <p>
                    <a href="<c:url value="addentrada.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                    <a href="<c:url value="index.htm"/>" class="btn btn-info" ><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                      <th>ID</th>
                      <th>Fecha Documento</th>
                      <th>Monto (RD$)</th>
                      <th>Fecha Registro</th>
                      <th>Proveedor</th>
                      <th>Estado</th>
                      <th>Acciones</th>
                     
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"/></td> 
                                <td><c:out value="${dato.Fecha_doc}"/></td> 
                                <td><c:out value="${dato.Monto}"/></td> 
                                <td><c:out value="${dato.Fecha_registro}"/></td> 
                                <td><c:out value="${dato.Proveedor}"/></td> 
                                <td><c:out value="${dato.Estado}"/></td> 
                                <td> 
                                   <a href="<c:url value="editentrada.htm?id=${dato.id}"/>" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="deleteentrada.htm?id=${dato.id}"/>" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>  
                        </c:forEach>
                    </tbody>
                    
                </table>
                
            </div>
            
        </div>
    </body>
</html>
