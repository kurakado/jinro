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

boolean result=(Boolean) request.getAttribute("result");
Sankasha person=(Sankasha) request.getAttribute("person");
Village vill=(Village) request.getAttribute("vill");
if (result==true){
	out.println(person.yaku);
	pageContext.setAttribute("vill",vill);
	pageContext.setAttribute("person",person);
%>
	村番号：${vill.number}<br>
	村名前：${vill.name}<br>
	名前：${person.name}<br>
	希望役職：${person.kibo_yaku}<br>
	役職:${person.yaku}<br>

	<form method="post" action="GameScreen">
	<input type="hidden" name="village_number" value="${vill.number}">
	<input type="submit" value="進む">
<%
}else{
%>	
	定員オーバー
<%
}
%>
</form>
</body>
</html>