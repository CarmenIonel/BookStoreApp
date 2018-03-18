<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Create Order</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<div id="content">
    <h1>Create Order</h1>


    <p>
            <a th:href="@{/addBooks}">
            <button class='dotted thin'>Add books</button>
            </a>
    </p>

    <form th:action="@{/createOrder}"  th:method='POST'>
	<p>
                <label for="name" class="name"> Name
                </label>
                <input type="text" name="name" id="name" placeholder="Name" />
    </p>

    <p>
        <button type="submit" name="action" value="Add Order">Add Order</button>
    </p>

    </form>

</div>

</body>
</html>