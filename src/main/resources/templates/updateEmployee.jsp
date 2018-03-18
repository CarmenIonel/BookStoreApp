<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8"/>
    <title>Update Employee</title>
     <link rel="stylesheet" type="text/css" th:src="@{/css/adminMeniu.css}" href="/css/adminMeniu.css"/>
</head>

<body>

<form th:action="@{/updateEmployee}" th:method='POST'>
<div id="content"  >

    <h1>Update Employee</h1>

        <p>
                 <label for="name" class="name"> Name
                 </label>
                 <input type="text" name="name" id="name" placeholder="Search field" />
                </p>

                <p>
                 <label for="username" class="username"> Username
                 </label>
                 <input type="text" name="username" id="username" placeholder="Search field" />
                </p>
        <p>
            <label for="name1" class="name1"> Name
            </label>
            <input type="text" name="name1" id="name1" placeholder="Name" />
        </p>

        <p>
            <label for="address" class="address">Address
            </label>
            <input type="address" name="address" id="address" placeholder="Address" />
        </p>

        <p>
            <label for="email" class="email"> E-mail</label>
            <input type="email" name="email" id="email" 	placeholder="eg: ionel.carmen@yahoo.com" />
        </p>

		<p>
            <label for="phone" class="phone"> Phone</label>
            <input type="text" name="phone" id="phone" placeholder="07xxxxxxxx"  pattern="[07][0-9]{9}"/>
        </p>

        <p>
            <label for="username1" class="username1"> Username</label>
            <input type="text" name="username1" id="username1" 	placeholder="username" />
        </p>

        <p>
            <label for="password" class="password"> Password</label>
            <input type="text" name="password" id="password" placeholder="Minim 6 characters" />
        </p>

        <p>
            <button type="submit" name="action" value="Update">Update</button>
        </p>

</div>
</form>
</body>
</html>