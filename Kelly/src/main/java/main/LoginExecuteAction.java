package main;

import java.util.ArrayList;
import java.util.List;

import bean.Account;
import dao.AccountDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class LoginExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		String url = "";
		String id = "";
		String password = "";
		AccountDao accountDao = new AccountDao();
		Account account = null;

		//リクエストパラメータ―の取得 2
		id = req.getParameter("account_id");// ユーザーID
		password = req.getParameter("password");//パスワード

		//DBからデータ取得 3
		account = accountDao.get(id);//アカウントデータ取得

		//条件で手順4~7の内容が分岐
		if (account != null && account.getPassword().equals(password)) {// 
			// セッション情報を取得
			HttpSession session = req.getSession(true);
			// 認証済みフラグを立てる
			account.setAuthenticated(true);
			// セッションにログイン情報を保存
			session.setAttribute("user", account);
	
			//リダイレクト
			url = "Main.action";
			req.getRequestDispatcher(url).forward(req, res);
		} else {

			// 認証失敗の場合
			// エラーメッセージをセット
			List<String> errors = new ArrayList<>();
			errors.add("IDまたはパスワードが確認できませんでした");
			req.setAttribute("errors", errors);
			// 入力された教員IDをセット
			req.setAttribute("id", id);

			//フォワード
			url = "login.jsp";
			req.getRequestDispatcher(url).forward(req, res);
		}

//		req.getRequestDispatcher(url).forward(req, res);
	}

}