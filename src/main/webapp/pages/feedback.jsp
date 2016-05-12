<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 11.05.16
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FeedBack</title>
</head>
<body>
<form:form method="post" commandName="ca">

<table>
    <tr>
        <td>${questionText}</td>
        <td>
            <form:checkboxes path="answers" items="${answersList}"/>
        </td>
    </tr>
</table>

</form:form>
</body>
</html>
