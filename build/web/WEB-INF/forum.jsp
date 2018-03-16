<%-- 
    Document   : forum
    Created on : Feb 3, 2018, 12:39:57 PM
    Author     : 729347
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<a href="forum?action=Logout">Logout</a>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hacker Plaza</title>
    </head>
    <body>        
        <c:forEach var="post" items="${stories}">
            <tr>
                <td>${post.story}</td>
            </tr>
        </c:forEach>
        <form action="forum" method="get">
            <input type="submit" value="Database Test Load">
        </form>
    </body>
    <br>
    <a href="forum?action=displayNews">News</a>
    <script>
        alert('hi');
        </script>
</html>
