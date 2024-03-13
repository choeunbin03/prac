<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="${path}/resources/js/cmnt.js"></script>

	<div class="cmnttRegiArea">
		<!-- <input type="hidden" value="" name="bbsSeq" id="bbsSeq"> -->
		<!-- <input type="hidden" value="" name="cmntSeq" id="cmntSeq"> -->
		<input type="hidden" value="${sessionScope.sessionId}" name="rgtrId" id="rgtrId">
		<!-- 익명 체크박스 위치 -->
		<div class="cmntCheck"><input type="checkbox" name="chkboxCmnt" value="checkbox" id="chkboxCmnt">
	    	<label for="chkboxCmnt" class="cmntAnnymtBox">&nbsp;익명</label>
	    </div>
		<div class="cmntTxt">
			<textarea id="cmntCn" name="cmntCn" placeholder="댓글을 입력하세요." rows="5" cols="100"></textarea>
		</div>
		<div class="btnCmnt">
			<button type="button" onclick="fn_regiCmnt();" id="btnRegiCmnt">등록</button>
		</div>
	</div>