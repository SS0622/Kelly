package main;

import java.util.ArrayList;

import bean.Account;
import bean.Post;
import dao.PostDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class MainAction extends Action {
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		if (account!=null) {
			PostDao postDao = new PostDao();
			ArrayList<Post> postList = new ArrayList<Post>();
			ArrayList<String> tag = new ArrayList<String>();
			String orderStr="1"; // 選択された並び順
			String modeStr="1"; // 選択された検索方法
			
			postList = postDao.search(tag,orderStr,modeStr);
			
			String url = "";
			
			url = "main.jsp";
			
			req.setAttribute("postList", postList);
			req.setAttribute("account", account);
			
			req.getRequestDispatcher(url).forward(req, res);
		}else{
			System.out.println("未ログインを確認");
			res.sendRedirect("Login.action");
		}
	}
}