<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<h1>Register</h1>
<sf:form method="POST" commandName="spitter">

    <s:hasBindErrors name="spitter">Please correct the following errors:</s:hasBindErrors>
    <sf:errors cssClass="error" element="div" path="*" /><p/>

    <sf:label path="firstName" cssErrorClass="error">First Name:</sf:label><sf:input cssErrorClass="error" path="firstName"/><sf:errors path="firstName" cssClass="error" /><br/>
    <sf:label path="lastName" cssErrorClass="error">Last Name:</sf:label><sf:input cssErrorClass="error" path="lastName"/><sf:errors path="lastName" cssClass="error" /><br/>
    <sf:label path="username" cssErrorClass="error">Username:</sf:label><sf:input cssErrorClass="error" path="username"/><sf:errors path="username" cssClass="error" /><br/>
    <sf:label path="password" cssErrorClass="error">Password:</sf:label><sf:password cssErrorClass="error" path="password"/><sf:errors path="password" cssClass="error" /><br/>
    <input type="submit" value="Register" />
</sf:form>