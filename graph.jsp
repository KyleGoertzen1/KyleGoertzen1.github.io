<%-- 
    Document   : graph
    Created on : Jan 5, 2018, 3:18:08 PM
    Author     : 729347
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <a href="graph?action=Logout">Logout</a>
    <p>Enter x^2 or x^3. More functions in progress.</p>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make a Graph</title>
    <form action="graph" method="post">
        F(x) = <input type="text" name="function"> <br>
        <input type="hidden" name="action" value="getGraph"><br>
        <input type="submit" value="Generate Graph">
    </form>

    <br>
    
    <table>
        <tr>
            <th>X</th>
            <th> | </th>
            <th>Y</th>
        </tr>

        <c:forEach var="count" items="${count}">
            <tr>
                <td>${table[count]}</td>
                <td> | </td>
                <td>${values[count]}</td>
            </tr>
        </c:forEach>

    </table>
</head>
<body>
</body>
</html>
