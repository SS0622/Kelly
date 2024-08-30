<%-- 担当: 平間 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログアウト確認</title>
    <!-- 外部CSSファイルへのリンク -->
    <link rel="stylesheet" href="../css/styles.css">
    <link rel="icon" href="../picture/favicon.png">
</head>
<body>
    <div class="form-wrapper">
        <h1>ログアウト確認</h1>
        
        <form action="Logout.action" method="post">
            <div id="content">
                <h2 style="text-align:center;">本当にログアウトしますか?</h2>
            </div>
            
            <div class="button-panel">
            
            <script type="text/javascript">
			    function execute() {
			        location.href = "./Logout.Execute.Action"
			    }
			</script>
			
				<a href="LogoutExecute.action" class="button"><h2 style="background-color: #f16272; height:50px; font-size:15px; text-align:center;  text-decoration: none;  "><p  style="transform: translateY(70%);">はい(ログアウトする)</p></h2></a>
				<!-- <br> -->
				<br>
	            <!-- <button id="end-btn" name="end" class="button" onclick="execute()">はい(ログアウトする)</button> -->
                <a href="Main.action" class="button"><h2 style="background-color: #f16272; height:50px; font-size:15px; text-align:center;  text-decoration: none;"><p  style="transform: translateY(70%);">いいえ(メインページへ戻る)</p></h2></a>
                <!-- <button id="cancel-btn" name="cancel" class="button" onclick="main.jsp">いいえ(メインページへ戻る)</button> -->
                
            </div>
        </form>
        <div class="form-footer">
            <br>
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
a {
  text-decoration: none;
}
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
