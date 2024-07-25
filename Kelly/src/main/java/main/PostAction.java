package main; // 担当:坪山 変数はこちらが合わせます。

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
		session.getAttribute("user");
		/*
//		#変数生成
		String picture_path = null;
		
//		#dao関連
		AccountDao accountDao = new AccountDao();
		Dao dao = new Dao();
//		Dao tagdao = new TagDao();
		String id = null;
		account_data = accountDao.get(id);*/
		
		
//		#dbアクセス(取得)
//		ここでdbからログインユーザーのidに紐づけられた
//		画像のファイルパスをlistで取得
//		listの型変換を行い、パスのlistデータと画像idをjspへ送る
//		jsp側では、ファイルパスを画面表示に利用、画像idを返り値
//		として使用
//		daoを作る方、新しい画像データが上に来るよう、名前などでの
//		ソートは控えていただけると幸いです。
//		（自ずと新旧順になっていると思います。多分。）
		
		
		
		
		
//		#送信データ変換
		
//		#送信データセット
//		req.setAttribute(pictures_id, pictures_id);
//		req.setAttribute(title, title);
//		req.setAttribute(date, date);
//		req.setAttribute(picture_path, picture_path);
		
		req.getRequestDispatcher("post.jsp").forward(req, res);
	}

}
