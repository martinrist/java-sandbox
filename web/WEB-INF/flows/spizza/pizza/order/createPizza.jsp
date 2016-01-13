<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head><title>Spring Pizza</title></head>
    <body>
        <h2>Create Pizza</h2>
        
        <form:form commandName="pizza">
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
            <b>Size: </b><br/>
            <form:radiobutton path="size" label="Small (12-inch)" value="SMALL"/><br/>
            <form:radiobutton path="size" label="Medium (14-inch)" value="MEDIUM"/><br/>
            <form:radiobutton path="size" label="Large (16-inch)" value="LARGE"/><br/>
            <form:radiobutton path="size" label="Extra Large (20-inch)" value="EXTRA_LARGE"/><br/>
            <br/>
            <br/>
            <b>Toppings: </b><br/>
            <form:checkboxes path="toppings" items="${toppingsList}" delimiter="<br/>"/><br/><br/>
            <input type="submit" class="button" name="_eventId_addPizza" value="Continue"/>
            <input type="submit" class="button" name="_eventId_cancel" value="Cancel"/>
        </form:form>

    </body>

</html>