<%-- 
    Document   : resetNewPassword
    Created on : Nov 16, 2020, 5:49:52 PM
    Author     : 791662
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes App</title>
    </head>
    <body>
        <h1>Enter a new password</h1>
        <form method="post" action="reset">
            <input type="password" name="password"><br>
            <input type="submit" value="Submit">
            <input type="hidden" name="userUuid" value="${userUuid}">
            <input type="hidden" name="action" value="update">
        </form>
        ${message}<br>
        <a href="login">Login</a>
    </body>
</html>
