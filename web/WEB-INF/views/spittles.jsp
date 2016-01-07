<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    <jsp:useBean id="spittleList" scope="request" type="java.util.List"/>
</head>
<body>
    <h1>Recent Spittles</h1>
    <ul>
        <c:forEach var="spittle" items="${spittleList}">
            <li id="spittle_<c:out value="${spittle.id}" />">
                <div class="spittleMessage">
                    <a href="spittles/<c:out value="${spittle.id}"/>"><c:out value="${spittle.message}"/></a>
                </div>
                <div>
                    <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                    <span class="spittleLocation">
                        (<c:out value="${spittle.latitude}" />,
                         <c:out value="${spittle.longitude}" />)
                    </span>
                </div>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
