package main;

import bean.Account;
import dao.AccountDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class ProfileExecuteAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

//		#session関連
		HttpSession session = req.getSession();
		
//		#変数生成
		boolean success=false;
		Account account = (Account) req.getAttribute("account");
		
		AccountDao accountDao = new AccountDao();
		
//		#dbアクセス(保存)
		success = accountDao.save(account);
		
		if(success) {
			// セッションにログイン情報を保存
			session.setAttribute("user", account);
			res.sendRedirect("Main.action");
		}else {
			req.getRequestDispatcher("post.jsp").forward(req, res);
		}
//		#送信データ変換
		
//		#送信データセット
//		req.setAttribute(post_succeed, post_succeed);
		
	}
}
