<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="userDelSuccessful" value="${requestScope['userDelSuccessful']}"/>

<c:choose>
    <c:when test="${userDelSuccessful != null}">
        <p>User deleted successfully: <span style="color: #0186ff"><c:out value="${userDelSuccessful}"/></span><p>
    </c:when>
</c:choose>

<h2>Delete User</h2>
<form action="UserDeleteController" method="post">
    <label>Nombre:</label>
    <input type="text" name="nameDelete">
    <input type="submit">
</form>