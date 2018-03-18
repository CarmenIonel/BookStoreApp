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
            <a th:href="@{/createOrder}">
            <button class='dotted thin'>Create Order</button>
            </a>
    </p>

    <p>
                <a th:href="@{viewOrder}">
                <button class='dotted thin'>View Order</button>
                </a>
    </p>

    <p>
                    <a th:href="@{updateOrder}">
                    <button class='dotted thin'>Update Order</button>
                    </a>
    </p>

    <p>
                        <a th:href="@{deleteOrder}">
                        <button class='dotted thin'>Delete Order</button>
                        </a>
     </p>


    <p>
        <a th:href="@{searchTitle}">
        <button class='dotted thin'>Search By Title</button>
        </a>
   	</p>

   	<p>
            <a th:href="@{searchAuthor}">
            <button class='dotted thin'>Search By Author</button>
            </a>
     </p>

    <p>
                <a th:href="@{searchGenre}">
                <button class='dotted thin'>Search By Genre</button>
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