<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="userAddSuccessful" value="${requestScope['userAddSuccessful']}"/>

<c:choose>
    <c:when test="${userAddSuccessful != null}">
        <p>User created successfully: <span style="color: #0186ff"><c:out value="${userAddSuccessful}"/></span><p>
    </c:when>
</c:choose>

<h2>Insert User</h2>
<form action="UserInsertController" method="post">
    <label>Nombre:</label>
    <input type="text" name="name">
    <label>Contraseña:</label>
    <input type="password" name="pass">
    <label>User roles:</label>
    <select name="role" multiple>
        <c:forEach items="${requestScope['roleList']}" var="role">
            <option>
                    ${role.getRoleName()}
            </option>
        </c:forEach>
    </select>
    <input type="submit">
</form>
<form action="UserInsertController" method="get">
    <input type="submit" value="Fill roles">
</form>