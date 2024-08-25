package main;

import java.util.List;

import bean.Account;
import bean.Follow;
import dao.AccountDao;
import dao.FollowDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class FollowerListAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		System.out.println(account.getAccountId()+"さんが検索を実行");
		
		// 検索用の変数群を作成
		FollowDao fDao=new FollowDao();
		List<Follow> follows = null;
		AccountDao aDao=new AccountDao();
		
		// 検索
		follows=fDao.allFollower(account.getAccountId());
		
		// フォワード先へ送るデータをセット
		req.setAttribute("follower_list", follows); // 取得したリスト

		// JSPへフォワード
		req.getRequestDispatcher("follower_list.jsp").forward(req, res);
	}
}
