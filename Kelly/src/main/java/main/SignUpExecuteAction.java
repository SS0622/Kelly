package main;

import bean.Account;
import dao.AccountDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;
 

public class SignUpExecuteAction extends Action {
	@SuppressWarnings("null")
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		//ローカル変数の宣言 1
		boolean flag=false;
		String url = "";
		String id = "";
		String password = "";
		String mail = "";
		String accountName = "";
		AccountDao accountDao = new AccountDao();
		boolean checkAccount = false;
		Account saveAccount = new Account();
		Account successAccount = null;
		String error = "";
		
		id = req.getParameter("userId");
		password = req.getParameter("password");
		accountName = req.getParameter("account_name");
		mail = req.getParameter("email");
		
		checkAccount = accountDao.check(id,mail);
		
		if (checkAccount == true) {
			System.out.println("作成許可");
			saveAccount.setAccountId(id);
			saveAccount.setPassword(password);
			saveAccount.setAccountName(accountName);
			saveAccount.setMail(mail);
			
			System.out.println(saveAccount.getAccountId());
			System.out.println(saveAccount.getAccountName());
			
			flag = accountDao.save(saveAccount);
			
			if (flag) {
				successAccount = accountDao.get(id);
				// セッション情報を取得
				HttpSession session = req.getSession(true);
				// 認証済みフラグを立てる
				successAccount.setAuthenticated(true);
				// セッションにログイン情報を保存
				session.setAttribute("user", successAccount);
		
				//リダイレクト
				url = "Main.action";
				req.getRequestDispatcher(url).forward(req, res);
			}
		} else {
			System.out.println("作成却下");
			error = "ユーザーIDもしくはメールアドレスが既存です";
			req.setAttribute("error", error);
			url = "new_account.jsp";
			req.getRequestDispatcher(url).forward(req, res);
		}
		
	}
}

