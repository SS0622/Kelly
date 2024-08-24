package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class PostSearchAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// JSPへフォワード
		req.getRequestDispatcher("search_post.jsp").forward(req, res);
	}
}
