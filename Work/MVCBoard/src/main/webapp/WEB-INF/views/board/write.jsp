<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<title>Insert title here</title>

<script>
	$(document).on('click', '#btnSave', function(e) {
		e.preventDefault();
		$("#form").submit();
	});
	// 게시판 이동
	$(document).ready(function() {
		$("#btnList").click(function() {
			location.href = "/board/list";
		});
		$('#postContent').on('keyup', function() {
			$('#count').html("(" + $(this).val().length + " / 1000)");
			if ($(this).val().length > 1000) {
				$(this).val($(this).val().substring(0, 1000));
				$('#count').html("(1000 / 1000)");
			}
		});
	});
</script>

</head>
<body>
	<article>

		<div class="container" role="main">

			<h2>Board Form</h2>

			<form name="form" id="form" role="form" method="post" action="/board/write">
				<div class="mb-3">
					<label for="postName">제목</label> <input type="text" class="form-control" name="postName" id="postName" placeholder="제목을 입력해 주세요" maxlength="70">
				</div>
				<div class="mb-3">
					<label for="postWriter">닉네임</label> <input type="text" class="form-control" name="postWriter" id="postWriter" placeholder="닉네임을 입력해 주세요" maxlength="20">
				</div>

				<div class="mb-3">
					<label for="postContent">내용</label>
					<textarea class="form-control" rows="5" name="postContent" id="postContent" placeholder="내용을 입력해 주세요"></textarea>
				</div>

			</form>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
			<div>
				<div id="count">(0/1000)</div>
			</div>
		</div>
	</article>
</body>
</html>