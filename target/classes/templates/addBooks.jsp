<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Add Book</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<div id="content">
    <h1>Add Books</h1>

    <form th:action="@{/addBooks}"  th:method='POST'>
    <p>
            <label for="title" class="title"> Title
            </label>
            <input type="text" name="title" id="title" placeholder="Title" required="required"/>
    </p> 
    
    <p>
            <label for="author" class="author"> Author
            </label>
            <input type="text" name="author" id="author" placeholder="Author" required="required"/>
    </p>
    
    <p>
            <label for="nr" class="nr"> Number of books
            </label>
            <input type="text" name="nr" id="nr" placeholder="Number" required="required" pattern="[0-9]"/>
    </p>
    <p>
           <button type="submit" name="action" value="Add Book">Add Book</button>
    </p>
    </form>

    <p>
            <a th:href="@{/createOrder}">
            <button class='dotted thin'>Submit Order</button>
            </a>
    </p>

</div>

</body>
</html>