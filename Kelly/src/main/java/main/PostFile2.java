package main; // 担当:坪山 変数はこちらが合わせます。

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
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

@MultipartConfig
@WebServlet(urlPatterns = {"/main/PostFile2"})
public class PostFile2 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("user");
		System.out.println("手描き投稿開始");

    	Post post = new Post();
		String picture;
		String title = req.getParameter("title");
		String caption = req.getParameter("caption");
        String[] tags = req.getParameterValues("tags[]");
        
        // 以下画像保存
        picture=req.getParameter("writing");
        String r_picture=picture.replace("data:image/png;base64,", "");
        
        // ファイル名生成
		String uniqueFileName= UUID.randomUUID().toString() + "_writing";
		System.out.println(uniqueFileName);
        
		// データ変換
        byte[] bytes = Base64.getDecoder().decode(r_picture);
        
		// ファイルの保存先
		Path uploadPath = Paths.get("/home/lg/tomcat/tomcat10/webapps/Kelly/upload"); // /home/lg/tomcat/tomcat10/webapps/Kelly/upload
        // 保存先ディレクトリが存在しない場合は作成
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        // 保存先ファイルの完全なパスを生成
        Path filePath2 = uploadPath.resolve(uniqueFileName);
        
        // ファイル保存
        FileOutputStream pngfile= new FileOutputStream(filePath2.toString()+".png");
        try {
        	pngfile.write(bytes);
        	System.out.println("保存成功");
        }catch (Exception e) {
	        throw new ServletException("File upload failed.", e);
	    }finally {
	    	pngfile.close();
	    }
        
		post.setAccID(account.getAccountId());
		post.setAlphaImg("../upload/");
		post.setBaseImg("../upload/"+uniqueFileName.toString());
		post.setTitle(title);
		post.setCaption(caption);
		post.setImgTags(tags);
		
		req.setAttribute("post", post);
		
        RequestDispatcher dispatcher = req.getRequestDispatcher("PostExecute.action");
        dispatcher.forward(req, res);
    }		
}