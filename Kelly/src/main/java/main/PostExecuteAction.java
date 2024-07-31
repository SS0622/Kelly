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
		Post post = new Post();
		String alpha = req.getParameter("picture1");
		String base = req.getParameter("pictere2");
		String title = req.getParameter("title");
		String caption = req.getParameter("caption");
		String[] tags = req.getParameterValues("tags");
		
//		#dao関連
		PostDao postDao = new PostDao();
		
		post.setAccID(account.getAccountId());
		post.setAlphaImg(alpha);
		post.setBaseImg(base);
		post.setTitle(title);
		post.setCaption(caption);
		post.setImgTags(tags);
		
//		#dbアクセス(保存)
		success = postDao.save(post);
		
		if(success) {
			req.getRequestDispatcher("home.jsp").forward(req, res);
		}else {
			req.getRequestDispatcher("post.jsp").forward(req, res);
		}
//		#送信データ変換
		
//		#送信データセット
//		req.setAttribute(post_succeed, post_succeed);
		
	}

}
