<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<hr/>
<sec:authorize access="isAuthenticated()">
    Logged in as: <sec:authentication property="principal.username"/>
    <sf:form action="/logout" method="POST">
        <input type="submit" name="logout" value="Logout" />
    </sf:form>
</sec:authorize>
Copyright &copy; Craig Walls