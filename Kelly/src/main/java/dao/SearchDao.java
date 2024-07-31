package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import bean.Post;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SearchDao extends Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		public List<String> search(String text) throws Exception {
			Connection connection = getConnection();
			
			PreparedStatement statement = null;
			
			List<String> list = new ArrayList<>();
			
			try {
				// プリペアードステートメントにSQL文をセット
				statement = connection.prepareStatement("SELECT * FROM TAG"
						+ "WHERE LIKE('?')");
				// プリペアードステートメントに検索したい文字をバインド
				statement.setString(1, text);
				
				
				// プリペアードステートメントを実行
				ResultSet rSet = statement.executeQuery();
				
				
				while(rSet.next()){
					list.add(rSet.getString("*"));	
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
			return list;
		}
	}

}
