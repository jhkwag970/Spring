<%@page import="com.kgitbank.mvc100.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> jump.jsp  파일 </h1>
졸려어어ㅓㅓ

<%
	//MVC1 model 
	//control
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	
	//model
	MemberDAO dao = new MemberDAO();
	dao.insert(id,pw,name,tel);
	
%>

<h3> DB처리 요청됨. </h3>

</body>
</html>