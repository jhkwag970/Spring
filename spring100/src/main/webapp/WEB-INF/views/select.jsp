<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>${memberDTO.id }검색요청 완료 끝</h3>
<h3>검색 결과 입니다.</h3>
<hr color = "red">
검색된 아이디: ${dto2.id } <br>
검색된 패스워드: ${dto2.pw } <br>
검색된 이름: ${dto2.name } <br>
검색된 번호: ${dto2.tel } <br>
</body>
</html>