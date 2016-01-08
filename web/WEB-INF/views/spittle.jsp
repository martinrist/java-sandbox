<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<jsp:useBean id="spittle" scope="request" type="com.martinrist.springInAction.spittr.domain.Spittle"/>
<div class="spittleMessage"><c:out value="${spittle.message}"/></div>
<div>
    <span class="spittleTime"><c:out value="${spittle.time}" /></span>
    <span class="spittleLocation">
        (<c:out value="${spittle.latitude}" />,
        <c:out value="${spittle.longitude}" />)
    </span>
</div>