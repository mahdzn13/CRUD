<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
    <c:when test="${pageContext.request.isUserInRole('admin') == true}">
        <h1>Welcome Master,  <% out.print(request.getUserPrincipal().getName()); %></h1>
    </c:when>
    <c:otherwise>
        <h1>Welcome back,  <% out.print(request.getUserPrincipal().getName()); %></h1>
    </c:otherwise>
</c:choose>