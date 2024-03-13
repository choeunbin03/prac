<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="${path}/resources/css/popUpStyle.css">
<script src="${path}/resources/js/popup.js" type="text/javascript" defer="defer"></script>

    <!-- layer popup content -->
    <div class="layerPopup" id="layer_popup" style="visibility: visible;">
    	<div class="layerBox">
    		<h4 class="title">공지사항</h4>
    		<div class="cont">
    			<p>
    			<img src="${path}/resources/img/popUpImg.jpg" width=350 height=500 usemap="#popup" alt="event page">
    			</p>
    		</div>
    		<form name="pop_form">\
    			<div id="popUpCheck"><input type="checkbox" name="chkboxPop" value="checkbox" id="chkboxPop">
    				<label for="chkboxPop" class="btnTodayHide">&nbsp;&nbsp;오늘 하루동안 보지 않기</label>
    			</div>
    			<div id="close"><a href="javascript:closePop();">닫기</a></div>
    		</form>
    		
    	</div>
    </div>