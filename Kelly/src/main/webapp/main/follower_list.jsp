<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.util.ArrayList,java.util.List,bean.Post,bean.Account,dao.FollowDao,bean.Follow" %>
<!DOCTYPE html>
<html lang="ja">

<head>

    <meta charset="UTF-8">
    <title>あなたをフォローしているアカウント一覧</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="test.css">
    <link rel="shortcut icon" href="picture/pic1.png">

    <link rel="icon" href="../picture/favicon.png">
</head>

<body>

  <!--ヘッダー-->
  <header>
    <p>　</p>
    <!--https://www.asobou.co.jp/blog/web/css-menu-->
    <!-- <h1><img id="headerpng" src="../picture/lg.png" alt="タイトル写真"></h1> -->
    <h1><summary style="font-size: 80px;">Legal-Graffiti</summary></h1>
    
  </header>
  <!--/ヘッダー-->

  <div id="wrapper">
    <div id="main">
    <section id="point">
      <summary><h2>あなたをフォローしているアカウント</h2></summary>
        <h2 style="color:black;">
            <%
           	List<Follow> followers = (List<Follow>) request.getAttribute("follower_list");
            FollowDao fDao = (FollowDao) request.getAttribute("follow_check");
            String accId = (String) request.getAttribute("account_id");
			if (followers!=null&&followers.size()>=1) {
			%>
				<p>アカウント数 <%=followers.size() %>件</p>
				<%
	        	for(int i=0;i<followers.size();i++){
	            %>
	            <hr>
	            <div>
	            <a style="color:black;" href="AccountPostList.action?account_id=<%=followers.get(i).getAccData().getAccountId() %>"><p><%=followers.get(i).getAccData().getAccountName() %><p></a>
	            <br>
				  	<%
				  	if (fDao.get(accId, followers.get(i).getAccData().getAccountId())==null){
				  	%>
		            <a style="color:black;" href="FollowExecute.action?acc=<%=followers.get(i).getAccData().getAccountId() %>&page=3"><p><font size="2">このアカウントをフォローする</font></p></a>
				  	<%
				  	}else{
				  	%>
				  	<a style="color:black;" href="UnFollowExecute.action?acc=<%=followers.get(i).getAccData().getAccountId() %>&page=3"><p><font size="2">このアカウントのフォローを解除する</font></p></a>
				  	<%
				  	}
				  	%>
	           	<%
	        	}
	           	%>
			<%
			}
			%>    
        </h2>
 
        <!-- <hr> -->

    </div>
        <!--サイド-->
        <aside id="sidebar">
          <section id="side_banner">
            <!-- <h2>link</h2> -->
            <ul>
            <h2 style="background-color: #f27000;"><a href="Main.action" class="button">メインページへ</a></h2>
            <h2 style="background-color: #f27000;"><a href="Post.action" class="button">投稿ページへ</a></h2>
            <h2 style="background-color: #f27000;"><a href="DrawPost.action" class="button">手書き投稿ページへ</a></h2>
            <h2 style="background-color: #f27000;"><a href="PostSearch.action" class="button">作品を検索する</a></h2>
            <h2 style="background-color: #f27000;"><a href="profile.action" class="button">アカウント名変更</a></h2>
            <h2 style="background-color: #f27000;"><a href="FollowList.action" class="button">フォロー一覧</a></h2>
            
            <h2 style="background-color: #f27000;"><a href="Logout.action" class="button">ログアウト</a></h2>        
            </ul>
          </section>
          <section id="side_contact">
          </section>
        </aside>
        <!--/サイド-->
    </section>
  </div>
  <footer>
    <h3>&copy;Legal-Graffiti制作チーム</h3>
  </footer>
  <!--/フッター-->

</body>

</html>


