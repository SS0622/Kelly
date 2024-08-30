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
		Account account = (Account)session.getAttribute("user");
		
		
		if (account!=null) {
			
			String name = req.getParameter("name");
			System.out.println(name);
			AccountDao accountDao = new AccountDao();
			
			account.setAccountName(name);
			System.out.println(account.getAccountName());
			
//			#dbアクセス(保存)
			accountDao.update(account);
			
			Account acc = accountDao.get(account.getAccountId());
			System.out.println(acc.getAccountName());
			// セッションにログイン情報を保存
			session.setAttribute("user", acc);
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
