
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>board list</title>
    <table>

        <colgroup>
            <col style="width:5%;"/>
            <col style="width:auto;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
        </colgroup>

        <thead>
        <tr>
            <th>NO</th>
            <th>글제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일</th>
        </tr>
        </thead>

        <tbody>
        <c:choose>
            <c:when test="${empty boardList }">
                <tr>
                    <td colspan="5" align="center">데이터가 없습니다.</td>
                </tr>
            </c:when>

            <c:when test="${!empty boardList}">
                <c:forEach var="list" items="${boardList}">
                    <tr>
                        <td><c:out value="${list.postIdx}"/></td>
                        <td><c:out value="${list.postName}"/></td>
                        <td><c:out value="${list.postWriter}"/></td>
                        <td><c:out value="${list.postView}"/></td>
                        <td><c:out value="${list.postDate}"/></td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
        </tbody>

    </table>

</head>
<body>

</body>
</html>
