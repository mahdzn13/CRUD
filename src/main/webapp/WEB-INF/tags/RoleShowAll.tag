<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${requestScope['roleList'] != null}">
        <table>
            <tr>
                <th>Role List</th>
            </tr>
            <c:forEach items="${requestScope['roleList']}" var="role">
                <tr>
                    <td><c:out value="${role.getRoleName()}"/></td>
                    <c:choose>
                        <c:when test="${pageContext.request.isUserInRole('admin') == true}">
                            <td><form action="roleUpdate.jsp" method="get"><button type="submit" name="roleNameUpdate" value="${role.getRoleName()}">Edit</button></form></td>
                            <td><form action="RoleDeleteController" method="post"><button type="submit" name="roleNameDelete" value="${role.getRoleName()}">Delete</button></form></td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>

        </table>
    </c:when>
</c:choose>
<form action="RoleShowAllController">
    <input type="submit" value="Show roles">
</form>