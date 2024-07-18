package main; // 担当:坪山 変数はこちらが合わせます。

import bean.Account;
import bean.User;
import dao.Dao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

//		#session関連
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
//		#変数生成
		
//		#dao関連
		Account account_data = null;
		Dao dao = new Dao();
		
//		#jspからデータ受信
		String p_id = req.getParameter("pictures_id");
		String tag = req.getParameter("tag");
		
//		#dbアクセス(保存)
		
		
		
		
		
//		#送信データ変換
		
//		#送信データセット
//		req.setAttribute(post_succeed, post_succeed);
		req.getRequestDispatcher("home.jsp").forward(req, res);
	}

}
