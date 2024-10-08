package main;

import bean.Account;
import dao.PostDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostDeleteAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		if (account!=null) {
			System.out.println("作品削除");
			
			PostDao deleter = new PostDao();
			String postId=""; // 対象の投稿ID
			String pageType=""; // 戻すページの種類
			
			// セット
			postId=req.getParameter("postid");
			pageType=req.getParameter("page");
			System.out.println(postId);
			
			System.out.println(deleter.delete(postId));
			
			if (pageType.equals("1")) {
				req.getRequestDispatcher("Main.action").forward(req, res);
			}
		}else{
			System.out.println("未ログインを確認");
			res.sendRedirect("Login.action");
		}
	}
}
