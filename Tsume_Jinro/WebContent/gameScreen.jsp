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
	out.println(vill.sankasha);
//	for(int i=1;i<vill.sankasha.size();i++){
//		out.println(vill.sankasha.get(i).name+"<br>");
//	}
%>
</body>
</html>