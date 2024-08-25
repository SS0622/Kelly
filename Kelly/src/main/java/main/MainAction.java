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
		
		postList = postDao.search(tag);
		
		String url = "";
		
		url = "main.jsp";
		
		req.setAttribute("postList", postList);
		
		req.getRequestDispatcher(url).forward(req, res);
	}
}