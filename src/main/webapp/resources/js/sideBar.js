$(document).ready(function(){
	//menu v1
	$(".menu-v1").mouseover(function(){
		$(this).children(".submenu").stop().slideDown();
	});

	
	
	$(".menu-v1").mouseleave(function(){
		$(this).children(".submenu").stop().slideUp();
	});
});	