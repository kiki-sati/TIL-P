<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
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

        // 게시판 이동
        $(document).ready(function () {
            $("#btnList").click(function () {
                location.href = "/board/list";
            });
            
        // 수정페이지 이동
            $("#btnUpdate").click(function () {
                location.href = "/board/update?postIdx=${boardContent.postIdx}";
            });
        
        // 삭제
            $('#btnDelete').click(function(){
                if(confirm('삭제하시면 복구할수 없습니다. \n 정말로 삭제하시겠습니까??')){
                	location.href = "/delete?postIdx=${boardContent.postIdx}";
                }
            })
        })

    </script>

</head>
<body>
	<article>
		<div class="container" role="main">
			<h2>게시물 내용</h2>
			<div class="bg-white rounded shadow-sm">
				<div class="board_title">
					<c:out value="${boardContent.postName}" />
				</div>
				<div class="board_info_box">
					<span class="board_author"> <c:out value="${boardContent.postWriter}" />
					</span> <span class="board_date"> <c:out value="${boardContent.postDate}" />
					</span> <span class="board_editDate"> <c:out value="${boardContent.editDate}" />
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
		<%@ include file="/WEB-INF/views/board/comment.jsp"%>
	</article>
	
</body>
</html>