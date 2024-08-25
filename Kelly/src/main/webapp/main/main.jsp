<%@include file="../common/header.html" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>メインページ</title>
</head>
<body>
    <div class="form-wrapper">
        <h1>メインページ</h1>
 
        <!-- 投稿ページへ飛ぶボタン -->
        <div class="button-panel">
            <a href="Post.action" class="button">投稿ページへ</a>
        </div>
        <div class="button-panel">
            <a href="PostSearch.action" class="button">作品を検索する</a>
        </div>
        <c:forEach var="post" items="${postList}">
        	<img src="${post.getBaseImg() }" alt="img_path" >
   		</c:forEach>
 
        <hr>
 
        <!-- 他人のアカウントのアイコンとフォロワーの投稿やおすすめの投稿 -->
        <h2>フォロワーの投稿やおすすめの投稿</h2>
        <c:forEach var="post" items="${posts}">
            <div class="post">
                <a href="profile.jsp?username=${post.username}">
                    <img src="${post.icon}" alt="icon" class="icon">
                </a>
                <span class="username">${post.username}</span>
                <div class="content">${post.content}</div>
            </div>
        </c:forEach>
    </div>
</body>
</html>