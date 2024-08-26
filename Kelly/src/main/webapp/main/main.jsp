<%@include file="../common/header.html" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Post" %>
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
        <%
        	List<Post> postList = (List<Post>) request.getAttribute("postList");
        	if(postList != null && !postList.isEmpty() ){
        		System.out.print("a");
        		for(int i=0;i<postList.size();i++){
        %>
        <img src="<%=postList.get(i).getBaseImg() %>?timestamp=<%= System.currentTimeMillis() %>" alt="img alt"><br>
        <%
        		}
        	}
        %>
 
        <hr>
 
        <!-- 他人のアカウントのアイコンとフォロワーの投稿やおすすめの投稿 -->

    </div>
</body>
</html>