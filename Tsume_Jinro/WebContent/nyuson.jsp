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
<input type="button" value="トップページへ" onClick="location.href='Index'">
	<table align="center" bgcolor="#faebd7" width="100%" style="margin-top: 60px">
		<tr style="height:30px">
			<td align="center"style="font-weight: bold; font-size: 16pt; color: maroon;">
			入村
			</td>
		</tr>
	</table>
	<table align="center" bgcolor="#faebd7" width="100%">
			<tr style="margin-bottom: 10px">
				<td align="center">
				<div style="color:red">
				${error}
				</div>
				</td>
			</tr>
	</table>



<form method="post" action="Nyuson">


<%
out.println(new java.util.Date()+"<br>");
HashMap<Integer,Village> village_list=Server.get_village_list();
out.println("村数："+village_list.size()+"<br>");
if (village_list.size()==0){
	out.println("村がありません。<br><br>");
} else {
	out.println("<select name=Village_number>");
	for ( int i :village_list.keySet()){
		out.println("<option value="+village_list.get(i).number+">"+village_list.get(i).name+"</option>");
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
if (village_list.size()==0){
	out.println("村がありません。<br><br>");
}else{	
	out.println("<input type=\"submit\" value=\"決定\">");
}
%>
	
</form>
<br>
</body>
</html>