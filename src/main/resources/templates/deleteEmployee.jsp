<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Delete Employee</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<form th:action="@{/deleteEmployee}" th:method='POST'>
<div id="content" >

    <h1>Delete Employee</h1>

        <p>
            <label for="name" class="name"> Name
            </label>
            <input type="text" name="name" id="name" placeholder="Name" />
        </p>

        <p>
            <label for="username" class="username"> Username</label>
            <input type="username" name="username" id="username" 	placeholder="username" />
        </p>

        <p>
            <button type="submit" name="action" value="delete">Delete</button>
        </p>

</div>
</form>
</body>
</html>