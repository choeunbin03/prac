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

	<div class="nfqContent">
	
		<form id="frm">
			<input type="hidden" value="1" name="nfqType" id="nfqType">
			<input type="hidden" value="관리자" name="rgtrId" id="rgtrId">
			<input type="hidden" value="Y" name="ansYn" id="ansYn">
		
			<input type="text" placeholder="제목" id="nfqTtl" name="nfqTtl">
			<input type="text" placeholder="내용" rows="5" cols="100" id="qstnCn" name="qstnCn">
			<input type="text" placeholder="내용" rows="5" cols="100" id="ansCn" name="ansCn">
			<button type="button" onclick="fn_regi();">등록</button>
			<button type="button" onclick='fn_goBackPg()'>취소</button>
		</form>
	
	
	</div><!-- nfqContent -->

</div><!-- content -->
<%@ include file="../module/footer.jsp" %>