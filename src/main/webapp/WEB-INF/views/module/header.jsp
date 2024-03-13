<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Begin Wrapper -->
	<div id="wrapper">

		<!-- Begin Header -->
		<div id="header">
		     코딩 연습
			<a href="/board/list">자유게시판</a>
			<a href="/nfq/list?nfqType=1">공지사항</a>
			<a href="/nfq/list?nfqType=3">Q&A</a>
			<a href="/nfq/list?nfqType=2">FAQ</a>
			<button type="button" onclick='location.href="/member/logout"'>로그아웃</button>
			
			

<%-- <form action="<%=request.getContextPath()%>/login/login_pro.jsp" method="post">
아이디 : <input type = "text" name = "id">
비 번 : <input type = "text" name = "pw">
<input type ="submit" value = "로그인">
</form>
 --%>
		   
	 </div>
	 <!-- End Header -->