<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
        <meta charset="UTF-8"/>
        <title>View Order</title>
        <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<div id="content">
    <h1>View Order</h1>

    <form th:action="@{/viewOrder}" th:method='POST'>
    <p>
            <label for="name" class="name"> Name
            </label>
            <input type="text" name="name" id="name" placeholder="Search field"/>
    </p>

            <table class="table table-hover table-striped-rows table-bordered table-condensed">
            <thead>
                   <tr>
                   </tr>
            </thead>
            <tr th:each="listValue1 : ${order}">

            <label for="name22" class="name22"> Name</label>
            <td class="text-left" th:text="${listValue1.name}">Name</td>

            <table class="table table-hover table-striped-rows table-bordered table-condensed">
            <thead>
            <tr>
                   <td><b>Title</b></td>
                   <td><b>Author</b></td>
            </tr>
            </thead>
            <tr th:each="listValue : ${listValue1.books}">
                    <td class="text-left" th:text="${listValue.title}">Title</td>
                    <td class="text-left" th:text="${listValue.author}">Author</td>
            </tr>
             </table>


             <label for="namew1" class="name21"> Price</label>
             <td class="text-left" th:text="${listValue1.price}">Price</td>

            </tr>
            </table>

            <p>
                <button type="submit" name="action" value="View">View</button>
            </p>

            </form>

            <p>

               <a th:href="@{/employeeMeniu}">
               <button class='dotted thin'>Back</button>
               </a>

            </p>
</div>

</body>
</html>