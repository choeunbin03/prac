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

<form id="frm">
	<input type="hidden" value="3" name="nfqType" id="nfqType">
	<input type="hidden" value="" name="ansCn" id="ansCn">
	<input type="hidden" value="N" name="ansYn" id="ansYn">

	<input type="text" placeholder="질문제목" id="nfqTtl" name="nfqTtl">
	<input type="text" placeholder="작성자" id="rgtrId" name="rgtrId" value="${sessionScope.sessionId}" readonly="readonly">
	<input type="text" placeholder="질문내용" rows="5" cols="100" id="qstnCn" name="qstnCn">
	<button type="button" onclick="fn_regi();">등록</button>
	<button type="button" onclick='fn_goBackPg()'>취소</button>
</form>

</div>
<%@ include file="../module/footer.jsp" %>