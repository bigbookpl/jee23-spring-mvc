<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Formularz</h1>

<form action="/first/form" method="post">
    ParamName: <input type="text" name="paramName"/>
    ParamDate: <input type="text" name="paramDate"/>
    <input type="submit">
</form>

</body>
</html>
