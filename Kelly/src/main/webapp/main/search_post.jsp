<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
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
						<option value="1" <c:if test="${selected_order=='1'}">selected</c:if>>投稿日時が新しい順</option>
						<option value="2" <c:if test="${selected_order=='2'}">selected</c:if>>投稿日時が古い順</option>
					</select>
					<label for="mode_select">検索方法</label>
					<select name="mode" id="mode_select">
						<option value="1" <c:if test="${selected_mode=='1'}">selected</c:if>>タグOR検索</option>
						<option value="2" <c:if test="${selected_mode=='2'}">selected</c:if>>タグAND検索</option>
						<option value="3" <c:if test="${selected_mode=='3'}">selected</c:if>>タイトルOR検索</option>
						<option value="4" <c:if test="${selected_mode=='4'}">selected</c:if>>タイトルAND検索</option>
						<option value="5" <c:if test="${selected_mode=='5'}">selected</c:if>>キャプションOR検索</option>
						<option value="6" <c:if test="${selected_mode=='6'}">selected</c:if>>キャプションAND検索</option>
					</select>
					<button id="search-button">検索</button>
				</form>
			</div>
				<c:choose>
					<c:when test="${get_posts.size()>=0}">
						<div>検索結果:${get_posts.size()}件</div>
						<div>
							<c:forEach var="post" items="${get_posts}" varStatus="info">
								<div>
									<p>=====================================================================================</p>
									<h3>${info.index}</h3>
									<p>投稿ID：${post.postID}</p>
									<p>投稿したアカウントのID：${post.accID}</p>
									<p>タイトル：${post.title}</p>
									<p>
									<c:forEach var="tag" items="${post.imgTags}" varStatus="taginfo">
									【タグ${taginfo.count}：${tag}】
									</c:forEach>
									</p>
									<p>キャプション：「${post.caption}」</p>
									<p>前面画像パス：${post.alphaImg}</p>
									<p>背景画像パス：${post.alphaImg}</p>
								</div>
							</c:forEach>
						</div>
					</c:when>
				</c:choose>
		</section>
	</body>
</html>