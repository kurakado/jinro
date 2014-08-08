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
<form method="post" action="Login">
村名
<select name=vill_number>
<%
HashMap<Integer, Village> village_list=(HashMap<Integer, Village>) request.getAttribute("village_list");
for (Village vill:village_list.values()){
	pageContext.setAttribute("vill",vill);
%>
	<option value="${vill.number}">${vill.name}
<%
}
%>
</select><br>
参加者名
<select name="id">
<%
if (! (request.getAttribute("vill")==null)){
	Village vill =(Village)request.getAttribute("vill");
	for (int i: vill.sankasha.keySet()){
		pageContext.setAttribute("i",i);
		Sankasha person=vill.sankasha.get(i);
		pageContext.setAttribute("person",person);
%>
		<option value="${i}">${person.name}
<%
	}
}
%>
</select><br>
<input type="password" name="pass">
<input type="submit" value="決定">
</form>
<input type="button" value="トップページへ" onClick="location.href='index.html'">
</body>
</html>