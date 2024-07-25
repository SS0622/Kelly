package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Post;

public class PostDao extends Dao{
	
	public boolean save(Post post) throws Exception {
		// コネクションの確立
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		
		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("insert into POST(ACCOUNT_ID,TAG_1,TAG_2,"
					+ "TAG_3,TAG_4,TAG_5,PICTURE_1,PICTURE_2,TITLE,CAPTION)"
					+ " VALUES ('?','?','?','?','?','?','?','?','?','?')");
			// プリペアードステートメントにアカウントIDをバインド
			statement.setString(1, post.getAccID());
			statement.setString(2, post.getImgTags()[0]);
			statement.setString(3, post.getImgTags()[1]);
			statement.setString(4, post.getImgTags()[2]);
			statement.setString(5, post.getImgTags()[3]);
			statement.setString(6, post.getImgTags()[4]);
			statement.setString(7, post.getAlphaImg());
			statement.setString(8, post.getBaseImg());
			statement.setString(9, post.getTitle());
			statement.setString(10, post.getCaption());
			
			// プリペアードステートメントを実行
			statement.executeQuery();
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return true;
	}
	
	public Post get(String[] tags) {
		
	}
}
