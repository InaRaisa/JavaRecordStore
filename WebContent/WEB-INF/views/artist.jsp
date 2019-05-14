<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<jsp:include page="_head.jsp">
	<jsp:param name="title" value="${ artist.getName() }" />
</jsp:include>

<body>
	<h1>
		<c:out value="${ artist.getName() } " />
	</h1>
	<h2>Albums:</h2>
	<ul>
		<c:forEach items="${ albums }" var="album">
			<li><c:out value="${ album.getTitle() }" /></li>
		</c:forEach>
	</ul>

</body>
</html>