<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<jsp:useBean id="spitter" scope="request" type="com.martinrist.springInAction.spittr.domain.Spitter"/>
<h1>Your Profile</h1>
<c:out value="${spitter.username}" /><br/>
<c:out value="${spitter.firstName}"/> <c:out value="${spitter.lastName}"/>