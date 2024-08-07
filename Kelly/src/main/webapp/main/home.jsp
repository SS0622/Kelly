<%-- 担当: 平間 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<title>LegalGraffiti -ペイント:ホーム-</title>

</head>
<body>
<div id="main-content">
	<div id="peint-home">
		<%-- 機能テスト専用 --%>
		<button id="t1" value="omakase">機能テスト1</button>
		<button id="t2" value="suruyo">機能テスト2</button>
		<a href="#">必要に応じて書き換えてください</a>
		<%-- コードの整合性が取れていない場合 エラーする可能性があります
		書き換えてほしい箇所があったらチャットに連絡下さい --%>	
		<%-- メインページ --%>
		<h1>ペイント</h1>
		<h3>新しい作品を制作する</h3>
		<a class="btn-peint-home" href="Camera.action">写真を撮る</a>
		<h3>作った作品を編集する</h3>
		<a class="btn-peint-home" href="Library.action">ライブラリー</a>
	</div>
</div>
<%@include file="../common/footer.html" %>