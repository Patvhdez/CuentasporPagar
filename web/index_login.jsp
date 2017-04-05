<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Login</title>
        <script>
           var attempt = 3; // Variable to count number of attempts.
// Below function Executes on click of login button.
function validate(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if ( username == "admin" && password == "abcd"){
alert("Login successful!");
windows.location.href = "http://localhost:8080/CuentasporPagar/index.htm" // Redirecting to other page.
return false;
}
else{
attempt --;// Decrementing by one.
alert("You have left "+attempt+" attempt;");
// Disabling fields after 3 attempts.
if( attempt == 0){
document.getElementById("username").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("submit").disabled = true;
return false;
}
}
}
        </script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container" align="center">
       <div class="login-page">
       <div class="form">
           <h3 style="color: darkgreen">Bienvenido!</h3><hr>
    <form action="http://localhost:8080/CuentasporPagar/index.htm" method="post" class="login-form">
      <input id="username" type="text" placeholder="username"/>
      <input id="password" type="password" placeholder="password"/>
      <button id="submit" type="submit" onclick="validate()">login</button>
    </form>
  </div>
</div>
        </div>
        <script>
            $('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});
        </script>
    </body>
</html>
