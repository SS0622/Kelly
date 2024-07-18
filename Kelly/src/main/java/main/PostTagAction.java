package main; // 担当:坪山 変数はこちらが合わせます。

import java.util.ArrayList;
import java.util.List;

import bean.Account;
import bean.User;
import dao.Dao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostTagAction extends Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
//		#session関連
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
//		#変数生成
		List<String> tags = new ArrayList();
		String taglist = null;
		
//		#dao関連
		Account account_data = null;
		Dao dao = new Dao();
		
//		#jspからデータ受信
		String p_id = req.getParameter("pictures_id");
		
//		#dbアクセス(取得)
		
		
		
		
		
//		#送信データ変換
		

//		#送信データセット 
		// 当方post_tag.jspは投稿前確認ページという認識です。
		req.setAttribute(taglist, tags);
		req.setAttribute(p_id, p_id);
		req.getRequestDispatcher("post_tag.jsp").forward(req, res);
	}

}