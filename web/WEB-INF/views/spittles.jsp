<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<jsp:useBean id="spittleList" scope="request" type="java.util.List"/>
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