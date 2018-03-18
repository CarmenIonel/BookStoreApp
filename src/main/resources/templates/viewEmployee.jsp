<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
        <meta charset="UTF-8"/>
        <title>View Employee</title>
        <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>


<div id="content">

    <h1>View Employee</h1>

        <form th:action="@{/viewEmployee}" th:method='POST'>
        <p>
                    <label for="name" class="name"> Name
                    </label>
                    <input type="text" name="name" id="name" placeholder="Search field" />
        </p>

        <p>
                    <label for="username" class="username"> Username</label>
                    <input type="username" name="username" id="username" 	placeholder="Search field" />
        </p>
        <p>
                        <table class="table table-hover table-striped-rows table-bordered table-condensed">
                        <thead>
                               <tr>
                                    <td><b>Name</b></td>
                                    <td><b>Username</b></td>
                                    <td><b>Address</b></td>
                                    <td><b>Email</b></td>
                                    <td><b>Phone</b></td>
                                </tr>
                        </thead>

                        <tr th:each="listValue : ${employee1}">
                                       <td class="text-left" th:text="${listValue.name}">Name</td>
                                       <td class="text-left" th:text="${listValue.username}">Username</td>
                                       <td class="text-left" th:text="${listValue.address}">Address</td>
                                       <td class="text-left" th:text="${listValue.email}">Email</td>
                                       <td class="text-left" th:text="${listValue.phone}">Phone</td>
                        </tr>
                           </table>
        </p>
        
        <p>
              <button type="submit" name="action" value="view">View</button>
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