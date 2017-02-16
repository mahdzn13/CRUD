<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${requestScope['userList'] != null}">
        <table>
            <tr>
                <th>Username List</th>
            </tr>
            <c:forEach items="${requestScope['userList']}" var="user">
                <tr>
                    <td><c:out value="${user.getName()}"/></td>
                    <c:choose>
                        <c:when test="${pageContext.request.isUserInRole('admin') == true}">
                            <td><form action="userUpdate.jsp" method="get"><button type="submit" name="nameUpdate" value="${user.getName()}">Edit</button></form></td>
                            <td><form action="UserDeleteController" method="post"><button type="submit" name="nameDelete" value="${user.getName()}">Delete</button></form></td>
                        </c:when>
                    </c:choose>

                </tr>
            </c:forEach>

        </table>
    </c:when>
</c:choose>
<form action="UserShowAllController">
    <input type="submit" value="Show users">
</form>