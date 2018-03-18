<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>View Book</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>


<div id="content">

    <h1>View Book</h1>

        <form th:action="@{/viewBook}" th:method='POST'>
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
                <table class="table table-hover table-striped-rows table-bordered table-condensed">
                <thead>
                       <tr>
                            <td><b>Title</b></td>
                            <td><b>Author</b></td>
                            <td><b>Genre</b></td>
                            <td><b>Price</b></td>
                            <td><b>Stock</b></td>
                        </tr>
                </thead>

                <tr th:each="listValue : ${book1}">
                               <td class="text-left" th:text="${listValue.title}">Title</td>
                               <td class="text-left" th:text="${listValue.author}">Author</td>
                               <td class="text-left" th:text="${listValue.genre}">Genre</td>
                               <td class="text-left" th:text="${listValue.stock}">Stock</td>
                               <td class="text-left" th:text="${listValue.price}">Price</td>
                </tr>
                   </table>
                </p>

        <p>
              <button type="submit" name="action" value="View">View</button>
        </p>

     </form>

        <p>
                <a th:href="@{/adminMeniu}">
                <button class='dotted thin'>Back</button>
                </a>
           	</p>

</div>
</body>
</html>