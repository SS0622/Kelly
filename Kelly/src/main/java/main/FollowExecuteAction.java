package main;

import bean.Account;
import dao.FollowDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class FollowExecuteAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		System.out.println("フォロー追加");

		// 変数群を作成
		FollowDao fDao=new FollowDao();
		String accId=""; // 対象のアカウントID
		String pageType=""; // 戻すページの種類
		String postId=""; // 戻すページが画像詳細であった場合の投稿ID
		
		// セット
		accId=req.getParameter("acc");
		pageType=req.getParameter("page");
		postId=req.getParameter("post");
		
		fDao.save(account.getAccountId(), accId);
		
		if (pageType.equals("1")) {
			req.setAttribute("post_id",postId);
			req.getRequestDispatcher("PostDetail.action").forward(req, res);
		}else if (pageType.equals("2")) {
			req.getRequestDispatcher("FollowList.action").forward(req, res);
		}else if (pageType.equals("3")) {
			req.getRequestDispatcher("FollowerList.action").forward(req, res);
		}
	}
}
