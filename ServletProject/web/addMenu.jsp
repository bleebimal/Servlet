<%--
  Created by IntelliJ IDEA.
  User: bmal
  Date: 6/27/16
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;">

    <title>Add Items</title>

    <style>
        input[type=text] {
            width: default;
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
</head>
<body>
<form action="/add" method="post">
    <fieldset>
        <div>
            <label>ID</label>
            <input type="text" name="id" placeholder="Item ID"  />

        </div>
        <div>
            <label>Food Item</label>
            <input type="text" name="foodItem" />

        </div>
        <div>
            <label>Category</label>
            <input type="text" name="category"/>

        </div>
        <div>
            <label>Price</label>
            <input type="text" name="price"/>

        </div>
        <div>
            <label>Time Available</label>
            <input type="text" name="timeAvailable"/>

        </div>
        <div>
            <input type="submit" value="Submit" />
        </div>
    </fieldset>
</form>
</body>
</html>
