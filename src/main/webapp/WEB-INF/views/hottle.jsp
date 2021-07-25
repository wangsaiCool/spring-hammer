<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Hotter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="hottleView">
      <div class="hottleMessage"><c:out value="${hottle.message}" /></div>
      <div>
        <span class="hottleTime"><c:out value="${hottle.time}" /></span>
      </div>
    </div>
  </body>
</html>