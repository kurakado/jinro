<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="object.*,java.util.HashMap,java.util.Set,system.Server"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int village_number=Integer.parseInt(request.getParameter("village_number"));
	HashMap<Integer, Village> village_list=Server.get_village_list();
	Village vill=village_list.get(village_number);
	out.println("参加者：<br>");
	for(Sankasha person:vill.sankasha){
		out.println("  "+person.name+"<br>");
	}

%>
<form method="post" action="gameScreen.jsp">
<input type=text name=chat>
<% 
out.println("<input type=\"hidden\" name=\"village_number\" value=" + village_number + ">");
%>
<input type="submit" value="更新">
<br>
<%
if (request.getParameter("chat")!=null){
	if(! (request.getParameter("chat").equals(""))){
		//発言の新しい物ほど上にくるように要素0に挿入。
		//逆順で表示したいなら位置指定を消す。(最後の要素に追加)
		vill.chat.add(0,"｢"+request.getParameter("chat")+"｣");
	}
}
for(String chat:vill.chat){
	out.println(chat+"<br>");
}
%>
</form>
</body>
</html>