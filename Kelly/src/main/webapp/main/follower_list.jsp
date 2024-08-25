<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>フォローしているアカウント</title>
	</head>
	<body>
		<section>
			<c:if test="${follower_list.size()>=0}">
				<div>あなたをフォローしている人数:${follower_list.size()}人</div>
				<div>
					<c:forEach var="follow" items="${follower_list}" varStatus="info">
						<div>
							<p>=====================================================================================</p>
							<h3>${info.index}</h3>
							<p>${follower.accData.iconPath}</p>
							<p>${follower.accData.accountName}</p>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</section>
	</body>
</html>