<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/header.html"%>
<title>新規投稿</title>
</head>
<body>
    <div class="container">
	    <h2>画像を選択してください</h2>
	    <!-- 画像ファイルを選択するための入力フォーム -->
	    <form action="PostFile" method="post" enctype="multipart/form-data">
	        <input type="file" name="picture1" accept="image/*">
	        <input type="file" name="picture2" accept="image/*">
	        <h3>画像のタイトル</h3>
	        <input type="text" name="title" value="title"><br>
	        <h3>タグを選択して下さい ※5個まで選択可能</h3>
			<label>項目 1: <input type="text" name="tags[]"></label><br>
        	<label>項目 2: <input type="text" name="tags[]"></label><br>
        	<label>項目 3: <input type="text" name="tags[]"></label><br>
        	<label>項目 4: <input type="text" name="tags[]"></label><br>
        	<label>項目 5: <input type="text" name="tags[]"></label><br>
        	<h3>コメント</h3>
        	<input type="text" name="caption"><br>
	        <input type="submit" value="アップロード">
	    </form>
    </div>
<%@include file="../common/footer.html"%>