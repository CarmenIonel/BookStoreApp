<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Update Order</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>

</head>

<body>
<form th:action="@{/updateOrder}" th:method='POST'>
<div id="content">
    <h1>Update Order</h1>

    <p>
            <label for="name" class="name"> Name
            </label>
            <input type="text" name="name" id="name" placeholder="Search field" required="required"/>
    </p>
    
    <p>
            <label for="delete" class="delete"> Delete Book
            </label>
            <input type="text" name="delete" id="delete" placeholder="Title" />
    </p>
    
    <p>
            <label for="add" class="add"> Add Book
            </label>
            <input type="text" name="title" id="title" placeholder="Title" />
            <input type="text" name="author" id="author" placeholder="Author" />
    </p>
    
    <p>
            <label for="nr" class="nr"> Number of books to add
            </label>
            <input type="text" name="nr" id="nr" placeholder="Number" patter="[0-9]"/>
    </p>
    
    <p>
           <button type="submit" name="action" value="Update">Update</button>
    </p>



</div>
</form>
</body>
</html>