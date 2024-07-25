<%-- 担当: 平間 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<title>LegalGraffiti -ログアウト-</title>
</head>
<body>
<%--メッセージの出力  --%>

<form action="Logout.action" method="post">
	<div id="content">
		<h2>本当にログアウトしますか?</h2>
		
		<button id="end-btn" name="end">はい</button>
		<button id="cancel-btn" name="cancel">いいえ</button>
	</div>
</form>

<%@include file="../common/footer.html" %>