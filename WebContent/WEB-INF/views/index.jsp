<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<jsp:include page="_head.jsp">
    <jsp:param name="title" value="RecordStore / All Artists" />
</jsp:include>
<body>
	
	<h1>Welcome</h1>
	
	<form method="get" action="search">
		<input type="text" name="keyword">
		<input type="submit" value="Search">
	</form>
	
	<ul>
		<c:forEach var="artist" items="${ artists }">
			<li><a href="artist?id=${ artist.getId() }"> <c:out
						value="${ artist.getName() }" />
			</a></li>
		</c:forEach>
	</ul>

</body>
</html>