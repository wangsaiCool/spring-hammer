<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>Hotter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="hottleForm">
      <h1>Hot it out...</h1>
      <form method="POST" name="hottleForm">
        <input type="hidden" name="latitude">
        <input type="hidden" name="longitude">
        <textarea name="message" cols="80" rows="5"></textarea><br/>
        <input type="submit" value="Add" />
      </form>
    </div>
    <div class="listTitle">
      <h1>Recent Hottles</h1>
      <ul class="hottleList">
        <c:forEach items="${hottleList}" var="hottle" >
          <li id="spittle_<c:out value="hottle.id"/>">
            <div class="hottleMessage"><c:out value="${hottle.message}" /></div>
            <div>
              <span class="hottleTime"><c:out value="${hottle.time}" /></span>
              <span class="hottleLocation">(<c:out value="${hottle.latitude}" />, <c:out value="${hottle.longitude}" />)</span>
            </div>
          </li>
        </c:forEach>
      </ul>
      <c:if test="${fn:length(hottleList) gt 20}">
        <hr />
        <s:url value="/hottle?count=${nextCount}" var="more_url" />
        <a href="${more_url}">Show more</a>
      </c:if>
    </div>
  </body>
</html>