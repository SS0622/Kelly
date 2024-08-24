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
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)");
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
			statement.executeUpdate();
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
	public ArrayList<Post> search(ArrayList<String> tags,String order,String mode) throws Exception{
		// 返すための変数を用意
		ArrayList<Post> postList = new ArrayList<>();
		// コネクションの確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet=null;
		
		// SQL文作成
		StringBuilder TAGsql = new StringBuilder("");
		// 送られてきたタグリストがNULLでなく、中身があればSQLを作成
		if (tags == null || tags.size() == 0) {
		}else if (mode.equals("1")||mode.equals("2")) {
			// タグ検索
			TAGsql.append(" where ");
			int count = 0;
			for(String tag : tags) {
				count+=1;
				TAGsql.append("COALESCE(TAG_1,' ')||' '||COALESCE(TAG_2,' ')||' '||COALESCE(TAG_3,' ')||' '||COALESCE(TAG_4,' ')||' '||COALESCE(TAG_5,' ') LIKE '%"+tag+"%'");
				if (count<tags.size()) {
					// 引数modeが"1"ならOR検索をし、"2"ならAND検索する
					if (mode.equals("1")) {
						TAGsql.append(" or ");
					}else if(mode.equals("2")) {
						TAGsql.append(" and ");
					}
				}
			}
		}else if (mode.equals("3")||mode.equals("4")) {
			// タイトル検索
			TAGsql.append(" where ");
			int count = 0;
			for(String tag : tags) {
				count+=1;
				TAGsql.append("TITLE LIKE '%"+tag+"%'");
				if (count<tags.size()) {
					// 引数modeが"3"ならOR検索をし、"4"ならAND検索する
					if (mode.equals("3")) {
						TAGsql.append(" or ");
					}else if(mode.equals("4")) {
						TAGsql.append(" and ");
					}
				}
			}
		}else {
			// キャプション検索
			TAGsql.append(" where ");
			int count = 0;
			for(String tag : tags) {
				count+=1;
				TAGsql.append("CAPTION LIKE '%"+tag+"%'");
				if (count<tags.size()) {
					// 引数modeが"5"ならOR検索をし、"6"ならAND検索する
					if (mode.equals("5")) {
						TAGsql.append(" or ");
					}else if(mode.equals("6")) {
						TAGsql.append(" and ");
					}
				}
			}
		}
		// 引数orderが"1"なら投稿日が新しい順、"2"なら古い順
		if (order.equals("1")) {
			TAGsql.append(" ORDER BY CREATED_AT DESC");
		}else if(mode.equals("2")) {
			TAGsql.append(" ORDER BY CREATED_AT ASC");
		}
		try{
			//検索開始
			statement=connection.prepareStatement("select * from POST" + TAGsql);
			rSet=statement.executeQuery();
			
			//検索結果の整形
			while(rSet.next()){
				Post p = new Post();
				String[] tagstrs = new String[5];
				p.setPostID(rSet.getInt("POST_ID"));
				p.setAccID(rSet.getString("ACCOUNT_ID"));
				tagstrs[0]=rSet.getString("TAG_1");
				tagstrs[1]=rSet.getString("TAG_2");
				tagstrs[2]=rSet.getString("TAG_3");
				tagstrs[3]=rSet.getString("TAG_4");
				tagstrs[4]=rSet.getString("TAG_5");
				p.setImgTags(tagstrs);
				p.setAlphaImg(rSet.getString("PICTURE_1"));
				p.setBaseImg(rSet.getString("PICTURE_2"));
				p.setTitle(rSet.getString("TITLE"));
				p.setCaption(rSet.getString("CAPTION"));
				//リストに追加
				postList.add(p);
			}
		}
		catch (Exception e){
			throw e;
		}
		finally{
			// プリペアードステートメントを閉じる
			if (statement != null){
				try{
					statement.close();
				}
				catch(SQLException sqle){
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null){
				try{
					connection.close();
				}
				catch(SQLException sqle){
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
					+ "					FROM (\r\n"
					+ "					SELECT TAG_1 AS TAGS, CREATED_AT\r\n"
					+ "					FROM POST\r\n"
					+ "					WHERE ACCOUNT_ID = ?\r\n"
					+ "					UNION ALL\r\n"
					+ "					SELECT TAG_2 AS TAGS, CREATED_AT\r\n"
					+ "					FROM POST\r\n"
					+ "					WHERE ACCOUNT_ID = ?\r\n"
					+ "					UNION ALL\r\n"
					+ "					SELECT TAG_3 AS TAGS, CREATED_AT\r\n"
					+ "					FROM POST\r\n"
					+ "					WHERE ACCOUNT_ID = ?\r\n"
					+ "					UNION ALL\r\n"
					+ "					SELECT TAG_4 AS TAGS, CREATED_AT\r\n"
					+ "					FROM POST\r\n"
					+ "					WHERE ACCOUNT_ID = ?\r\n"
					+ "					UNION ALL\r\n"
					+ "					SELECT TAG_5 AS TAGS, CREATED_AT\r\n"
					+ "					FROM POST\r\n"
					+ "					WHERE ACCOUNT_ID = ?\r\n"
					+ "					) AS CombinedTags\r\n"
					+ "					GROUP BY TAGS\r\n"
					+ "					ORDER BY CREATED_AT DESC;");
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
