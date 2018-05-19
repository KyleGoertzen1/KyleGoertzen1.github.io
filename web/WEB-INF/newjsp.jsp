<%-- 
    Document   : newjsp
    Created on : Feb 5, 2018, 2:48:32 PM
    Author     : 729347
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="values" items="${Value}">
            <tr>
                <td>${values.word}</td>
            </tr>
        </c:forEach>
        <form action="main" method="post">
            <input type="submit" value="Load">
        </form>
        <h1>Hello World!</h1>
    </body>
</html>
