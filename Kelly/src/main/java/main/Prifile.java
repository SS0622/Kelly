package main; // 担当:坪山 変数はこちらが合わせます。

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import bean.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet(urlPatterns = {"/main/Profile"})
public class Prifile extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

//		#session関連
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		
		Part icon;
		String name = req.getParameter("name");
        
	    try {
			icon = req.getPart("picture2");
	        if (icon == null) {
	            req.getRequestDispatcher("post.jsp").forward(req,  res);
	        }
	        
	    } catch (IllegalStateException e) {
	        throw new ServletException("Multipart configuration is not provided.", e);
	    } catch (Exception e) {
	        throw new ServletException("File upload failed.", e);
	    }
		
		// UUID を生成してファイル名に追加
		String originalFileName = icon.getSubmittedFileName();
		String uniqueFileName= UUID.randomUUID().toString() + "_" + originalFileName;
		
		// ファイルの保存先
		Path uploadPath = Paths.get("C:/Users/ebinuma/git/Kelly2/Kelly/src/main/webapp/upload");// C:/upload
									// /home/lg/tomcat/tomcat10/webapps/Kelly/upload
        // 保存先ディレクトリが存在しない場合は作成
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 保存先ファイルの完全なパスを生成
        Path filePath2 = uploadPath.resolve(uniqueFileName);

        // ファイルを指定されたパスに保存
        icon.write(filePath2.toString());
	
        account.setAccountName(name);
		account.setIconPath("../upload/"+uniqueFileName.toString());

		req.setAttribute("account", account);
		
		res.sendRedirect("ProfileExecute.action");
    }
		
}