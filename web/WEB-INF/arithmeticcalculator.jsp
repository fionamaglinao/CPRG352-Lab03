<%-- 
    Document   : arithmeticcalculator
    Created on : May 31, 2021, 12:49:30 AM
    Author     : 851314
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
            <label>First: </label>
            <input type="text" name="first_value" value="${firstValue}">
            <br>
            <label>Second: </label>
            <input type="text" name="second_value" value="${secondValue}">
            <br>
            <input type="submit" name="operation" value="+">
            <input type="submit" name="operation" value="-">
            <input type="submit" name="operation" value="*">
            <input type="submit" name="operation" value="%">
        </form>
        <p>Result: ${output}</p>
        <p><a href="age">Age Calculator</a></p>
        <p>${message}</p>
    </body>
</html>
