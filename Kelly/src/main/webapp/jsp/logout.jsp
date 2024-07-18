<%-- 担当: 平間 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<title>LegalGraffiti -ログアウト-</title>
</head>
<body>
<%--メッセージの出力  --%>
<h2>本当にログアウトしますか?</h2>
<form action="Logout.action" method="post">
	<div id="logout">
		<button id="end-button" name="end">はい</button>
		<button id="cancel-button" name="cancel">いいえ</button>
	</div>
</form>

<%@include file="../common/footer.html" %>