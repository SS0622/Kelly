
<%@include file="../common/header.html" %>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign In</title>
</head>
<body>
  <div class="form-wrapper">
    <h1>Log In</h1>
    <form>
      <div class="form-item">
        <label for="id"></label>
        <input type="id" name="email" placeholder="ID">
      </div>
      <div class="form-item">
        <label for="password"></label>
        <input type="password" name="password"placeholder="Password">
      </div>
      <div class="button-panel">
        <input type="submit" class="button" title="Sign In" value="Log in">
      </div>
    </form>
    <div class="form-footer">
      <p><a href="#">Create an account</a></p>
      <p><a href="#">Forgot password?</a></p>
    </div>njmh
  </div>
</body>
</html>
