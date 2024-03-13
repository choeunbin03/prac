<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${path}/resources/js/join.js" defer="defer"></script>
<title>Insert title here</title>
</head>
<body>

	<form id="joinFrm">
		
		<div class="form-group has-feedback">
			<label class="control-label" for="mbrNm">이름 입력: </label>
			<input class="form-control" type="text" placeholder="이름을 입력해주세요." id="mbrNm" name="mbrNm">
		</div>
		<div class="form-group has-feedback">
			<label class="control-label" for="mbrId">아이디 입력: </label>
			<input class="form-control" type="text" placeholder="아이디를 입력해주세요." id="mbrId" name="mbrId">
		</div>
		<div class="form-group has-feedback">
			<label class="control-label" for="mbrPwd">비밀번호 입력: </label>
			<input class="form-control" type="password" maxlength='13' placeholder="비밀번호를 입력해주세요." id="mbrPwd" name="mbrPwd">
		</div>
		<div class="form-group has-feedback">
			<label class="control-label" for="chkMbrPwd">비밀번호 확인: </label>
			<input class="form-control" type="password" maxlength='13' placeholder="비밀번호를 한 번 더 입력해주세요." id="chkMbrPwd" name="chkMbrPwd">
		</div>
		
		<div class="form-group has-feedback">
			<button class="btn btn-success" type="button" id="joinSubmit" onclick="fn_join();">회원가입</button>
			<button class="cencle btn btn-danger" type="button">취소</button>
		</div>
		
	</form>

</body>
</html>