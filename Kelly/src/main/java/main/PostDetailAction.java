package main;

import bean.Account;
import bean.Post;
import dao.FollowDao;
import dao.PostDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostDetailAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(); // セッション
		Account user =(Account)session.getAttribute("user");
		
		// 変数の定義
		String postIdStr=""; // 選択された投稿画像ID文字列
		int postID=0; // 数値に変換した投稿画像ID
		Post imgData=null;
		FollowDao fDao = new FollowDao();
		PostDao pDao=new PostDao(); // 投稿画像DAO
		
		// リクエストパラメータの取得
		postIdStr=req.getParameter("post_id");
		if (postIdStr==null) {
			postIdStr=(String)req.getAttribute("post_id");
		}
		// IDの数値変換
		if (postIdStr!=""){
			postID=Integer.parseInt(postIdStr);
		}
		
		// 情報の取得
		imgData=pDao.get(postID);
		
		if (imgData!=null) {
			// リクエストパラメータのセット
			req.setAttribute("post_data",imgData);
			req.setAttribute("account_id",user.getAccountId());
			req.setAttribute("follow_check",fDao);
		}
        // JSPへフォワード
        req.getRequestDispatcher("PostDetail.jsp").forward(req, res);
	}
}
