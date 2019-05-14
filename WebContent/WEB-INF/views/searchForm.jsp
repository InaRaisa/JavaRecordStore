<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="_head.jsp">
    <jsp:param name="title" value="SearchForm" />
</jsp:include>
<body>
	<form method="get" action="search">
    	<label>
        	Name of artist or album: 
        	<input type="text" name="keyword" />
    	</label>
    	<input type="submit" value="Search" />
	</form>
</body>
</html>