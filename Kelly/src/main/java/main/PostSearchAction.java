package main;

import bean.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostSearchAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		if (account!=null) {
			// JSPへフォワード
			req.getRequestDispatcher("search_post.jsp").forward(req, res);
		}else{
			System.out.println("未ログインを確認");
			res.sendRedirect("Login.action");
		}
	}
}
