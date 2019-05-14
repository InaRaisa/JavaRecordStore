<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
    <!-- HTML style comment -->
    <!-- Reads the parameter "firstname" and displays it safely: -->
    <h1>Hello <c:out value="${ param.firstname }" /></h1>

    <%-- JSP style comment (not rendered in the HTML page) --%>
    <%-- Calculates the sum and displays the result: --%>
    <h2>${ 1 + 2 + 3 + 4 + 5 }</h2>
</body>
</html>