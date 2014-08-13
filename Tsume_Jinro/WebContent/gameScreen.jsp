<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="object.*,java.util.HashMap,java.util.Set,system.Server"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>game 画面</title>
</head>
<body>

<%
	int village_number=(Integer)request.getAttribute("village_number");
	HashMap<Integer, Village> village_list=Server.get_village_list();
	Village vill=village_list.get(village_number);
	//参加者リストの表示
	out.println("参加者：<br>");
	for(int i: vill.sankasha.keySet()){
		out.println("  "+ vill.sankasha.get(i).getName()+"<br>");
	}
%>
<form method="post" action="GameScreen">
<input type=text name=chat>
<% 
out.println("<input type=\"hidden\" name=\"village_number\" value=" + village_number + ">");
%>
<input type="submit" value="更新">
<br>
<%
//チャットログの表示
for(String chat:vill.chat){
	out.println(chat+"<br>");
}
%>
<input type="button" value="トップページへ" onClick="location.href='index.jsp'">

</form>
</body>
</html>