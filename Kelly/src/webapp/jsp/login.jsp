<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <!-- 外部CSSファイルへのリンク -->
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="form-wrapper">
        <h1>ログイン</h1>
        <form action="LoginExecute.action" method="post">
            <div class="form-item">
                <label for="email-input">アカウントID</label>
                <input id="email-input" type="text" name="account_id" required="required" placeholder="アカウントID">
            </div>
            <div class="form-item">
                <label for="password-input">パスワード</label>
                <input id="password-input" type="password" name="password" required="required" placeholder="パスワード">
                <div>
                    <input id="password-display" type="checkbox">
                    <label for="password-display">パスワードを表示</label>
                </div>
            </div>
            <div class="button-panel">
                <input type="submit" class="button" title="サインイン" value="サインイン">
            </div>
        </form>
        <div class="form-footer">
            <p><a href="#">アカウントを作成する</a></p>
            <p><a href="#">パスワードを忘れた場合</a></p>
        </div>
    </div>

    <!-- JavaScriptコード -->
    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function() {
            var passwordInput = document.getElementById('password-input');
            var passwordDisplay = document.getElementById('password-display');

            // 「パスワードを表示」が変更された時の処理
            passwordDisplay.addEventListener('change', function() {
                if (passwordDisplay.checked) {
                    // チェックが入っている場合、パスワード入力欄をテキストにする
                    passwordInput.type = 'text';
                } else {
                    // チェックが外れている場合、パスワード入力欄をパスワードにする
                    passwordInput.type = 'password';
                }
            });
        });
    </script>
</body>
</html>
