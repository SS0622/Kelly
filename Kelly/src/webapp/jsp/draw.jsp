<%-- 担当: 平間 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<title>LegalGraffiti -キャンバス-</title>
<link rel="stylesheet" href="css/canvas.css"/>
</head>
<body>
<%--メッセージの出力  --%>

<form action="Logout.action" method="post">
	<div id="canvas_area">
		<canvas>
		
		</canvas>
	</div>
</form>

<%@include file="../footer.html" %>