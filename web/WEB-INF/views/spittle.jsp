<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    <jsp:useBean id="spittle" scope="request" type="com.martinrist.springInAction.spittr.domain.Spittle"/>
</head>
<body>
    <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
    <div>
        <span class="spittleTime"><c:out value="${spittle.time}" /></span>
        <span class="spittleLocation">
            (<c:out value="${spittle.latitude}" />,
            <c:out value="${spittle.longitude}" />)
        </span>
    </div>
</body>
</html>
