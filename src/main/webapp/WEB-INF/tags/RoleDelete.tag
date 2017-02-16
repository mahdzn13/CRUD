<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="roleDelSuccessful" value="${requestScope['roleDelSuccessful']}"/>

<c:choose>
    <c:when test="${roleDelSuccessful != null}">
        <p>Role deleted succesfully: <span style="color: #0186ff"><c:out value="${roleDelSuccessful}"/></span><p>
    </c:when>
</c:choose>

<h2>Delete role</h2>
<form action="RoleDeleteController" method="post">
    <label>Nombre:</label>
    <input type="text" name="roleNameDelete">
    <input type="submit">
</form>