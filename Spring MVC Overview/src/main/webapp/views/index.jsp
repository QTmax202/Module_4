<%--
  Created by IntelliJ IDEA.
  User: QT-247202
  Date: 17/02/2022
  Time: 10:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/currency/conversion" method="post">
    <input type="text" name="exchange_rate" placeholder="ty gia">
    <input type="text" name="usd" placeholder="USD">
    <button type="submit">sub</button>
  </form>
  <h2>
    <fmt:setLocale value="vi_VN"/>
    <fmt:formatNumber value="${vnd}" type="currency"/>
  </h2>
  </body>
</html>
