<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tume_jinro.*,yakushoku.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>


<form method="post" action="Test">
  <input type="text" name="name1"><br><br>
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
  <input type="checkbox" name="vehicle" value="車">車<br>
  <input type="checkbox" name="vehicle" value="バイク">バイク<br>
  <input type="checkbox" name="vehicle" value="飛行機">飛行機<br><br>

  <input type="submit" value="決定">
</form>
<br>
<input type="button" value="入村画面へ" onClick="location.href='nyuson.jsp'">
<input type="button" value="村作成画面へ" onClick="location.href='makeVillage.jsp'">
</body>
</html>