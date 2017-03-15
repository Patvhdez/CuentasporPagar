<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>

  <body data-spy="scroll" data-target=".navbar" data-offset="50">
    <style media="screen">
      body{
        padding: 0;
        margin: 0;
        background-color: #ffeecc ;
        position: relative;
      }
      div.jumbotron{
        margin: 0;
        color: #ffffff;
        background-color: #3366ff;
      }
    


    footer {
      background-color: #f2f2f2;
      padding: 20px;
      margin: 0;
    }

    </style>

<div class="container">
  <br>
  <header>
      <nav class="navbar navbar-inverse navbar-fixed-top" data-spy="affix"
    data-offset-top="197" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed"
          data-toggle="collapsed" data-target="#navbar-1">
        </button>
          <span class="sr-only">Menu</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <a href="#" class="navbar-brand">Login</a>
        </div>
        <div class="collapsed navbar-collapsed" id="navbar-1">
          <ul class="nav navbar-nav">
           <li><a href="">About</a></li>
            
        </ul>
         <span></span>
         <span></span>
         <span></span>
         <p class="navbar-text pull-right"></p>
        </div>
      </div>
    </nav>
     </div>
     </div>
  <div class="jumbotron">
  <div class="container text-center ">
    <h1>Cuentas x Pagar</h1>
    <br>
    <img  src="<%= request.getContextPath() %>/images/logo.png" width="140" height="140"/>
    <br>
    <br>
    
    <p>Realizado por:<br>
        Patrick Valenzuela, Martin Edmundo, Oliver Abreu y Angel
    Presinal</p>
  </div>
</div>
  </header>
</div>
<div class="container-fluid bg-3 text-center">
<div class="container-fluid prx-b">
<div class="container marketing">
<div class="row">
       <div class="col-lg-4">
           <br>
    <img  src="<%= request.getContextPath() %>/images/proveedores.png" width="140" height="140"/>
    <br>
    <br>
           <a href="<c:url value="proveedores.htm"/>" class="btn btn-info">
           <span class="glyphicon " aria-hidden="true"></span>
           <h4>Gestion de Proveedores</h4>
           </a>
        
          
       </div>

       <div class="col-lg-4">
           <br>
           <img  src="<%= request.getContextPath() %>/images/infopago.png" width="140" height="140"/>
           <br>
           <br>
          <a href="<c:url value="pago.htm"/>" class="btn btn-info">
              <span class="glyphicon " aria-hidden="true"></span>
           <h4>Gestion de Conceptos de Pago</h4>
           </a>
        </div>

        <div class="col-lg-4">
            <br>
           <img  src="<%= request.getContextPath() %>/images/ico-cuentas.png" width="140" height="140"/>
           <br>
           <br>
          <a href="<c:url value="entrada.htm"/>" class="btn btn-info">
           <span class="glyphicon " aria-hidden="true"></span>
           <h4>Entrada de Documentos</h4>
           </a>
        </div>

      </div>
      <br>
    </div>
      </div>
      </div>
   </div>
</div>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<br>
<br>
<br>
<footer class="container-fluid text-center">
  <p> © 2017 Integracion Open Source </p>
</footer>
  </body>
</html>
