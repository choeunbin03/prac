<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${path}/resources/css/bbsContent.css">
	<link rel="stylesheet" href="${path}/resources/css/moduleStyle.css">
	
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${path}/resources/js/nfq.js" type="text/javascript" defer="defer"></script>

</head>
<body>

	<%@ include file="../popup/popup.jsp" %>
	<%@ include file="../module/header.jsp" %>
	<div class="content">
	<%@ include file="../module/side.jsp" %>

	<div id="nfqContent">
	<form id="frm">
		<input type="hidden" value="" name="nfqSeq" id="nfqSeq">
		<input type="hidden" value="1" name="nfqType" id="nfqType">
		
		<br>
		<h3 align="center">공지사항</h3>
		<br>
		<div id="nfqSearchForm">
			<select name="type" id="type">
				<option value="rgtrId">작성자</option>
				<option value="title">제목</option>
			</select>
			<input type="text" size="20" id="keyWd" name="keyWd" value="${nfqSrchDto.keyWd }"/>&nbsp;
			<button type="button" onclick="fn_srchNfq(nfqType)">검색</button>
		</div>
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
					<th>제목</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${nfqList}" var="nfqList" varStatus="status">
					<tr>
						<td><c:out value="${status.end+1 - status.index}" /></td>
						<td><a href="#" onclick="fn_goView(${nfqList.nfqSeq})">${nfqList.nfqTtl}</a></td>
						<td><c:out value="${nfqList.rgtrDt}" /></td>
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
						<a href="list?pageNum=${num}&amount=${pageDto.amount }">${num }</a></li>
					</c:forEach>
					
					<c:if test="${pageDto.next }">
						<li class="pagination"><a href="list?pageNum=${pageDto.endPage + 1 }$amount=${pageDto.amount }">다음</a></li>
					</c:if>
				</ul>
		
		
		
<!-- 		
이 부분은 나중에 관리자에 한해서 버튼 생성
		<button type="button" onclick="location.href='/board/regiView'">글쓰기</button>
 -->		
	</form>
	
	</div><!-- //bbs_content -->
	</div><!-- //content -->
	<%@ include file="../module/footer.jsp" %>
	
	<script type="text/javascript">
		function change(a){
			location.href="list?pageNum=1&amount="+a.value;
		}
	</script>



</body>
</html>