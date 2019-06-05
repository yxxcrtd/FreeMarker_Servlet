<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>在Servlet中使用FreeMarker模板</title>
	</head>

	<body>
		<div>名称：<input type="input" value="${name!}" style="width: 300px;" /></div>
		<div>当前时间：<input type="input" value="${time!?string("yyyy-MM-dd HH:mm:ss")}" style="width: 300px;" /></div>
		<div>没有的值：${abc!"没有abc！"}</div>
	</body>
</html>