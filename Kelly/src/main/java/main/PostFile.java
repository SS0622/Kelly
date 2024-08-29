package main; // 担当:坪山 変数はこちらが合わせます。

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import bean.Account;
import bean.Post;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet(urlPatterns = {"/main/PostFile"})
public class PostFile extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

//		#session関連
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		
		Post post = new Post();
		Part picture1;
		Part picture2;
		String title = req.getParameter("title");
		String caption = req.getParameter("caption");
        String[] tags = req.getParameterValues("tags[]");
        
	    try {
			picture2 = req.getPart("picture2");
	        if (picture2 == null) {
	            req.getRequestDispatcher("post.jsp").forward(req,  res);
	        }
	        
	    } catch (IllegalStateException e) {
	        throw new ServletException("Multipart configuration is not provided.", e);
	    } catch (Exception e) {
	        throw new ServletException("File upload failed.", e);
	    }
		
		// UUID を生成してファイル名に追加
		String originalFileName2 = picture2.getSubmittedFileName();
		String uniqueFileName2= UUID.randomUUID().toString() + "_" + originalFileName2;
		
		// ファイルの保存先
		Path uploadPath = Paths.get("/home/lg/tomcat/tomcat10/webapps/Kelly/upload");//
									// /home/lg/tomcat/tomcat10/webapps/Kelly/upload
        // 保存先ディレクトリが存在しない場合は作成
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 保存先ファイルの完全なパスを生成
        Path filePath2 = uploadPath.resolve(uniqueFileName2);

        // ファイルを指定されたパスに保存
        picture2.write(filePath2.toString());
	
		post.setAccID(account.getAccountId());
		post.setAlphaImg("../upload/");
		post.setBaseImg("../upload/"+uniqueFileName2.toString());
		post.setTitle(title);
		post.setCaption(caption);
		post.setImgTags(tags);

		req.setAttribute("post", post);
		
        RequestDispatcher dispatcher = req.getRequestDispatcher("PostExecute.action");
        dispatcher.forward(req, res);
    }
		
}