<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Delete Order</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>
<form th:action="@{/deleteOrder}" th:method='POST'>
<div id="content">
    <h1>Delete Order</h1>

    <p>
            <label for="name" class="name"> Name
            </label>
            <input type="text" name="name" id="name" placeholder="Search field" required="required"/>
    </p>

    <p>
            <button type="submit" name="action" value="delete">Delete</button>
    </p>

</div>
</form>
</body>
</html>