<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<% 
String error = (String) request.getAttribute("error");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規アカウント登録</title>
    <!-- 外部CSSファイルへのリンク -->
    <link rel="stylesheet" href="../css/styles.css">
    <link rel="icon" href="../picture/favicon.png">
</head>
<body>
    <div class="form-wrapper">
        <h1>新規アカウント登録</h1>
        <form action="SignUpExecute.action" method="post">
        	<% 
        	if (error!=""){ 
        	%>
        		<div><font color="red">${error}</font></div>
        	<%
        	}
        	%>
            <div class="form-item">
                <label for="userId">ユーザーID</label>
                <input id="userId" type="text" name="userId" required="required" placeholder="ユーザーID">
            </div>
            <div class="form-item">
                <label for="account_name">ユーザー名</label>
                <input id="account_name" type="text" name="account_name" required="required" placeholder="ユーザー名">
            </div>
            <div class="form-item">
                <label for="email">メールアドレス:</label>
                <input type="email" id="email" name="email" required="required" placeholder="メールアドレス"><br>
            </div>
            <div class="form-item">
                <label for="password">パスワード</label>
                <input id="password" type="password" name="password" required="required" placeholder="パスワード">
            </div>
            <div>
                <input id="password-display" type="checkbox">
                <label for="password-display">パスワードを表示</label>
            </div>
            <div class="button-panel">
                <input type="submit" value="送信" class="button">
                <!-- <input type="submit" class="button" title="サインイン" value="サインイン"> -->
            </div>
        </form>
        <div class="form-footer">
            <div class="login-link">
                アカウントをお持ちですか？ <a href="login.jsp">ログイン</a>
            </div>
            <!-- <p><a href="#">パスワードを忘れた場合</a></p> -->
        </div>
    </div>

    <!-- JavaScriptコード -->
    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function() {
            var passwordInput = document.getElementById('password');
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








<style>
/* フォント */
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400);

/* FontAwesome */
@import url(http://weloveiconfonts.com/api/?family=fontawesome);
[class*="fontawesome-"]:before {
  font-family: 'FontAwesome', sans-serif;
}

/* シンプルリセット */
* { margin: 0; padding: 0; box-sizing: border-box; }

/* body */
body {
  background: #e9e9e9;
  color: #5e5e5e;
  font: 400 87.5%/1.5em 'Open Sans', sans-serif;
}

/* フォームレイアウト */
.form-wrapper {
  background: #fafafa;
  margin: 3em auto;
  padding: 0 1em;
  max-width: 370px;
}

h1 {
  text-align: center;
  padding: 1em 0;
}

form {
  padding: 0 1.5em;
}

.form-item {
  margin-bottom: 0.75em;
  width: 100%;
}

.form-item input {
  background: #fafafa;
  border: none;
  border-bottom: 2px solid #e9e9e9;
  color: #666;
  font-family: 'Open Sans', sans-serif;
  font-size: 1em;
  height: 50px;
  transition: border-color 0.3s;
  width: 100%;
}

.form-item input:focus {
  border-bottom: 2px solid #c0c0c0;
  outline: none;
}

.button-panel {
  margin: 2em 0 0;
  width: 100%;
}

.button-panel .button {
  background: #f16272;
  border: none;
  color: #fff;
  cursor: pointer;
  height: 50px;
  font-family: 'Open Sans', sans-serif;
  font-size: 1.2em;
  letter-spacing: 0.05em;
  text-align: center;
  text-transform: uppercase;
  transition: background 0.3s ease-in-out;
  width: 100%;
}

.button:hover {
  background: #ee3e52;
}

.form-footer {
  font-size: 1em;
  padding: 2em 0;
  text-align: center;
}

.form-footer a {
  color: #8c8c8c;
  text-decoration: none;
  transition: border-color 0.3s;
}

.form-footer a:hover {
  border-bottom: 1px dotted #8c8c8c;
}

</style>
