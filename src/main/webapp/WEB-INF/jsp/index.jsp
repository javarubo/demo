<%--
  Created by IntelliJ IDEA.
  User: georgi.bagiryan
  Date: 12/26/2019
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>






<form action="/login" method="post">
    <b>
        login
    </b></br>
    <input type="text" name="username" size="40" >
    </br>
    <b>
        password
    </b></br>
    <input type="password" name="password" size="40" >
    </br>
    <input type="checkbox" name="remember" value="true"> Remember me    </br>
    <input type="submit" value="Log in"/>
</form>
<%--<button onclick="window.location.href = '/goto-register.jsp'">Register</button>--%>

<a href="/goto-register.jsp">for registration</a>

</body>
</html>

