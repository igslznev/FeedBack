<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FeedBack</title>
</head>
<body>

    <c:choose>
        <c:when test="${interviews.isEmpty()}">There is no interview!</c:when>
        <c:otherwise>
            <c:forEach items="${interviews}" var="interview">
                <a href="/interview?id=${interview.getIdInterview()}">${interview.getTitle()}</a>
                <br>
            </c:forEach>
        </c:otherwise>
    </c:choose>

</body>
</html>
