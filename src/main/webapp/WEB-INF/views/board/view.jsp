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
<script src="${path}/resources/js/board.js" type="text/javascript" defer="defer"></script>
<script src="${path}/resources/js/cmnt.js" type="text/javascript" defer="defer"></script>
<!-- <script src="script/jquery-1.12.3.js" type="text/javascript"></script> 
          위와 같은 스크립트 태그는 </body>위에 작성.(defer을 쓰지 않을 때도 동일)-->
<script src="${path}/resources/js/sideBar.js" type="text/javascript" defer="defer"></script>
<script src="${path}/resources/js/bookmark.js" type="text/javascript" defer="defer"></script>

<!-- <meta charset="UTF-8"> -->
	
</head>
<body>

<%@ include file="../popup/popup.jsp" %>
<%@ include file="../module/header.jsp" %>
<div class="content">
<%@ include file="../module/side.jsp" %>
<div id="bbsContent">

<form id="frm">
	<input type="hidden" value="${view.bbsSeq}" name="bbsSeq" id="bbsSeq">
	
	<button type="button" onclick='fn_bookmark()'>즐겨찾기 저장</button>	
	<!-- <button type="button" id="btnBmk">즐겨찾기 저장</button> -->
	
	<div>제목 : ${view.bbsTtl}</div>
	<div>작성자 : ${view.rgtrId}</div>
	<div>등록일 : ${view.rgtrDt}</div>
	<div>최종수정일 : ${view.mdfrDt}</div>
	<div>조회수 : ${view.bbsInqCnt}</div>
	<div>좋아요 : ${view.bbsSpt}</div>
	<div>내용 : ${view.bbsCn}</div>

	<button type="button" value="좋아요" onclick='fn_updateBbsSpt(${view.bbsSeq})'></button>
	<button type="button" onclick='fn_goBackPg()'>목록</button>
	<button type="button" onclick='fn_goUpdateView(${view.bbsSeq})'>수정</button>
	<button type="button" onclick='fn_boardDelete(${view.bbsSeq})'>삭제</button>
	
	
	<%@ include file="../comment/commentList.jsp" %>
	<%@ include file="../comment/regiCmnt.jsp" %>
</form>

</div><!-- bbsContent -->
</div><!-- content -->


<%@ include file="../module/footer.jsp" %>

<script src="${path}/resources/js/bookmark.js"></script>

