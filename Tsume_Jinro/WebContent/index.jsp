<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="object.Account,javax.servlet.http.HttpSession"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<link href="top.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<% 
	Account account=(Account)session.getAttribute("account");
	if(account==null){
%>
		ゲストさん
<%
	}else{
		pageContext.setAttribute("account",account);
%>
		${account.id}さん
<%
	}
%>
<br>
<div id="container">
	<input type="button" value="入村画面へ" onClick="location.href='Nyuson'">
	<input type="button" value="村作成画面へ" onClick="location.href='MakeVillage'"><br><br>
</div>
<div id="container">
	<input type="button" value="登録" onClick="location.href='SignUp'">
	<form method="post" action="Login">
		<input type="submit" value="ログイン画面へ">
	</form>
</div>
<br>
<input type="button" value="アカウントログイン " onClick="location.href='AccountLogin'">
</body>
</html>