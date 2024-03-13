function fn_regi(){

	var params = $("#frm").serializeArray();
	
	$.ajax({
		type : "POST",
		url : "/nfq/regi",
		data : params,
		success : function(data){
			if(data == "Y"){
				alert("등록이 완료되었습니다.");
				if(params[0].value == 3){
					location.href = "/nfq/list?nfqType=3";
				}else{
					location.href = "/nfq/nfqMng";
				}
			}else{
				alert("등록이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
};

function fn_nfqUpdate(){
	//var nfqSeq = $("#nfqSeq").val();
	//var nfqTtl = $("#nfqTtl").val();
	//var rgtrId = $("#rgtrId").val();
	//var nfqCn = $("#nfqCn").val();
	var params = $("#frm").serializeArray();
	var AnnymtId = "";
	
	$.ajax({
		type : "POST",
		url : "/nfq/update",
		data : params,
		success : function(data){
			if(data == "Y"){
				alert("글 수정이 완료되었습니다.");
				fn_goView(nfqSeq);
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

function fn_nfqDelete(nfqSeq){
	$.ajax({
		type : "POST",
		url : "/nfq/delete",
		data : {nfqSeq : nfqSeq},
		success : function(data){
			if(data == "Y"){
				alert("글 삭제 완료되었습니다.");
				location.href = "/nfq/nfqMng";
			}
		},
		error : function(data){
			alert("실패");
			console.log(data);
		}
	});
}

function fn_goView (nfqSeq) {
	$("#nfqSeq").val(nfqSeq);
	
	var f = $("#frm");
	f.attr("action", "/nfq/view/"+nfqSeq);
	f.attr("method", "POST");
	f.submit();
};

function fn_goUpdateView(nfqSeq){
	$("#nfqSeq").val(nfqSeq);
	
	var f = $("#frm");
	f.attr("action", "/nfq/goUpdateView");
	f.attr("method", "POST");
	f.submit();
};

function fn_updateNfqSpt(nfqSeq){
	var params = $("#frm").serializeArray();
	
	$.ajax({
		type : "POST",
		url : "/nfq/updateNfqSpt",
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

function fn_srchNfq(){
	var params  = {
		"TTT" : "RRR"
	};

	var keyWd = $("#keyWd").val();
	var typeOp = document.getElementById("type");
	var type = (typeOp.options[typeOp.selectedIndex].value);
	params[type] = keyWd;

	params.ggg = "sss";
	
	$.ajax({
		type : "POST",
		url : "/nfq/nfqSrch",
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

function fn_goBackPg(){
	var referrer = document.referrer;
	
	console.log("이전 페이지 url: "+referrer);
	window.location.href = referrer;
};