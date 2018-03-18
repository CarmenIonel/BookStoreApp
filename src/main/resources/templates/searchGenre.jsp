<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Search</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>
<form th:action="@{/searchGenre}" th:method='POST'>
<div id="content">
    <h1>Search</h1>

    <p>
            <label for="genre" class="genre"> Genre
            </label>
            <input type="title" name="genre" id="genre" placeholder="Search field"/>
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
        <tr th:each="listValue : ${book}">
                       <td class="text-left" th:text="${listValue.title}">Title</td>
                        <td class="text-left" th:text="${listValue.author}">Author</td>
                        <td class="text-left" th:text="${listValue.genre}">Author</td>
                        <td class="text-left" th:text="${listValue.price}">Author</td>
                        <td class="text-left" th:text="${listValue.stock}">Author</td>
         </tr>
           </table>
        </p>

         <p>
                         <a th:href="@{/employeeMeniu}">
                         <button class='dotted thin'>Back</button>
                         </a>
         </p>
</div>
</form>
</body>
</html>