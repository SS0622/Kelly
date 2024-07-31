package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class MainAction extends Action {
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		HttpSession session = req.getSession();
		
		String url = "";
		
		url = "main.jsp";
		
		req.getRequestDispatcher(url).forward(req, res);
	}
}