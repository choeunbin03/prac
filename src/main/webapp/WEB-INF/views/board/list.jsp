<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.pagination {list-style: none; float: left; padding:6px;}
	</style>

	<link rel="stylesheet" href="${path}/resources/css/bbsContent.css">
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/board.js" type="text/javascript" defer="defer"></script>
	<!-- <script src="script/jquery-1.12.3.js" type="text/javascript"></script> 
          위와 같은 스크립트 태그는 </body>위에 작성.(defer을 쓰지 않을 때도 동일)-->
	<script src="${path}/resources/js/sideBar.js" type="text/javascript" defer="defer"></script>
	
</head>
<body>

<%@ include file="../popup/popup.jsp" %>
<%@ include file="../module/header.jsp" %>
<div class="content">
<%@ include file="../module/side.jsp" %>
<div id="bbsContent">
	<!-- <input type="hidden" value="" name="bbsSeq" id="bbsSeq"> -->
	
	<br>
	<h3 align="center">자유게시판</h3>
	<br>
	<form id="srchFrm">
	<div id="searchForm">
		<input type="hidden" value="1" name="pageNum" id="pageNum">
		<input type="hidden" value="10" name="amount" id="amount">
		<select name="type" id="type">
			<option value="rgtrId">작성자</option>
			<option value="title">제목</option>
		</select>
		<input type="text" size="20" id="keyWd" name="keyWd" value="${bbsSrchDTO.keyWd }"/>&nbsp;
		<button type="button" onclick="fn_srchBbs()">검색</button>
	</div>
	</form>
	<br>
	
	<div>
		<select onchange="change(this)">
			<option value = "10" ${pageDto.amount eq 10 ? 'selected' : '' }>10개씩 보기</optoin>
			<option value = "20" ${pageDto.amount eq 20 ? 'selected' : '' }>20개씩 보기</optoin>
			<option value = "30" ${pageDto.amount eq 30 ? 'selected' : '' }>30개씩 보기</optoin>
			<option value = "40" ${pageDto.amount eq 40 ? 'selected' : '' }>40개씩 보기</optoin>
		</select>
	</div>
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>체크</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td><c:out value="${list.bbsSeq}" /></td>
					<td><input type="checkbox" name="chkboxList" value="checkbox" id="chkboxList"></td>
					<td><a href="#" onclick="fn_goView(${list.bbsSeq})">${list.bbsTtl}</a></td>
					<td><c:out value="${list.rgtrId}" /></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.rgtrDt}" /></td>
					<td><c:out value="${list.bbsInqCnt}" /></td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${list.mdfrDt}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<h6>현재페이지 ${pageDto.pageNum } / 전체페이지</h6>
			<ul class="paginationUl">
				<c:if test="${pageDto.prev}">
					<li class="pagination"><a href="list?pageNum=${pageDto.startPage - 1 }&amount=${pageDto.amount}">이전</a></li>
				</c:if>
				
				<c:forEach var="num" begin="${pageDto.startPage }" end="${pageDto.endPage }">
					<li class="pagination" class="${pageDto.pageNum eq num ? 'active' : '' }">
					<%-- <a href="list?pageNum=${num}&amount=${pageDto.amount }">${num }</a> --%>
						<%-- <span class="pg" onclick="fn_paging(${num}, ${pageDto.amount })">${num }</span> --%>
						<a href="#" onclick="fn_paging(${num}, ${pageDto.amount })">${num }</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageDto.next }">
					<li class="pagination"><a href="list?pageNum=${pageDto.endPage + 1 }$amount=${pageDto.amount }">다음</a></li>
				</c:if>
			</ul>
<!-- 페이징의 이전/다음 기능은 수정해야함. -->	
	
	
	<button type="button" onclick="location.href='/board/regiView'">글쓰기</button>
	
	<div class="loading" id="loading">
		<img src="../../resources/img/Spinner.gif" alt="loading">
	</div>
	

</div><!-- //bbs_content -->
</div><!-- //content -->
<%@ include file="../module/footer.jsp" %>

<script type="text/javascript">
	function change(a){
		location.href="list?pageNum=1&amount="+a.value;
	}
</script>

<!-- <script type="text/javascript">
	$(document).ready(function(){
		$('#loading').hide();
		$('#trans').
	});
</script> -->

<script>
	const loading_page = document.getElementById("loading");
	window.onload = function(){
		loading_page.style.display = 'none';
	}
</script>
