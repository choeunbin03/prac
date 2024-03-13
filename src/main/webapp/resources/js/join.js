function cmpPwd(values, findMbrPwd, findChkMbrPwd){

	var mbrPwd = "";
	var chkMbrPwd = "";
	
	for(i = 0; i < values.length; i++){
		if(values[i].name == findMbrPwd){
			mbrPwd = values[i].value;
		}
	}
	for(i = 0; i < values.length; i++){
		if(values[i].name == findChkMbrPwd){
			chkMbrPwd = values[i].value;
		}
	}		
	
	if(mbrPwd == chkMbrPwd){
		return values;
	}else{
		return false;
	}
	
}

function fn_join(){
	var params = $("#joinFrm").serializeArray();
	
	params = cmpPwd(params, 'mbrPwd', 'chkMbrPwd');
	
	if(!params){
		alert("비밀번호가 일치하지 않습니다.");
		return false;
		//location.reload();
	}
	
	$.ajax({
		type : "POST",
		url : "/member/join",
		data : params,
		success : function(data){
			if(data == "Y"){
				alert("회원가입이 완료되었습니다.");
				location.href = "/";
			}else{
				alert("회원가입이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("문제가 발생하였습니다.");
			console.log(data);
		}
	});
	
}