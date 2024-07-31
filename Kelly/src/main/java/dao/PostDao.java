package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Post;

public class PostDao extends Dao{
	
	// 画像投稿保存
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
	
	// 投稿詳細
	public Post get(int post_id) throws Exception {
		Post post = new Post();
		// コネクションの確立
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from POST where POST_ID=?");
			
			statement.setInt(1, post_id);
			
			ResultSet rSet = statement.executeQuery();
			
			if(rSet.next()) {
				String[] tags = new String[] {null, null, null, null, null};
				post.setPostID(post_id);
				post.setAccID(rSet.getString("account_id"));
				
				tags[0]=rSet.getString("tag_1");
				tags[1]=rSet.getString("tag_2");
				tags[2]=rSet.getString("tag_3");
				tags[3]=rSet.getString("tag_4");
				tags[4]=rSet.getString("tag_5");
				
				post.setImgTags(tags);
				post.setAlphaImg(rSet.getString("picture_1"));
				post.setBaseImg(rSet.getString("picture_2"));
				post.setTitle(rSet.getString("title"));
				post.setCaption(rSet.getString("caption"));
			}else {
				post = null;
			}
			
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
		
		return post;
	}
	
	// タグ検索
	public ArrayList<Post> search(ArrayList<String> tags) throws Exception{

		ArrayList<Post> postList = new ArrayList<>();
		
		// コネクションの確立
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		
		StringBuilder TAGsql = new StringBuilder("");
		int siz = 0;
		
		for(String tag : tags) {
			if(siz == 0) {
				TAGsql.append(" where ");
			}else{
				TAGsql.append(" and ");
			}
			TAGsql.append("(TAG_1 = ");
			TAGsql.append(tag);
			TAGsql.append(" or TAG_2 = ");
			TAGsql.append(tag);
			TAGsql.append(" or TAG_3 = ");
			TAGsql.append(tag);
			TAGsql.append(" or TAG_4 = ");
			TAGsql.append(tag);
			TAGsql.append(" or TAG_5 = ");
			TAGsql.append(tag);
			TAGsql.append(")");
			
			 //(TAG_1 = ? or TAG_2 = ? or TAG_3 = ? or TAG_4 = ? or TAG_5 = ?)
		}
		
		try {
			statement = connection.prepareStatement("select * from POST" + TAGsql);
			
			ResultSet rSet = statement.executeQuery();
			
			if(rSet.next()) {
				Post post = new Post();
				String[] tagList = new String[] {null, null, null, null, null};
				post.setPostID(rSet.getInt("post_id"));
				post.setAccID(rSet.getString("account_id"));
				
				tagList[0]=rSet.getString("tag_1");
				tagList[1]=rSet.getString("tag_2");
				tagList[2]=rSet.getString("tag_3");
				tagList[3]=rSet.getString("tag_4");
				tagList[4]=rSet.getString("tag_5");
				
				post.setImgTags(tagList);
				post.setAlphaImg(rSet.getString("picture_1"));
				post.setBaseImg(rSet.getString("picture_2"));
				post.setTitle(rSet.getString("title"));
				post.setCaption(rSet.getString("caption"));
				
				postList.add(post);
			}
			
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
		
		return postList;
	}
	
	// ユーザーのタグ履歴を取得
	public ArrayList<String> tagHistory(String account_id) throws Exception{
		ArrayList<String> tagsList = new ArrayList<>();
		// コネクションの確立
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		
		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("SELECT TAGS, MAX(CREATED_AT) AS CREATED_AT\r\n"
					+ "FROM (\r\n"
					+ "    SELECT TAG_1 AS TAGS, CREATED_AT\r\n"
					+ "    FROM POST\r\n"
					+ "    WHERE ACCOUNT_ID = '?'\r\n"
					+ "    UNION ALL\r\n"
					+ "    SELECT TAG_2 AS TAGS, CREATED_AT\r\n"
					+ "    FROM POST\r\n"
					+ "    WHERE ACCOUNT_ID = '?'\r\n"
					+ "    UNION ALL\r\n"
					+ "    SELECT TAG_3 AS TAGS, CREATED_AT\r\n"
					+ "    FROM POST\r\n"
					+ "    WHERE ACCOUNT_ID = '?'\r\n"
					+ "    UNION ALL\r\n"
					+ "    SELECT TAG_4 AS TAGS, CREATED_AT\r\n"
					+ "    FROM POST\r\n"
					+ "    WHERE ACCOUNT_ID = '?'\r\n"
					+ "    UNION ALL\r\n"
					+ "    SELECT TAG_5 AS TAGS, CREATED_AT\r\n"
					+ "    FROM POST\r\n"
					+ "    WHERE ACCOUNT_ID = '?'\r\n"
					+ ") AS CombinedTags\r\n"
					+ "GROUP BY TAGS\r\n"
					+ "ORDER BY CREATED_AT DESC;");
			// プリペアードステートメントにアカウントIDをバインド
			statement.setString(1, account_id);
			statement.setString(2, account_id);
			statement.setString(3, account_id);
			statement.setString(4, account_id);
			statement.setString(5, account_id);
			
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();
			
			if (rSet.next()) {
				tagsList.add(rSet.getString("TAGS"));
			}
			
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
		
		return tagsList;
	}
}
