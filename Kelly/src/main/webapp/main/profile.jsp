<%@include file="../common/header.html" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*, java.sql.*" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    // サーバーサイドで写真を取得するロジック
    String userId = request.getParameter("userId");
    List<String> photos = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
 
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
 
        String sql = "SELECT photo_path FROM user_photos WHERE user_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, userId);
        rs = ps.executeQuery();
 
        while (rs.next()) {
            photos.add(rs.getString("photo_path"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>投稿詳細</title>
</head>
<body>
<div class="form-wrapper">
<h1>投稿詳細</h1>
 
        <!-- 写真表示 -->
<div class="photo-gallery">
<c:choose>
<c:when test="${not empty photos}">
<c:forEach var="photo" items="${photos}">
<div class="photo-item">
<img src="${photo}" alt="user photo">
<input type="radio" name="selectedPhoto" value="${photo}">
</div>
</c:forEach>
</c:when>
<c:otherwise>
<p>写真は存在しません</p>
</c:otherwise>
</c:choose>
</div>
 
        <!-- タグ選択 -->
<form action="savePhotoTagServlet" method="post">
<input type="hidden" name="userId" value="${userId}">
<div class="tag-selection">
<label for="tag">タグを選択してください：</label>
<select name="tag" id="tag">
<option value="tag1">タグ1</option>
<option value="tag2">タグ2</option>
<option value="tag3">タグ3</option>
<!-- 他のタグも追加可能 -->
</select>
</div>
 
            <!-- 投稿するボタン -->
<div class="button-panel">
<input type="submit" class="button" title="投稿する" value="投稿する">
</div>
</form>
</div>
</body>
</html>