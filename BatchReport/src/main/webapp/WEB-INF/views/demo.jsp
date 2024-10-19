<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
        <h1>Hello</h1>

        <table border="1px">
            <c:forEach var="batch" items="${AllBatch}">
                <tr>
                    <td>${batch.batch_id}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
