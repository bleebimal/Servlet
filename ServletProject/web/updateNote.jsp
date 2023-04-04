<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;">

    <title>Update</title>
</head>
<body>
<form action="/menu" method="post">
    <fieldset>
        <div>
            <label>Id</label>
            <input type="text" name="id" placeholder="ID" />

        </div>
        <div>
            <label>FoodItem</label>
            <input type="text" name="FoodItem" />

        </div>
        <div>
            <label>Category</label>
            <input type="text" name="Category"/>

        </div>
        <div>
            <label>Price</label>
            <input type="text" name="Price"/>

        </div>
        <div>
            <label>Time</label>
            <input type="text" name="availableTime"/>

        </div>
        <div>
            <input type="submit" value="Submit" />
        </div>
    </fieldset>
</form>
</body>
</html>

