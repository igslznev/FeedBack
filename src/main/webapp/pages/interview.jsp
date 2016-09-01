<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Interview</title>

    <script src="<c:url value="/resources/jquery-2.1.4.min.js"/> "></script>
    <script src="<c:url value="/resources/webshim/js-webshim/minified/polyfiller.js"/> "></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>

    <script>
        webshims.setOptions('forms', {
            addValidators: true,
            customMessages: true,
            replaceValidationUI: true
        });

        //start polyfilling
        webshims.polyfill('forms');
    </script>

</head>
<body>

<div class="hero-unit">
    <h1>${interview.getTitle()}</h1>
    <h4>${interview.getDescription()}</h4>
</div>

    <div class="container">
    <form id="questionsForm" method="post" action="/registerAnswer?id=${interview.getIdInterview()}"
          onsubmit="return validateForm();">

    <c:forEach items="${interview.getQuestions()}" var="question">
        <br>
        <b>${question.getQuestion()}
        <c:if test="${question.isRequired()}"> *</c:if>
        </b>
        <br>
        <c:choose>
            <c:when test="${question.getType().getIdType() == 1}">
                <c:forEach items="${question.getVariants()}" var="variant">
                    <input type="checkbox" name="answer-${question.getIdQuestion()}"
                           value="${variant.getVariant()}"
                            <c:if test="${question.isRequired()}">
                                data-grouprequired=""
                            </c:if>
                           data-errormessage="Please check on this group"/>${variant.getVariant()}<br>
                </c:forEach>
            </c:when>

            <c:when test="${question.getType().getIdType() == 2}">
                <c:forEach items="${question.getVariants()}" var="variant">
                    <input type="radio" name="answer-${question.getIdQuestion()}"
                                 value="${variant.getVariant()}"
                                 <c:if test="${question.isRequired()}">
                                     required
                                 </c:if>/>${variant.getVariant()}<br>
                </c:forEach>
            </c:when>

            <c:when test="${question.getType().getIdType() == 3}">
                <input type="text" name="answer-${question.getIdQuestion()}"
                       data-errormessage="Fill this field!"
                        <c:if test="${question.isRequired()}">
                            required
                        </c:if>/>
            </c:when>
        </c:choose>
    </c:forEach>
    <br>
    <p><input class="btn btn-primary" type="submit" value="Submit"/>
    </p>

    </form>
    </div>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">

</body>
</html>
