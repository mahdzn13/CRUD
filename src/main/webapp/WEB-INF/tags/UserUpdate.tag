<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="UserUpdateController" method="POST">

    <input type="hidden" name="oldName" value="<%= request.getParameter("nameUpdate") %>">

    <h4>Actual name</h4>
    <p> <%= request.getParameter("nameUpdate") %> </p>

    <label>New name</label>
    <input type="text" name="newName" value="">

    <input type="submit">
</form>