package main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutExecuteAction extends Action{



	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(true);
		if(session != null){
			session.invalidate();
		}
        RequestDispatcher dispatcher =  req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, res);
	}

}