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
		
		// jspに渡す、タグ情報を入れるためのリストを用意
		String[] tags = {null, null, null, null, null};

		req.setAttribute("tags", tags);
		
		req.getRequestDispatcher("post.jsp").forward(req, res);
	}

}
