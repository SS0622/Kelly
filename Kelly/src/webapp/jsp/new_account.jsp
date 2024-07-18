<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規アカウント登録</title>
</head>
<body>
    <div class="container">
        <h2>新規アカウント登録</h2>
        <form action="register.jsp" method="post">
            <label for="userId">ユーザーID:</label>
            <input type="text" id="userId" name="userId" required>

            <label for="password">パスワード:</label>
            <input type="password" id="password" name="password" required>

            <label for="email">メールアドレス:</label>
            <input type="email" id="email" name="email" required>

            <input type="submit" value="送信">
        </form>
        <div class="login-link">
            アカウントをお持ちですか？ <a href="login.jsp">ログイン</a>
        </div>
    </div>
</body>
</html>
