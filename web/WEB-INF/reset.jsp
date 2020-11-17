<%-- 
    Document   : reset
    Created on : Nov 16, 2020, 5:27:24 PM
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
        <h1>Reset Password</h1>
        <p>
            Please enter your email address to reset your password.
        </p>
        <form method="post" action="reset">
            Email Address:
            <input type="text" name="email"><br>
            <input type="submit" value="Submit">
            <input type="hidden" name="action" value="send">
        </form>
        ${message}
    </body>
</html>
