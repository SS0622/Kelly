package tool;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("main/logViewer")
public class ErrorAction extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 例: ログ情報をセッションに保存する
        request.setAttribute("logs", LogHolder.getLogs());

        // JSPにフォワード
        request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
}