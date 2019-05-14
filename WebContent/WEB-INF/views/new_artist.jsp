<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="_head.jsp">
    <jsp:param name="title" value="New Artist" />
</jsp:include>
<body>
	<h1>Create a new artist</h1>
	<c:if test="${ error != null }">
		<p>
			Error:
			<c:out value="${ error }" />
		</p>
	</c:if>

	<form method="post">
		<label> Name: <input name="artistName" />
		</label> <input type="submit" value="Save" />
	</form>
</body>
</html>