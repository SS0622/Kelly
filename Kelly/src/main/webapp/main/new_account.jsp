<%-- 担当: 井上 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規アカウント登録</title>
</head>
<body>
    <div class="container">
        <h2>新規アカウント登録</h2>
        <form action="SignUpExecute.action" method="post">
            <label for="userId">ユーザーID:</label>
            <input type="text" id="userId" name="userId" required><br>

            <label for="password">パスワード:</label>
            <input type="password" id="password" name="password" required><br>

            <label for="email">メールアドレス:</label>
            <input type="email" id="email" name="email" required><br>

            <input type="submit" value="送信">
        </form>
        <div class="login-link">
            アカウントをお持ちですか？ <a href="login.jsp">ログイン</a>
        </div>
    </div>
</body>
</html>