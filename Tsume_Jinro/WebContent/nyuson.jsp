<%@page import="system.Server"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="object.*,java.util.HashMap,java.util.Set"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入村画面</title>
</head>
<body>
<%

%>


<form method="post" action="Nyuson">


<%
out.println(new java.util.Date()+"<br>");
HashMap<Integer,Village> village_list=Server.get_village_list();
out.println("村数："+village_list.size()+"<br>");
Integer[] key_list=village_list.keySet().toArray(new Integer[0]); 
if (key_list.length==0){
	out.println("村がありません。<br><br>");
} else {
	out.println("<select name=Village_number>");
	for (int i=0;i<key_list.length;i++){
		out.println("<option value="+village_list.get(key_list[i]).number+">"+village_list.get(key_list[i]).number+"</option>");
	}
	out.println("</select><br>");
}

%>
	名前：
	<input type="text" name="name"><br><br>
	<input type="radio" name="kibo" value="無し" checked>無し<br>
	<input type="radio" name="kibo" value="占い師" >占い師<br>
	<input type="radio" name="kibo" value="霊能者" >霊能者<br>
	<input type="radio" name="kibo" value="人狼" >人狼<br>
<%
if (key_list.length==0){
	out.println("村がありません。<br><br>");
}else{	
	out.println("<input type=\"submit\" value=\"決定\">");
}
%>
	
</form>
<br>
</body>
</html>