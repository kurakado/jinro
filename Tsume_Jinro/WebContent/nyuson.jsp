<%@page import="system.Server"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="object.*"
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

<select name=ninzuu_jinro>
<%--
out.println(new java.util.Date());
Village[] village_list=Server.get_village_list();
out.println(village_list[0].number);
for (int i=0;i<village_list.length;i++){
	out.println(village_list[i].number);
}
--%>
</select><br>

	<input type="text" name="name"><br><br>
	<input type="radio" name="kibo" value="無し" checked>無し<br>
	<input type="radio" name="kibo" value="占い師" >占い師<br>
	<input type="radio" name="kibo" value="霊能者" >霊能者<br>
	<input type="radio" name="kibo" value="人狼" >人狼<br>
	<input type="submit" value="決定">
	
</form>
<br>
</body>
</html>