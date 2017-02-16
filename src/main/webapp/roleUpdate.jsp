<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Update rol</title>
</head>
<body>
<tag:welcomeMessage></tag:welcomeMessage>

<tag:navbar></tag:navbar>
<br>
<c:choose>
    <c:when test="${pageContext.request.isUserInRole('admin') == true}">
        <tag:RoleUpdate></tag:RoleUpdate>
    </c:when>
</c:choose>
</body>
</html>
