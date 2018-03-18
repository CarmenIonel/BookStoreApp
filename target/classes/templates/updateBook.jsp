<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Update Book</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<form th:action="@{/updateBook}" th:method='POST'>
<div id="content"  >

    <h1>Update Book</h1>

        <p>
                 <label for="title" class="title"> Title
                 </label>
                 <input type="text" name="title" id="title" placeholder="Search field" />
                </p>

                <p>
                 <label for="author" class="author"> Author
                 </label>
                 <input type="text" name="author" id="author" placeholder="Search field" />
                </p>
        <p>
            <label for="title1" class="title1"> Title
            </label>
            <input type="text" name="title1" id="title1" placeholder="Title" />
        </p>

        <p>
            <label for="author1" class="author1">Author            </label>
            <input type="text" name="author1" id="author1" placeholder="Author" />
        </p>

		<p>
            <label for="genre" class="genre"> Genre</label>
            <input type="text" name="genre" id="genre" placeholder="Genre"  />
        </p>

        <p>
            <label for="price" class="price"> Price</label>
            <input type="text" name="price" id="username" 	placeholder="Price"  pattern="[0-9]*(\.)?[0-9]+"/>
        </p>

        <p>
             <label for="stock" class="stock"> Stock</label>
              <input type="text" name="stock" id="stock" 	placeholder="Stock"  pattern="[0-9]*(\.)?[0-9]+"/>
        </p>

        <p>
             <button type="submit" name="action" value="Update">Update</button>
        </p>

</div>
</form>
</body>
</html>