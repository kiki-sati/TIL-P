<!-- 실질적인 로그인 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %> <!-- 자바스크립트 문장을 작성하기 위해 --> 
<% request.setCharacterEncoding("utf-8"); %> <!-- 넘어오는 모든 파일 인코딩 설정 -->
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>JSP 웹 사이트 게시판</title>
</head>
<body>
	<% 
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		if(result == 1) { //결과에 대한 값들이 result에 담긴다. 
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		} else if(result == 0) { // 비밀번호가 틀린 경우 
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()"); // 이전 페이지 이동 
			script.println("</script>");
		} else if(result == -1) { // 아이디가 존재하지 않는 경우 
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디 입니다. ')");
			script.println("history.back()"); // 이전 페이지 이동 
			script.println("</script>");
		} else if(result == -2) { // 데이터베이스 오류 
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다. ')");
			script.println("history.back()"); // 이전 페이지 이동 
			script.println("</script>");
		}
	%>
</body>
</html>