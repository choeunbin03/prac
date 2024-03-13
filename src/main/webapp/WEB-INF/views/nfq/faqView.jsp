<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>

	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">


	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/nfq.js" type="text/javascript" defer="defer"></script>
	<script src="${path}/resources/js/sideBar.js" type="text/javascript" defer="defer"></script>
	<script src="${path}/resources/js/bookmark.js" type="text/javascript" defer="defer"></script>

<!-- <meta charset="UTF-8"> -->
	
</head>
<body>
	
	<%@ include file="../popup/popup.jsp" %>
	<%@ include file="../module/header.jsp" %>
	<div class="content">
	<%@ include file="../module/side.jsp" %>

	<div id="nfqContent">
	<form id="frm">
		<input type="hidden" value="${view.nfqSeq}" name="nfqSeq" id="nfqSeq">
		
	<!-- <button type="button" onclick='fn_bookmark()'>즐겨찾기 저장</button> -->	
		<button type="button" id="btnBmk">즐겨찾기 저장</button>
		
		<div>제목 : ${view.nfqTtl}</div>
		<div>작성자 : ${view.rgtrId}</div>
		<div>등록일 : ${view.rgtrDt}</div>
		<div>최종수정일 : ${view.mdfrDt}</div>
		<div>Q. : ${view.qstnCn}</div>
		<div>A. : ${view.ansCn}</div>
	
		<button type="button" onclick='fn_goBackPg()'>목록</button>
		<button type="button" onclick="fn_nfqDelete(${view.nfqSeq})">삭제</button>
		
	</form>

</div><!-- //nfq_content -->
</div><!-- //content -->


<%@ include file="../module/footer.jsp" %>

<script src="${path}/resources/js/bookmark.js"></script>

