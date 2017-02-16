<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <c:choose>
            <c:when test="${pageContext.request.isUserInRole('admin') == true}">
                <li><a href="formOptions.jsp">Form Options</a></li>
            </c:when>
        </c:choose>
        <li><a href="tableShow.jsp">Lists</a></li>
        <li><a href="logout.jsp">Logout</a></li>
    </ul>
</nav>
