<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Hotter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Your Profile</h1>
    <c:out value="${hotter.username}" /><br/>
    <c:out value="${hotter.firstName}" /> <c:out value="${hotter.lastName}" /><br/>
    <c:out value="${hotter.email}" />
  </body>
</html>
