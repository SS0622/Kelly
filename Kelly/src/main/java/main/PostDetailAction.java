package main;

import bean.Post;
import dao.PostDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostDetailAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(); // セッション
		//Account user =(Account)session.getAttribute("user");
		
		// 変数の定義
		String postIdStr=""; // 選択された投稿画像ID文字列
		int postID=0; // 数値に変換した投稿画像ID
		Post imgData=null;
		PostDao pDao=new PostDao(); // 投稿画像DAO
		
		// リクエストパラメータの取得
		postIdStr=req.getParameter("post_id");
		// IDの数値変換
		if (postIdStr!=""){
			postID=Integer.parseInt(postIdStr);
		}
		
//		// 情報の取得
//		imgData=pDao.get(postID);
//		
//		if (imgData!=null) {
//			// リクエストパラメータのセット
//			req.setAttribute("post_id",imgData.getPostID());
//			req.setAttribute("account_id",imgData.getAccID());
//			req.setAttribute("img_tags",imgData.getImgTags());
//			req.setAttribute("front_img",imgData.getAlphaImg());
//			req.setAttribute("back_img",imgData.getBaseImg());
//			req.setAttribute("img_title",imgData.getTitle());
//			req.setAttribute("img_caption",imgData.getCaption());
//		}
//        // JSPへフォワード
//        req.getRequestDispatcher("フォワード先のJSP").forward(req, res);
	}
}
