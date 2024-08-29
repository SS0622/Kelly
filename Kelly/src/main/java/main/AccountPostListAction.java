package main;

import java.util.List;

import bean.Account;
import bean.Post;
import dao.AccountDao;
import dao.PostDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class AccountPostListAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		System.out.println(account.getAccountName()+"さんが検索を実行");
		
		
		// 検索用の変数群を作成
		PostDao pDao =new PostDao();
		AccountDao aDao = new AccountDao();
		List<Post> posts = null;
		String accId=""; // 対象のアカウントID
		String nameTxt="";
		
		// セット
		accId=req.getParameter("account_id");
        // 検索の実行
		posts=pDao.search2(accId);
		System.out.println("検索結果⇒"+posts.size()+"件");
		
		if (aDao.get(accId).getAccountId().equals(account.getAccountId())) {
			nameTxt="あなた";
		}else{
			nameTxt=aDao.get(accId).getAccountName()+" さん";
		}
		
		// フォワード先へ送るデータをセット
		req.setAttribute("get_posts", posts); // 取得したリスト
		req.setAttribute("name", nameTxt);
		
		req.getRequestDispatcher("account_post_list.jsp").forward(req, res);
	}
}
