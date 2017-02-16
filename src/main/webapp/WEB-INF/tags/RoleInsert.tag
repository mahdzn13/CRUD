<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="roleAddSuccessful" value="${requestScope['roleAddSuccessful']}"/>

<c:choose>
    <c:when test="${roleAddSuccessful != null}">
        <p>Role created successfully: <span style="color: #0186ff"><c:out value="${roleAddSuccessful}"/></span><p>
    </c:when>
</c:choose>

<h2>Insert role</h2>
<form action="RoleInsertController" method="post">
    <label>Nombre:</label>
    <input type="text" name="rolename">
    <label>Descripcion:</label>
    <input type="text" name="roledesc">
    <input type="submit">
</form>