package main;

import bean.Account;
import dao.FollowDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class UnFollowExecuteAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		System.out.println("フォロー解除");

		// 変数群を作成
		FollowDao fDao=new FollowDao();
		String accId=""; // 対象のアカウントID
		String pageType=""; // 戻すページの種類
		String postId=""; // 戻すページが画像詳細であった場合の投稿ID
		
		// セット
		accId=req.getParameter("acc");
		pageType=req.getParameter("page");
		postId=req.getParameter("post");
		
		fDao.delete(account.getAccountId(), accId);
		
		if (pageType.equals("1")) {
			req.setAttribute("post_id",postId);
			req.getRequestDispatcher("PostDetail.action").forward(req, res);
		}
	}
}
