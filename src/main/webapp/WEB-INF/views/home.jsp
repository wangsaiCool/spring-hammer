<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Hotter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Welcome to Hotter</h1>

    <a href="<c:url value="/hottles" />">Spittles</a> |
    <a href="<c:url value="/hottles/register" />">Register</a>
  </body>
</html>
