
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Follow;

public class FollowDao extends Dao{
	public Follow get(String accountId) throws Exception {
		Follow follow = new Follow();
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select * from FOLLOW where = account_id=?");
			statement.setString(1,accountId);
			ResultSet rSet = statement.executeQuery();
			if(rSet.next()) {
				follow.setAccountId(rSet.getString("accunt_id"));
				follow.setFollowId(rSet.getString("follow_id"));
			} else {
				follow = null;
			}
		}catch(Exception e) {
			throw e;
		}finally {
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
		return follow;
	}
}