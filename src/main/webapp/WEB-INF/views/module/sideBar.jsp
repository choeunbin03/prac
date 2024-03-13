<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


	<div id="container">
		<!-- 세로형 1 -->
		<ul id="nav-v1">
			<li class="menu-v1"><a href="/board/list">자유게시판</a></li>
			<li class="menu-v1"><a href="/nfq/list?nfqType=1">공지사항</a></li>
			<li class="menu-v1"><a href="/nfq/list?nfqType=3">Q&A</a></li>
			<li class="menu-v1"><a href="/nfq/list?nfqType=2">FAQ</a></li>
			<li class="menu-v1"><a href="/getBmkList">즐겨찾기</a>
		<!-- 수정해야함 이렇게 하면 즐겨찾기 버튼 눌렀을 때 아무 일도 없을듯. 메소드가 일단 void형이고 void형이 아니라도
		board/list 이렇게 return 할 수도 없음...css에서 model값 사용은 안 될 것 같고
		페이지 옮겨갈 때마다 bmk 테이블 조회해서 갖다붙이는 것도 좀;;
		그래서 즐겨찾기 버튼 누른 뒤에 동적으로 추가한 뒤 업데이트 하려 했는데 문제는 reload하게 되면 list로 들어가서 정보가 사라짐. -->
				<c:forEach items="${bmkList}" var="bmkList">
					<ul class="submenu" id="bmkList">
						<!-- <li><a href="#">SubMenu 1</a></li> -->
						<li><a href="#" onclick="location.href='${bmkList.bmkUrl}'">${bmkList.bmkTtl}</a></li>
					</ul>
				</c:forEach>
			</li>
		</ul>
		<div class="clear"></div>
	</div>
	
	<button type="button" style="display:none;" onclick="location.href='/nfq/nfqMng'">관리자페이지</button>
	
	
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/bookmark.js"></script>


	