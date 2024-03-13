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
<script src="${path}/resources/js/sideBar.js" type="text/javascript" defer="defer"></script>

<!-- <meta charset="UTF-8"> -->
	
</head>
<body>

<%@ include file="../popup/popup.jsp" %>
<%@ include file="../module/header.jsp" %>
<div class="content">
<%@ include file="../module/side.jsp" %>

<form id="frm">
	<input type="hidden" value="${view.bbsSeq}" name="bbsSeq" id="bbsSeq">
	제목 : <input type="text" placeholder="제목" id="bbsTtl" name="bbsTtl" value="${view.bbsTtl}">
	작성자 : <input type="text" placeholder="작성자" id="rgtrId" name="rgtrId" readonly="readonly" value="${view.rgtrId}">
	<div class="boardUpdateCheck"><input type="checkbox" name="chkboxBoardUpdate" value="checkbox" id="chkboxBoardUpdate">
    	<label for="chkboxBoardUpdate" class="boardUpdateAnnymtBox">&nbsp;익명</label>
    </div>
	<div>내용 : <input type="text" placeholder="내용" id="bbsCn" name="bbsCn" value="${view.bbsCn}"></div>
	<button type="button" onclick="fn_boardUpdate();">등록</button>
	<button type="button" onclick='fn_goBackPg()'>취소</button>
</form>

</div>
<%@ include file="../module/footer.jsp" %>