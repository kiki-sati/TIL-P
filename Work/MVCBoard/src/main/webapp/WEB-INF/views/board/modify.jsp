<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/WEB-INF/views/layout/header.jsp"%>
    <title>Insert title here</title>

    <script>
        $(document).on('click', '#btnSave', function (e) {
            e.preventDefault();
            $("#form").submit();
            
            
        });
        
    	function fn_contentView() {
    		location.href = "/getBoardContent?postIdx=${boardContent.postIdx}";
    	}
    </script>

</head>
<body>

<article>

    <div class="container" role="main">

        <h2>Board Form</h2>

        <form name="form" id="form" role="form" method="post" action="/board/update">
            <input type="hidden" name="postIdx" id="postIdx" value="<c:out value="${boardContent.postIdx}" />">
            <div class="mb-3">
                <label for="postName">제목</label>
                <input type="text" class="form-control" name="postName" id="postName" value="<c:out value="${boardContent.postName}" />">
            </div>
            <div class="mb-3">
                <label for="postWriter">닉네임</label>
                <input type="text" class="form-control" name="postWriter" id="postWriter" value="<c:out value="${boardContent.postWriter}" />">
            </div>

            <div class="mb-3">
                <label for="postContent">내용</label>
                <textarea class="form-control" rows="5" name="postContent" id="postContent"><c:out value="${boardContent.postContent}" /></textarea>
            </div>

        </form>
        <div>
            <button type="button" class="btn btn-sm btn-primary" id="btnSave">수정</button>
            <button type="button" class="btn btn-sm btn-primary" id="btnList" onclick="fn_contentView();">취소</button>
        </div>
    </div>
</article>
</body>
</html>