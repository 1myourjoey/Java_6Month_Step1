
<%@page import="mvjsp.board.dao.memberDao"%>
<%@page import="mvjsp.jdbc.connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="mvjsp.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Connection conn = ConnectionProvider.getConnection();
memberDao dao = memberDao.getInstance();
System.out.println(dao.selectAll(conn));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>