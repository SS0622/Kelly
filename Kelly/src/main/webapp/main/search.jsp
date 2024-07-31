<%-- 担当: 井上 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.html"%>
    <title></title>
</head>
<body>
    <div class="container">
        <h2>検索</h2>
		
		<p>検索したいワードを入力してください。</p>
		<form action="Search.action" method="post">
		<input type="text" name="keyword">
		<input type="submit" value="検索">
		</form>
    </div>

<%@include file="footer.html"%>