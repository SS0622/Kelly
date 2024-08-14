package main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SignUpAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		req.getRequestDispatcher("new_account.jsp").forward(req, res);
	}
}
