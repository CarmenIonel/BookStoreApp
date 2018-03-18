<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Delete Book</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<form th:action="@{/deleteBook}"  th:method='POST'>
<div id="content" >

    <h1>Delete Book</h1>

        <p>
            <label for="title" class="title"> Title
            </label>
            <input type="text" name="title" id="title" placeholder="Search field" required="required" />
        </p>

        <p>
            <label for="author" class="author">Author            </label>
            <input type="address" name="author" id="author" placeholder="Search field" required="required"/>
        </p>

        <p>
             <button type="submit" name="action" value="delete">Delete</button>
        </p>

</div>
</form>
</body>
</html>