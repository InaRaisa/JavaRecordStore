<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<jsp:include page="_head.jsp">
    <jsp:param name="title" value="${ album.getTitle() }" />
</jsp:include>

<body>
	<h1>
		<c:out value="${ artist.getName() }" />: 
		<c:out value="${ album.getTitle() } " />
	</h1>
	<table>
		<tr>
			<th>Track Name</th>
		</tr>
		<c:forEach items="${ tracks }" var="track">
			<tr>
				<td><c:out value="${ track.getName() }" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>