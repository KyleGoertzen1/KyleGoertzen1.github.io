<%-- 
    Document   : register.jsp
    Created on : May 13, 2018, 12:03:13 AM
    Author     : Andrea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <a href="login?home">Home</a>
        <form action="register" method="POST">
            <h2>Create a new account.</h2>
            <br/>
            
            New Username: <input type="text" name="newusername"><br/>
            New Password: <input type="password" name="newpassword"><br/>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
