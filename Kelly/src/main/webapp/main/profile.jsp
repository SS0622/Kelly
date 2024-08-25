<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<title>profile</title>

</head>
<body>
	<form action="PostFile" method="post" enctype="multipart/form-data">
		<label>アイコン変更：<input type="file" name="icon_path" accept="image/*"></label>
		<label>名前：<input type="text" value=${account.getAccountName()}></label>
		<input type="submit" value="変更">
	</form>
	
<%@include file="../common/footer.html" %>