<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="kyle"><br/>
            Password: <input type="password" name="password" value="password"><br/>
            <input type="submit" value="Login">
        </form>
        <br/>
        
        ${message}
        
        <br/>
        
        <a href="register?register">Register an Account</a>
    </body>
</html>
