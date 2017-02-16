<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update User</title>
</head>
<body>
<tag:welcomeMessage></tag:welcomeMessage>

<tag:navbar></tag:navbar>
<br>

<c:choose>
    <c:when test="${pageContext.request.isUserInRole('admin') == true}">
        <tag:UserUpdate></tag:UserUpdate>
    </c:when>
</c:choose>
</body>
</html>
