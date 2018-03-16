<%-- 
    Document   : enterWebsite
    Created on : Nov 25, 2017, 1:47:10 PM
    Author     : 729347
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
    </head>
    <body>
        <h1>Login Using the Form Below</h1>
        <form action="login" method="post">
            Username: <input type="text" name="enterUsername" value="user1"><br>
            Password: <input type="password" name="enterPassword" value="password"><br>
            <input type="hidden" name="action" value="userLoginForm"><br>
            <input type="submit" value="Sign In">
        </form>
        ${errorMessage}
    </body>
</html>
