function changeSerialize( values, k, v ){
	var found = false;
	
	for(i = 0; i < values.length && !found; i++){
		if(values[i].name == k){
			values[i].value = v;
			found = true;
		}
	}
	
	if(!found){
		values.push(
			{
				name:k,
				value:v
			}
		);
	}
	return values;
}

function fn_boardRegi(){

	//var bbsTtl = $("#bbsTtl").val();
	//var mbrId = $("#mbrId").val();
	//var bbsCn = $("#bbsCn").val();
	var params = $("#frm").serializeArray();
	var AnnymtId = "";
	
	if(document.getElementById('chkboxBoardRegi').checked){
		AnnymtId = "익명";
		params = changeSerialize(params, 'rgtrId', AnnymtId);
	}
	
	$.ajax({
		type : "POST",
		url : "/board/regi",
		data : params,
		success : function(data){
			if(data == "Y"){
				alert("글 등록이 완료되었습니다.");
				location.href = "/board/list";
			}else{
				alert("글 등록이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
};

function fn_boardUpdate(){
	//var bbsSeq = $("#bbsSeq").val();
	//var bbsTtl = $("#bbsTtl").val();
	//var rgtrId = $("#rgtrId").val();
	//var bbsCn = $("#bbsCn").val();
	var params = $("#frm").serializeArray();
	var AnnymtId = "";
	
	if(document.getElementById('chkboxBoardUpdate').checked){
		AnnymtId = "익명";
		params = changeSerialize(params, 'rgtrId', AnnymtId);
	}
	
	$.ajax({
		type : "POST",
		url : "/board/update",
		data : params,
		success : function(data){
			if(data == "Y"){
				alert("글 수정이 완료되었습니다.");
				fn_goView(bbsSeq);
			}else{
				alert("글 수정이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
}

function fn_boardDelete(bbsSeq){
	$.ajax({
		type : "POST",
		url : "/board/delete",
		data : {bbsSeq : bbsSeq},
		success : function(data){
			if(data == "Y"){
				alert("글 삭제 완료되었습니다.");
				location.href = "/board/list";
			}
		},
		error : function(data){
			alert("실패");
			console.log(data);
		}
	});
}

function fn_goView(bbsSeq) {
	//$("#bbsSeq").val(bbsSeq);
	
	//var f = $("#frm");
	//f.attr("action", "/board/view?bbsSeq="+bbsSeq);
	//f.attr("method", "GET");
	//f.submit();
	location.href = "/board/view?bbsSeq="+bbsSeq;
};

function fn_goUpdateView(bbsSeq){
	$("#bbsSeq").val(bbsSeq);
	
	var f = $("#frm");
	f.attr("action", "/board/goUpdateView");
	f.attr("method", "POST");
	f.submit();
};

function fn_updateBbsSpt(bbsSeq){
	var params = $("#frm").serializeArray();
	
	$.ajax({
		type : "POST",
		url : "/board/updateBbsSpt",
		data : params,
		success : function(data){
			if(data == "reload"){
				location.reload();
			}else{
				alert("다시");
			}
		},
		error : function(data){
			alert("실패");
			console.log(data);
		}
	});
};

//function fn_srchBbs(){
//	var params  = {
//		"TTT" : "RRR"
//	};
//
//	var keyWd = $("#keyWd").val();
//	var typeOp = document.getElementById("type");
//	var type = (typeOp.options[typeOp.selectedIndex].value);
//	params[type] = keyWd;

//	params.ggg = "sss";
	
//	$.ajax({
//		type : "POST",
//		url : "/board/bbsSrch",
//		data : params,
//		success : function(data){
//			if(data == "/board/list"){
//				//location.href = "/board/list";
//				//location.reload();
//				alert("성공");
//			}else{
//				alert("다시");
//			}
//		},
//		error : function(data){
//			alert("실패");
//			console.log(data);
//		}
//	});
//};

function fn_srchBbs(){
	var params  = {
//		"TTT" : "RRR"
	};
	var keyWd = $("#keyWd").val();
	var typeOp = document.getElementById("type");
	var type = (typeOp.options[typeOp.selectedIndex].value);
	params[type] = keyWd;

//	params.ggg = "sss";

	var aa = document.createElement('input');
	aa.setAttribute("type", "hidden");
	aa.setAttribute("name", Object.keys(params)[1]);
	aa.setAttribute("value", Object.values(params)[1]);
	
	var f = $("#srchFrm");
	f.append(aa);
	f.attr("action", "/board/bbsSrch?type="+type+"&keyWd="+keyWd);
	f.attr("method", "GET");
	f.submit();
};

function fn_goBackPg(){
	var referrer = document.referrer;
	
	window.location.href = referrer;
};

function fn_paging(num, amount){
	var currentUrl = window.location.pathname;
	
	$("#pageNum").val(num);
	$("#amount").val(amount);
	
	console.log("현재 페이지 url: "+currentUrl);
	if(currentUrl == "/board/bbsSrch"){
		var params = {};
		var keyWd = $("#keyWd").val();
		var typeOp = document.getElementById("type");
		var type = (typeOp.options[typeOp.selectedIndex].value);
		params[type] = keyWd;
		
		var aa = document.createElement('input');
		aa.setAttribute("type", "hidden");
		aa.setAttribute("name", Object.keys(params)[1]);
		aa.setAttribute("value", Object.values(params)[1]);
		
		var f = $("#srchFrm");
		f.append(aa);
		f.attr("action", "/board/bbsSrch");
		f.attr("method", "GET");
		f.submit();
	}else{
		window.location.href = currentUrl+"?pageNum="+num+"&amount="+amount;
	}
	
};