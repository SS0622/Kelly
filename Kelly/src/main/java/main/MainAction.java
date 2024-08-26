package main;

import java.util.ArrayList;

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
		
		PostDao postDao = new PostDao();
		ArrayList<Post> postList = new ArrayList<Post>();
		ArrayList<String> tag = new ArrayList<String>();
		String orderStr="1"; // 選択された並び順
		String modeStr="1"; // 選択された検索方法
		
		postList = postDao.search(tag,orderStr,modeStr);
		
		String url = "";
		
		url = "main.jsp";
		for(int i=0;i<postList.size();i++) {
			System.out.println(i);
			System.out.println(postList.get(i));
		}
		System.out.println(postList.get(0).getBaseImg());
		
		req.setAttribute("postList", postList);
		
		req.getRequestDispatcher(url).forward(req, res);
	}
}