<style>

    @charset "utf-8";
    body {
      color: rgb(255, 255, 255);
      background: linear-gradient(90deg, #ffffff, #e9e9e9);
    }
    a { color:rgb(255, 255, 255); }
    img{
      width: 100px;
    }
    header{
      text-align: center;
    }
    .menu-content{
      text-align: center;
    }
    #namae{
      float: right;
      width: 700px;
    }
    footer{
      text-align: right;
      color: #fff;
      background-color: #f27000;
    }
    #gazo{
      width: 347px;
    }
    
    #map{
      filter: grayscale(100%) invert(100%) contrast(100%);
    }
    
    .body1{
        width:100%;
        height:400px;
        position:relative;
        z-index: -1;
        /*background: url("base_size.png") no-repeat  bottom;*/
        /*background-size:auto;*/
        width:100%;
        height:1000px;  
        /*text-align: center;*/
      }
      #video {
         width:auto;
         height:auto;
         /*overflow:hidden;*/
         display: flex;
         position: absolute;
         z-index:-1;
      }
      #main h1{
        font-size: 30px;
        color: white;
      }
      #main h2{
        font-size:30px;
        color: white;
        border: 3px solid #2299ff;
        padding: 11px 22px;
      }
      #main h3{
        text-align: right;
        font-size:15px;
        color:#ffffff;
    
    
        padding: 11px 22px;
      }
      li{
        font-size: 20px;
      }
      p{
        font-size: 20px;
      }
      summary{
        font-size: 25px;
        background-color: #2299ff;
        width: auto;
      }
      details[open] > summary {
        background-color: #2299ff;
      }
    
    
    #headerpng{
      width: 940px;
    }
    
    /*ここから下コピペ改造したやつ*/
    
    
    
    
    #wrapper{
      width: 940px;
      margin: 0 auto;
      overflow: hidden;
    }
    #main {
      width: 700px;
      float: left;
    }
    #sidebar {
      width: 220px;
      float: right;
    }
    #side_banner { margin-bottom: 30px; }
    #side_banner h2 {
      background-color: #2299ff;
      color: #fff;
      padding: 7px;
      font-size: 14px;
      text-align: center;
    }
    #side_banner ul {
      list-style: none;
      margin: 0;
      padding: 0;
    }
    #side_banner ul li { margin-bottom: 10px; }
    
    
    
    
    
    
    
    
    .menu-btn {
        position: fixed;
        top: 10px;
        left: 10px;
        display: flex;
        height: 60px;
        width: 60px;
        justify-content: center;
        align-items: center;
        z-index: 90;
        background-color: #002c4b;
    }
    .menu-btn span,
    .menu-btn span:before,
    .menu-btn span:after {
        content: '';
        display: block;
        height: 3px;
        width: 25px;
        border-radius: 3px;
        background-color: #ffffff;
        position: absolute;
    }
    .menu-btn span:before {
        bottom: 8px;
    }
    .menu-btn span:after {
        top: 8px;
    }
    #menu-btn-check:checked ~ .menu-btn span {
        background-color: #0d1536;/*メニューオープン時は真ん中の線を透明にする*/
    }
    #menu-btn-check:checked ~ .menu-btn span::before {
        bottom: 0;
        transform: rotate(45deg);
    }
    #menu-btn-check:checked ~ .menu-btn span::after {
        top: 0;
        transform: rotate(-45deg);
    }
    #menu-btn-check {
        display: none;
    }
    .menu-content {
        margin-top: auto;
        width: 50%;
        height: 100%;
        position: fixed;
        top: 0;
        right: 100%;/*leftの値を変更してメニューを画面外へ*/
        z-index: 80;
        background-color: #0d1536;
        transition: all 0.5s;/*アニメーション設定*/
    }
    .menu-content ul {
        padding: 70px 10px 0;
    }
    .menu-content ul li {
        border-bottom: solid 1px #ffffff;
        list-style: none;
    }
    .menu-content ul li a {
        display: block;
        width: 100%; /*左寄せ*/
        font-size: 25px;
        box-sizing: border-box;
        color:#ffffff;
        text-decoration: none;
        padding: 9px 15px 10px 0;
        position: relative;
    }
    #menu-btn-check:checked ~ .menu-content {
        left: 0;
    }
    
    
    
    
    
    
    @media screen and (max-width : 767px){
      img {
        max-width: 100%;
      }
      header,
      #global_navi,
      #sidebar,
      #wrapper{
        width: 100%;
      }  
      header h1 {
        float: none;
        text-align: center;
      }
      header h1 img {
        width: 50%;
      }
      header #header_contact {
        display: none;
      }
      #global_navi ul li {
        width: 50%;
        padding: 0.5px;
        margin: 0;
        box-sizing: border-box;
      }
      #global_navi ul li a {
        margin: 0;
      }
      #global_navi ul li:last-child {
        width: 100%;
      }
      #main {
        width: 100%;
        padding: 0 5%;
        box-sizing: border-box;
      }
      #main figure {
        text-align: center;
      }
      #main_visual {
        width: 100%;
        height: auto;
      }
      #point figure {
        float: none;
        margin: 0 0 11px 0;
      }
      #side_banner ul li {
        text-align: center;
        margin: 11px auto;
      }
      #side_contact address img {
        width: 14px;
        height: 20px;
      }
      #entry dl dt {
        float: none;
        width: 100%;
        box-sizing: border-box;
      }
      #entry dl dd {
        width: 100%;
        margin-left: 0;
        border-left: none;
        box-sizing: border-box;
      }
      #entry #name, #entry #email, #entry #interest {
        max-width: 100%;
      }
      #entry #detail {
        width: 100%;
        box-sizing: border-box;
      }
      #h2{
        font-size: 20px;
      }
      #p{
        font-size: 20px;
      }
    }

</style>