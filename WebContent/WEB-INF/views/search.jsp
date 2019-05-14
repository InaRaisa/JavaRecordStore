<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="_head.jsp">
	<jsp:param name="title" value="Search" />
</jsp:include>
<body>
	<h1>Search</h1>

	<jsp:include page="searchForm.jsp" />

	<ul>
		<c:forEach var="album" items="${ albums }">
			<h2>Albums:</h2>
			<li><a href="album?id=${ album.getId() }"> <c:out
						value="${ album.getTitle() }" />
			</a></li>
		</c:forEach>
		<c:forEach var="artist" items="${ artists }">
			<h2>Artists:</h2>
			<li><a href="artist?id=${ artist.getId() }"> <c:out
						value="${ artist.getName() }" />
			</a></li>
		</c:forEach>
	</ul>
</body>
</html>