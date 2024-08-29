package main;

import java.util.ArrayList;
import java.util.List;

import bean.Account;
import bean.Post;
import dao.PostDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class PostSearchExecuteAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		System.out.println(account.getAccountName()+"さんが検索を実行");
		
		// 送信された入力の格納用
		String inputTxt=""; // 入力された検索内容
		String orderStr="1"; // 選択された並び順
		String modeStr="1"; // 選択された検索方法
		
		// 入力内容のセット
		inputTxt=req.getParameter("input_txt");
		orderStr=req.getParameter("order");
		modeStr=req.getParameter("mode");
		
		// 検索用の変数群を作成
		PostDao pDao =new PostDao();
		List<Post> posts = null;
		ArrayList<String> tags = new ArrayList<String>();
		
		// 入力の分割
		System.out.println(inputTxt);
		if (inputTxt.equals("")) {System.out.println("入力なし");}
		else {
			String[] inputs = inputTxt.split(" ");
	        for (int i = 0; i < inputs.length; i++) {
	        	tags.add(inputs[i]);
	        	System.out.println("検索タグ:"+inputs[i]);
	        }
		}
		
        // 検索の実行
		posts=pDao.search(tags,orderStr,modeStr);
		System.out.println("検索結果⇒"+posts.size()+"件");
		
		int orderInt=Integer.parseInt(orderStr); // 送信用並び順
		int modeInt=Integer.parseInt(modeStr); // 送信用検索方法
		
		// フォワード先へ送るデータをセット
		req.setAttribute("get_posts", posts); // 取得したリスト
		req.setAttribute("txtboxstr", inputTxt);
		req.setAttribute("selected_order", orderInt);
		req.setAttribute("selected_mode", modeInt);
		
		// JSPへフォワード
		req.getRequestDispatcher("search_post.jsp").forward(req, res);
	}
}
