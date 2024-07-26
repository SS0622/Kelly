<!DOCTYPE html>
<html lang="ja">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/styles.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ログイン</title>
  <script type="text/javascript">
    $(function() {
      // 「パスワードを表示」が変更された時の処理
      $('#password-display').change(function() {
        if ($(this).prop('checked')) {
          // チェックが入っている場合
          // パスワード入力欄をテキストにする
          $('#password-input').attr('type', 'text');
        } else {
          // チェックが外れている場合
          // パスワード入力欄をパスワードにする
          $('#password-input').attr('type', 'password');
        }
      });
    });
  </script>
</head>
<body>
  <div class="form-wrapper">
    <h1>ログイン</h1>
    <form action="LoginExecute.action" method="post">
      <div class="form-item">
        <label for="id-input">ＩＤ</label>
        <input type="text" id="id-input" name="email" placeholder="ＩＤ" required>
      </div>
      <div class="form-item">
        <label for="password-input">パスワード</label>
        <input type="password" id="password-input" name="password" placeholder="パスワード" required>
      </div>
      <div class="form-check">
        <label class="form-check-label" for="password-display">
          <input class="form-check-input" id="password-display" type="checkbox">
          パスワードを表示
        </label>
      </div>
      <div class="button-panel">
        <input type="submit" class="button" title="ログイン" value="ログイン">
      </div>
    </form>
    <div class="form-footer">
      <p><a href="#">アカウントを作成する</a></p>
      <p><a href="#">パスワードをお忘れですか？</a></p>
    </div>
  </div>
</body>
</html>
