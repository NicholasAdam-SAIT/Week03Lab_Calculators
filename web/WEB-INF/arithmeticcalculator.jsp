<%-- 
    Document   : arithmeticcalculator
    Created on : Jan 29, 2021, 4:36:12 PM
    Author     : 840018
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
        
        <form method ="POST" action ="arithmetic">
            <label>First:</label>
            <input type ="text" name ="firstnum" value = "${firstNum}">
            <br>
            <label>Second:</label>
            <input type ="text" name ="secondnum" value = "${secondNum}">
            <br>
            
            <input type ="submit" name ="operation" value="+">
            <input type="submit" name ="operation"value ="-">
            <input type ="submit" name ="operation" value ="*">
            <input type ="submit" name ="operation" value ="%">
            <br>
            <p >Result: ${result}</p>
            <br>
            <a href ="/Week3Lab_Calculators/age">Age Calculator</a>
    </body>
</html>