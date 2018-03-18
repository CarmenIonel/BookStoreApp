<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Create Employee</title>
    <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>
<body>
<form th:action="@{/createEmployee}" th:method='POST'>
<div id="content">

    <h1>Create Employee</h1>

        <p>
            <label for="name" class="name"> Name
            </label>
            <input type="text" name="name" placeholder="Name" required="required"/>
        </p>

        <p>
            <label for="address" class="address">Address
            </label>
            <input type="address" name="address" id="address" placeholder="Address" required="required"/>
        </p>

        <p>
            <label for="email" class="email"> E-mail</label>
            <input type="email" name="email" id="email" 	placeholder="eg: ionel.carmen@yahoo.com" required="required"/>
        </p>

		<p>
            <label for="phone" class="phone"> Phone</label>
            <input type="text" name="phone" id="phone" placeholder="07xxxxxxxx" required="required" pattern="[07][0-9]{9}"/>
        </p>

        <p>
            <label for="username" class="username"> Username</label>
            <input type="username" name="username" id="username" 	placeholder="Username" required="required"/>
        </p>

        <p>
            <label for="password" class="password"> Password</label>
            <input type="text" name="password" id="password" placeholder="Minim 6 characters" required="required"/>
        </p>

        <p>
               <button type="submit" name="action" value="Create">Create</button>
        </p>

</div>
</form>
</body>
</html>