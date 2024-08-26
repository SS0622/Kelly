package main; // 担当:坪山 変数はこちらが合わせます。

import bean.Account;
import bean.Post;
import dao.PostDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

//		#session関連
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		
//		#変数生成
		boolean success=false;
		Post post = (Post) req.getAttribute("post");
		
		PostDao postDao = new PostDao();
		
//		#dbアクセス(保存)
		success = postDao.save(post);
		
		if(success) {
			req.getRequestDispatcher("main.jsp").forward(req, res);
		}else {
			req.getRequestDispatcher("post.jsp").forward(req, res);
		}
//		#送信データ変換
		
//		#送信データセット
//		req.setAttribute(post_succeed, post_succeed);
		
	}

}
