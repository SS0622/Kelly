package main; // 担当:坪山 変数はこちらが合わせます。

import java.util.ArrayList;

import bean.Account;
import dao.PostDao;
//import dao.TagDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		#session関連
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		if (account!=null) {
			PostDao postDao = new PostDao();
			
			// jspに渡す、タグ情報を入れるためのリストを用意
			String[] tags = {null, null, null, null, null};
			
			// ユーザーが登録したことのある画像からタグ履歴を取得する
			ArrayList<String> tags_history = postDao.tagHistory(account.getAccountId());

			req.setAttribute("tags", tags);
			req.setAttribute("tags_history", tags_history);
			
			req.getRequestDispatcher("post.jsp").forward(req, res);
		}else{
			System.out.println("未ログインを確認");
			res.sendRedirect("Login.action");
		}
	}

}
