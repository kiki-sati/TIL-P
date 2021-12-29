<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<!doctype html>
<html lang="en">
<head>
<title>Board</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/css/style.css">
<script>
	$(document).on('click', '#btnWriteForm', function(e){
		e.preventDefault();
		location.href = "/board/boardForm";
	});
	
	function fn_contentView(idx) {
		location.href = "/getBoardContent?postIdx=" + idx;
	}
	
</script>

</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">게시판 리스트</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th>no</th>
									<th>글제목</th>
									<th>작성자</th>
									<th>조회수</th>
									<th>작성일</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty boardList}">
										<tr>
											<td colspan="5" align="center">데이터가 없습니다.</td>
										</tr>
									</c:when>
									<c:when test="${!empty boardList}">
										<c:forEach var="list" items="${boardList}">
											<tr class="alert" role="alert">
												<th scope="row"><c:out value="${list.postIdx}" /></th>
												<td onClick="fn_contentView('${list.postIdx}');"><c:out value="${list.postName}" /></td>
												<td onClick="fn_contentView('${list.postIdx}');"><c:out value="${list.postWriter}" /></td>
												<td onClick="fn_contentView('${list.postIdx}');"><c:out value="${list.postView}" /></td>
												<td onClick="fn_contentView('${list.postIdx}');"><c:out value="${list.postDate}" /></td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>
							</tbody>
						</table>
						<div>
							<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>

