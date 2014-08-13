<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録画面</title>
</head>
<body>
	<table align="center" bgcolor="#faebd7" width="100%" style="margin-top: 60px">
		<tr style="height:30px">
			<td align="center"style="font-weight: bold; font-size: 16pt; color: maroon;">
			ログイン
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
<form method="post" action="SignUp">
	ID:<input type="text" name="ID"><br>
	パスワード:<input type="password" name="pass"><br>
	<input type="submit" value="新規登録">
</form>
<br>
<input type="button" value="トップページへ" onClick="location.href='Index'">
</body>
</html>