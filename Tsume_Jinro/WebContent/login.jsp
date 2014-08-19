<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.HashMap,object.Village,object.Sankasha"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<input type="button" value="トップページへ" onClick="location.href='Index'">
	<table align="center" bgcolor="#faebd7" width="100%" style="margin-top: 10px">
		<tr style="height:30px">
			<td align="center"style="font-weight: bold; font-size: 16pt; color: maroon;">
			村へのログイン
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
入村していない村の場合、観戦を行います。<br>
<% 
HashMap<Integer, Village> village_list=(HashMap<Integer, Village>) request.getAttribute("village_list");
if(village_list.size()==0){
	%>
	観戦可能な村がありません。
	<%
}else{
	%>
	<form method="post" action="Login">
	村名
	<select name=vill_number>
	<%
	for (Village vill:village_list.values()){
		pageContext.setAttribute("vill",vill);
	%>
		<option value="${vill.number}">${vill.name}
	<%
	}
	%>
	</select><br>
	
	<%--
	if (! (request.getAttribute("vill")==null)){
		%>
		参加者名
		<select name="id">
		<%
			Village vill =(Village)request.getAttribute("vill");
			for (int i: vill.sankasha.keySet()){
				pageContext.setAttribute("i",i);
				Sankasha person=vill.sankasha.get(i);
				pageContext.setAttribute("person",person);
		%>
				<option value="${i}">${person.name}
		<%
			}
		%>
		</select><br>
		パスワード：<input type="password" name="pass"><br>
		<%
	}
	--%>
	<input type="submit" value="決定"><br>
	</form>
	<%
}
%>
</body>
</html>