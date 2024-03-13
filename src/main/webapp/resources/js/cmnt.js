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

function fn_regiCmnt(){
	var params = $("#frm").serializeArray();
	var AnnymtId = "";
	
	if(document.getElementById('chkboxCmnt').checked){
		AnnymtId = "익명";
		params = changeSerialize(params, 'rgtrId', AnnymtId);
	}

	$.ajax({
		type : "POST",
		url : "/comment/regiCmnt",
		data : params,
		success : function(data){
			if(data == "Y"){
				alert("댓글 등록이 완료되었습니다.");
				location.reload();
			}else{
				alert("댓글 등록이 실패되었습니다.");
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
};
