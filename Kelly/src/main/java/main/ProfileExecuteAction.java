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
		System.out.print("bbb");
		
//		#変数生成
		Account account = (Account) req.getAttribute("account");
		if (account!=null) {
			AccountDao accountDao = new AccountDao();
			
//			#dbアクセス(保存)
			accountDao.update(account);
			
				// セッションにログイン情報を保存
				session.setAttribute("user", account);
				res.sendRedirect("Main.action");

//			#送信データ変換
			
//			#送信データセット
//			req.setAttribute(post_succeed, post_succeed);
		}else{
			System.out.println("未ログインを確認");
			res.sendRedirect("Login.action");
		}
	}
}
