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
		Account checkAccount = null;
		Account saveAccount = null;
		Account successAccount = null;
		String error = "";
		
		id = req.getParameter("id");
		password = req.getParameter("password");
		accountName = req.getParameter("account_name");
		mail = req.getParameter("mail");
		
		checkAccount = accountDao.get(id);
		
		if (checkAccount == null) {
			saveAccount.setAccountId(id);
			saveAccount.setPassword(password);
			saveAccount.setAccountName(accountName);
			saveAccount.setMail(mail);
			
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
				url = "main/Menu.action";
				res.sendRedirect(url);
			} else {
				error = "存在するアカウントIDです";
			}
		}
		
	}
}

