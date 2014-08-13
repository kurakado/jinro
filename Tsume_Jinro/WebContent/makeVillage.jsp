<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>村作成画面</title>
</head>
<body>
	<table align="center" bgcolor="#faebd7" width="100%" style="margin-top: 60px">
		<tr style="height:30px">
			<td align="center"style="font-weight: bold; font-size: 16pt; color: maroon;">
			村作成
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

<form method="post" action="MakeVillage">
GMの名前：
	<input type="text" name="name"><br>
パスワード：
	<input type="password" name="pass"><br><br>

村名：
	<input type="text" name="village_name"><br><br>
	占い師：
<select name=ninzuu_uranaishi>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
	霊能者：
<select name=ninzuu_reinousha>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
	共有者：
<select name=ninzuu_kyoyusha>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
	狩人：
<select name=ninzuu_karyudo>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
	村人：
<select name=ninzuu_murabito>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
	狂人：
<select name=ninzuu_kyojin>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
	人狼：
<select name=ninzuu_jinro>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
	妖狐：
<select name=ninzuu_youko>
<% 
for (int i=0;i<100;i++){
	out.println("<option value="+i+">"+i+"</option>");
}
%>
</select><br>
  <input type="submit" value="決定">
</form>

</body>
</html>