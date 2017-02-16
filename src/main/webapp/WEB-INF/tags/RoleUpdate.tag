<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="RoleUpdateController" method="POST">

    <input type="hidden" name="oldRole" value="<%= request.getParameter("roleNameUpdate") %>">

    <h4>Actual rol</h4>
    <p><%= request.getParameter("roleNameUpdate") %>"</p>

    <label>New rol</label>
    <input type="text" name="newRole" value="">

    <input type="submit">
</form>
