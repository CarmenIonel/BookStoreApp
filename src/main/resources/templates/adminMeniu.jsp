<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="UTF-8"/>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>
<body>
<div id="content">
    <h1>Menu</h1>

    <p>
        <a th:href="@{/createEmployee}">
        <button class='dotted thin'>Create Employee</button>
        </a>
   	</p>

    <p>
        <a th:href="@{/viewEmployee}">
        <button class='dotted thin'>View Employee</button>
        </a>
   	</p>

    <p>
        <a th:href="@{/updateEmployee}">
        <button class='dotted thin'>Update Employee</button>
        </a>
   	</p>


    <p>
        <a th:href="@{/deleteEmployee}">
         <button class='dotted thin'>Delete Employee</button>
         </a>
   	</p>

    <p>
        <a th:href="@{/createBook}">
        <button class='dotted thin'>Create Book</button>
        </a>
   	</p>

    <p>
        <a th:href="@{/viewBook}">
        <button class='dotted thin'>View Book</button>
        </a>

   	</p>

    <p>
        <a th:href="@{/updateBook}">
        <button class='dotted thin'>Update Book</button>
        </a>
   	</p>


    <p>
        <a th:href="@{/deleteBook}">
        <button class='dotted thin'>Delete Book</button>
        </a>
   	</p>
    
    <p>
        <a th:href="@{/getReport}">
        <button class='dotted thin'>Generate Report</button>
        </a>
   	</p>

   	<p>
   	    <a th:href="@{/logout}">
        <button class='dotted thin'>Log Out</button>
        </a>
    </p>
</div>
</body>
</html>