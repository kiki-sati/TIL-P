<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/WEB-INF/views/layout/header.jsp" %>
    <title>Insert title here</title>
    <script>
        // 제일 별로인 코드
        // $(document)
        // 			.on(
        // 					'click',
        // 					'#btnList',
        // 					function() {
        // 						location.href = "/board";
        // 					});

        $(document).ready(function () {
            $("#btnList").click(function () {
                location.href = "/board";
            });
        })

        $(document).ready(function () {
            $("#btnUpdate").click(function () {
                location.href = "/getBoardContent?postIdx=" + idx;
            });
        })
    </script>

</head>
<body>
<article>
    <div class="container" role="main">
        <h2>게시물 내용</h2>
        <div class="bg-white rounded shadow-sm">
            <div class="board_title">
                <c:out value="${boardContent.postName}"/>
            </div>
            <div class="board_info_box">
					<span class="board_author">
					<c:out value="${boardContent.postWriter}"/>
					</span>
                <span class="board_date">
					<c:out value="${boardContent.postDate}"/>
					</span>
            </div>
            <div class="board_content">${boardContent.postContent}</div>
        </div>

        <div style="margin-top: 20px">
            <button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
            <button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
            <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
        </div>
    </div>
</article>
</body>
</html>