<%-- 
    Document   : agecalculator
    Created on : Jan 26, 2021, 2:24:37 PM
    Author     : 840018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        
        <br>
        <form method ="POST" action ="age">
            <label>Enter your age:</label>
            <input type ="text" name = "Age" value ="${oldAge}">
            <br>
            <input type ="submit" value ="Age next birthday">
            
    </body>
</html>
