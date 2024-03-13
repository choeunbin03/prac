<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/board/list">게시판</a>
<script>
    function windowonload() {
        alert("windowonload 호출 성공");
        console.log('4444444444');
        var strTmp1 = 'eeeee1';
        var strTmp2 = 'eeeee2';
        var strTmp3 = 'eeeee3';
    }
    window.onload = windowonload;
</script>
</body>
</html>
