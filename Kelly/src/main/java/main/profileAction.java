package main;

import bean.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class profileAction extends Action {
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception{
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		
		String url = "";
		
		url = "profile.jsp";
		
		req.setAttribute("account", account);
		
		req.getRequestDispatcher(url).forward(req, res);
	}
}

