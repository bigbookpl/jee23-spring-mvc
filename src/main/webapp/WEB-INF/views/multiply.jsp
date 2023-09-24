<%--
  Created by IntelliJ IDEA.
  User: bigbook
  Date: 02/04/2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="i" begin="1" end="${size}">
        <tr style="${i == 1 ? 'background-color: grey':'background-color: white'}">
            <c:forEach var="j" begin="1" end="${size}">
                <td style="${i == 1 ? 'background-color: grey':'background-color: white'}">
                        ${i * j}
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
