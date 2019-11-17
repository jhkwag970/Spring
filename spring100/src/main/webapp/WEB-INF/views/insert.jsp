<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 완료</h1>
<hr color = "blue">
<h3>당신의 회원 가입 정보</h3>
아이디: ${memberDTO.id }<br>
패스워드: ${memberDTO.pw }<br>
이름: ${memberDTO.name }<br>
번호: ${memberDTO.tel }<br>
</body>
</html>