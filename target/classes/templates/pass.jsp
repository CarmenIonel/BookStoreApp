<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">

<head>

    <meta charset="UTF-8"/>
    <title>Go to menu</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<form th:action="@{/pass}" th:method='POST'>
<div id="content">
    <h1>Welcome!</h1>
		<p>
                    <a th:href="@{/employeeMeniu}">
                    <button class='dotted thin'>Menu</button>
                    </a>
        </p>
</div>
</form>
</body>
</html>