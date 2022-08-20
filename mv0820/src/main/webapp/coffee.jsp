<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coffee Data</title>
</head>
<body>
  <table border="1" width="70%">
            <c:forEach var="c"   items="${coffees}">
                <tr>
                     <td>
                         <c:out value="${c.cofName}"/></td>
                     <td>
                          <c:out value="${c.supId}"/></td>
                      <td>
                          <c:out value="${c.price}"/></td>
                       <td>
                          <c:out value="${c.sales}"/></td>
                        <td>
                          <c:out value="${c.total}"/></td>
                  </tr>
                </c:forEach>
    </table>
</body>
</html>