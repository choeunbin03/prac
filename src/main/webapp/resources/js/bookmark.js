function action_add(addUrl){
//	var text_add = addUrl;
//	var ul_list = $("#bmkList");
//	ul_list.append("<li>"+text_add+"</li>");

//	const addValue = addUrl;
//	const li = document.createElement("li");
//	li.setAttribute('id', "bmkEl");
//	li.textContent = addValue;
//	const textNode = document.createTextNode(addValue);
//	li.appendChild(textNode);
//	document.getElementById('bmkList').appendChild(li);
	$("#bmkList").append("<li>"+addUrl+"</li>");
}

function fn_bookmark(){
	var aaa = window.location.pathname + window.location.search;
	var params = $("#frm").serializeArray();
	params.push({name: "bmkUrl", value: aaa});
	
	$.ajax({
		type : "POST",
		url : "/saveBookmark",
		data : params,
		success : function(data){
			if(data != "N"){
				//action_add(data);
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

//$(function(){
  // 실행할 기능을 정의해주세요.
//  $('#btnBmk').off().click(function(){
//  	action_add('ddddd');
  	//여기에 즐겨찾기 버튼 글씨 바꾸고 동작 못하게.
//  });
//});
