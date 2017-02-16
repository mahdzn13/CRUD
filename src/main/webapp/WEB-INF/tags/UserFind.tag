<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="user" value="${requestScope['userFound']}"/>

<c:choose>
    <c:when test="${user != null}">
        <p>User found: <span style="color: #0186ff"><c:out value="${user}"/></span><p>
    </c:when>
    <c:otherwise>
        <p><span style="color: red"><c:out value="${requestScope['errorFindNotFound']}"/></span><p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${requestScope['roleListFound'] != null}">
        <table>
            <tr>
                <th>Roles</th>
            </tr>
            <c:forEach items="${requestScope['roleListFound']}" var="roleFound">
                <tr>
                    <td><c:out value="${roleFound.getRoleName()}"/></td>
                </tr>
            </c:forEach>

        </table>
    </c:when>
</c:choose>

<h2>Find user</h2>
<form action="UserFindController" method="post">
    <label>Nombre:</label>
    <input type="text" name="name">
    <input type="checkbox" name="fillRole">Fill roles
    <input type="submit">
</form>
