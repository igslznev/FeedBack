<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FeedBack</title>
    <script src="<c:url value="/resources/jquery-2.1.4.min.js"/> "></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>

<div class="container">
    <h1>Choose one of the interviews!</h1>
</div>

<div class="container">
    <c:choose>
        <c:when test="${interviews.isEmpty()}">There is no interview!</c:when>
        <c:otherwise>
            <c:forEach items="${interviews}" var="interview">
                <p><a href="/interviews?id=${interview.getIdInterview()}">${interview.getTitle()}</a></p>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>

    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">

</body>
</html>
