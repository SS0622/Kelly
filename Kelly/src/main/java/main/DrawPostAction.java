package main; // 担当:坪山 変数はこちらが合わせます。

import bean.Account;
//import dao.TagDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class DrawPostAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
//		#session関連
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");

		req.setAttribute("acc", account);
		
		req.getRequestDispatcher("draw_post.jsp").forward(req, res);
	}

}
