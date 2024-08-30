<%-- 担当: 平間 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<title>LegalGraffiti -ライブラリー-</title>
<link rel="icon" href="../picture/favicon.png">
</head>
<body>
<%--メッセージの出力  --%>
<div id="main-content">
	<div id="library">
		<%-- <form method="get"> --%>
			<c:choose>
				<%-- DB上にアップロードした画像を表示 --%>
				<c:when test="${imageList.size()!=0}">
					<c:forEach var="image" items="${imageList}">
						<img src="${image.img}" alt="${image.title}">
						<h6>${image.title}</h6>
						<h6>${image.date}</h6>
					</c:forEach>
				</c:when>
				<%-- 画像が存在しなかった場合、新規に画像を作成するように促す --%>
				<c:otherwise>
					<div>
						<p>ライブラリー上に画像が保存されていません。</p>
						<p>「写真を撮る」から画像を生成し、ライブラリーに保存してください。</p>
						<button class="btn-library" value="return" name="写真を撮る"></button>
					</div>
				</c:otherwise>
			</c:choose>	
		<%-- </form> --%>
	</div>
</div>

<%@include file="../common/footer.html" %>