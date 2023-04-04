<%--
  Created by IntelliJ IDEA.
  User: bmal
  Date: 6/27/16
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show All Items</title>

    <style>

        h1{
            text-align: center;
            color: chocolate;
        }
        table {
            width: 70%;
            border-radius: 1px;
            border-collapse: collapse;
            border: solid 3px;
            border-spacing: 2px;
            border-color: gray
        }


        a{
            color: #009999;
            margin: 40px;
        }

        th {
            background-color: #4CAF50;
            color: darkolivegreen;
            height: 50px;
            padding: 15px;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #e6e6ff;
        }
        td{
            height: 50px;
            padding: 15px;
            text-align: left;
        }

    </style>
</head>
<body>

<h1>Today's Menu</h1>
  <table border="2" align="center" style="width:50%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Food Item</th>
        <th>Category</th>
        <th>Price</th>
        <th>Time Available</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${menus}" var="menu">
        <tr>
            <td><c:out value="${menu.id}" /></td>
            <td><c:out value="${menu.foodItem}" /></td>
            <td><c:out value="${menu.category}" /></td>
            <td><c:out value="${menu.price}" /></td>
            <td><c:out value="${menu.timeAvailable}" /></td>
            <td><a
                    href="/Menu?action=edit&id=<c:out value="${menu.id}"/>">Update</a></td>
            <td><a
                    href="/Menu?action=delete&id=<c:out value="${menu.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="/Menu?action=insert">Add New Items</a>
</p>
</body>
</html>