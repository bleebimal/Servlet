<%--
  Created by IntelliJ IDEA.
  User: bmal
  Date: 5/27/16
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User </title>
</head>
<style>

    form{
        margin: 50px;
    }
    input[type=text], [type=password]{
        background-color: white;
        background-repeat: no-repeat;
        padding-left: 40px;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
    }

    input[type=submit]{
        transition-duration: 0.4s;
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        border-radius: 2px;


    }

    input[type=submit]:hover{
        background:#009999;
        color:black;
    }
</style>
<body>
<br />

<form method="post" action="loginRegister">
    <fieldset>
        <legend> <h2>Register</h2> </legend>
        Username: <input type="text" name="username"> <br />
        Password: <input type="password" name="password"> <br />
        Name: <input type="text" name="Name"> <br />
        <input type="hidden" name="operation" value="register"> <br />
        <input type="submit" value="Register">
    </fieldset>
</form>


<form method="post" action="loginRegister">
    <fieldset>
        <legend> <h2>Login</h2></legend>
        Username: <input type="text" name="username"> <br />
        Password: <input type="password" name="password"> <br />
        <input type="hidden" name="operation" value="login"> <br />
        <input type="submit" value="Login"> <br />
    </fieldset>
</form>

<form method = "post" action="/Menu">
    <input type="submit" value="View"> <br />

</form>
</body>
</html>
