<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Create Book</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>
<form th:action="@{/createBook}" th:method='POST'>
<div id="content">

    <h1>Create Book</h1>

        <p>
            <label for="title" class="title"> Title
            </label>
            <input type="text" name="title" id="title" placeholder="Title" required="required"/>
        </p>

        <p>
            <label for="author" class="author">Author </label>
            <input type="address" name="author" id="author" placeholder="Author" required="required"/>
        </p>

		<p>
            <label for="genre" class="genre"> Genre</label>
            <input type="text" name="genre" id="genre" placeholder="Genre" required="required"/>
        </p>

        <p>
            <label for="price" class="price"> Price</label>
            <input type="text" name="price" id="username" 	placeholder="Price" required="required" pattern="[0-9]*(\.)?[0-9]+"/>
        </p>

        <p>
                    <label for="stock" class="stock">Stock</label>
                    <input type="text" name="stock" id="stock" 	placeholder="Stock" required="required" pattern="[0-9]*(\.)?[0-9]+"/>
        </p>

        <p>
              <button type="submit" name="action" value="Create">Create</button>
        </p>

</div>
</form>
</body>
</html>