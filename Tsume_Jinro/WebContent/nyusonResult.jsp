<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap,object.*,system.Server"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入村画面</title>
</head>
<body>
<%
//HashMap<Integer, Village> village_list=Server.get_village_list();
//Village vill=village_list.get(Integer.parseInt(request.getParameter("Village_number")));
//Sankasha person=new Sankasha(request.getParameter("name"),request.getParameter("kibo"));
//boolean result = vill.sanka(person);

Sankasha sankasha=(Sankasha) session.getAttribute("sankasha");
Village vill=(Village) session.getAttribute("vill");

out.println(sankasha.yaku);
pageContext.setAttribute("vill",vill);
pageContext.setAttribute("sankasha",sankasha);
%>
村番号：${vill.number}<br>
村名前：${vill.name}<br>
名前：${sankasha.name}<br>
希望役職：${sankasha.kibo_yaku}<br>
役職:${sankasha.yaku}<br>

<form method="post" action="GameScreen">
<input type="hidden" name="village_number" value="${vill.number}">
<input type="submit" value="進む">


</form>
</body>
</html>