<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="object.*,java.util.HashMap,java.util.Set,system.Server"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>game 画面</title>
<link href="top.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<%
	int village_number=(Integer)request.getAttribute("village_number");
	HashMap<Integer, Village> village_list=Server.get_village_list();
	Village vill=village_list.get(village_number);
	pageContext.setAttribute("vill",vill);
%>
		${vill.name}村<br>
		GM:${vill.GM.account.id}<br><br>
		${vill.day}日目　${vill.terminal}<br>
<%
	//参加者リストの表示
	out.println("参加者：<br>");
	for(int i: vill.sankasha_map.keySet()){
%>
		<div id="sankasha_container">
			<div id="sankasha_name">
<%
		out.println("  "+ vill.sankasha_map.get(i).getName());
%>
			</div>
<%
		if(vill.sankasha_map.get(i).isAlive()){
			out.println("<div id=\"sankasha_alive\">生存</div><br>");
		}else{
			out.println("<div id=\"sankasha_alive\">死亡</div><br>");
		}
%>
		</div>
<%
	}
%><br>
<form method="post" action="GameScreen">
<input type=text name=chat>
<input type="hidden" name="village_number" value="${vill.number}">
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