<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Generate Report</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<div id="content">
    <h1>Generate Report</h1>

    <form th:action="@{/getReport}" th:method='POST'>
    <p>
            <label for="type" class="type">Type of report
            </label>
            <input type="text" name="type" id="type" placeholder="pdf or csv" />
    </p>

    <p>
            <button type="submit" name="action" value="Generate">Generate</button>
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