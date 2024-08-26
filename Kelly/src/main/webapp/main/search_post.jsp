<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.util.ArrayList,java.util.List,bean.Post" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>画像を検索</title>
	</head>
	<body>
		<section>
			<div>
				<form action="PostSearchExecute.action" method="get">
					<label for="textbox">検索ワード</label>
					<input type="text" name="input_txt" id="textbox" value="${txtboxstr}">
					<label for="order_select">並び順</label>
					<select name="order" id="order_select">
						<option value="1" >投稿日時が新しい順</option>
						<option value="2" >投稿日時が古い順</option>
					</select>
					<label for="mode_select">検索方法</label>
					<select name="mode" id="mode_select">
						<option value="1" >タグOR検索</option>
						<option value="2" >タグAND検索</option>
						<option value="3" >タイトルOR検索</option>
						<option value="4" >タイトルAND検索</option>
						<option value="5" >キャプションOR検索</option>
						<option value="6" >キャプションAND検索</option>
					</select>
					<button id="search-button">検索</button>
				</form>
				<%
				List<Post> posts = (List<Post>) request.getAttribute("get_posts");
				if (posts!=null&&tags.size()>=1) {%>
					<%
		        	for(int i=0;i<posts.size();i++){
		            %>
		            <p>=====================================================================================</p>
		            <p>投稿ID：<%=posts.get(i).getPostID() %></p>
		            <p>投稿したアカウントのID：<%=posts.get(i).getAccID() %></p>
		            <p>タイトル：<%=posts.get(i).getTitle() %></p>
						<%
						for(int n=0;n<5;n++){
						%>
						<p>【タグ<%=n+1 %>：<%=posts.get(i).getImgTags()[n] %>】</p>
						<%
			            }
			            %>
					<p>キャプション：<%=posts.get(i).getCaption() %></p>
					<p>第1画像パス：<%=posts.get(i).getAlphaImg() %></p>
					<p>第2画像パス：<%=posts.get(i).getBaseImg() %></p>
		            <%
		            }
		            %>
		        <%
		        }
		        %>
		</section>
	</body>
</html>