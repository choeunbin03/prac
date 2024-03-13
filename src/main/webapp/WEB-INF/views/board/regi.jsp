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
<!-- <script src="script/jquery-1.12.3.js" type="text/javascript"></script> 
          위와 같은 스크립트 태그는 </body>위에 작성.(defer을 쓰지 않을 때도 동일)-->
<script src="${path}/resources/js/sideBar.js" type="text/javascript" defer="defer"></script>

<!-- <meta charset="UTF-8"> -->
	
</head>
<body>


<%@ include file="../popup/popup.jsp" %>
<%@ include file="../module/header.jsp" %>
<div class="content">
<%@ include file="../module/side.jsp" %>

<form id="frm" enctype="multipart/form-data">
	<input type="text" placeholder="제목" id="bbsTtl" name="bbsTtl">
	<input type="text" placeholder="작성자" id="rgtrId" name="rgtrId" value="${sessionScope.sessionId}" readonly="readonly">
	<div class="boardRegiCheck"><input type="checkbox" name="chkboxBoardRegi" value="checkbox" id="chkboxBoardRegi">
    	<label for="chkboxBoardRegi" class="boardRegiAnnymtBox">&nbsp;익명</label>
    </div>
	<input type="text" placeholder="내용" rows="5" cols="100" id="bbsCn" name="bbsCn">
	
	<div class="atchFile">
		<p>첨부파일</p><p>   파일은 최대 10개까지 첨부하실 수 있습니다</p>
		<input type="file" name="atchFile" />
	</div>
	
	<button type="button" onclick="fn_boardRegi();">등록</button>
	<button type="button" onclick='fn_goBackPg()'>취소</button>
</form>

</div>
<%@ include file="../module/footer.jsp" %>