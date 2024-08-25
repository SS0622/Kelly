package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Follow;

public class FollowDao extends Dao{
	public ArrayList<Follow> allFollow(String accountId) throws Exception {
		// 返すための変数を用意
		ArrayList<Follow> follows = new ArrayList<>();
		// コネクションの確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet=null;
		try {
			statement = connection.prepareStatement("select * from FOLLOW where account_id=? order by FOLLOWER_ID");
			statement.setString(1, accountId);
			rSet=statement.executeQuery();
			//検索結果の整形
			AccountDao aDao = new AccountDao();
			while(rSet.next()){
				Follow f = new Follow();
				f.setAccountId(accountId);
				f.setFollowId(rSet.getString("FOLLOWER_ID"));
				f.setAccData(aDao.get(rSet.getString("FOLLOWER_ID")));
				//リストに追加
				follows.add(f);
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
		return follows;
	}
	public ArrayList<Follow> allFollower(String accountId) throws Exception {
		// 返すための変数を用意
		ArrayList<Follow> follows = new ArrayList<>();
		// コネクションの確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet=null;
		try {
			statement = connection.prepareStatement("select * from FOLLOW where follower_id=? order by account_id ");
			statement.setString(1, accountId);
			rSet=statement.executeQuery();
			//検索結果の整形
			AccountDao aDao = new AccountDao();
			while(rSet.next()){
				Follow f = new Follow();
				f.setAccountId(rSet.getString("FOLLOWER_ID"));
				f.setFollowId(accountId);
				f.setAccData(aDao.get(rSet.getString("FOLLOWER_ID")));
				//リストに追加
				follows.add(f);
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
		return follows;
	}
	public Follow get(String accountId,String followId) throws Exception {
		// 返すための変数を用意
		Follow follow = new Follow();
		// コネクションの確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet=null;
		try {
			statement = connection.prepareStatement("select * from FOLLOW where account_id=? and FOLLOWER_ID=?");
			statement.setString(1, accountId);
			statement.setString(2, followId);
			rSet=statement.executeQuery();
			//検索結果の整形
			if (rSet.next()){
				// リザルトセットが存在する場合、
				follow.setAccountId(accountId);
				follow.setFollowId(rSet.getString("FOLLOWER_ID"));
			}
			else{
				// リザルトセットが存在しない場合
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
	public boolean save(String accountId,String followId) throws Exception {
		Follow follow = new Follow();
		// コネクションの確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		//更新件数
		int count=0;
		// 更新結果
		boolean success = false;
		try {
			follow=get(accountId,followId);
			if(follow == null){
				// 存在しなかった場合プリペアードステートメントにINSERT文をセット
				statement=connection.prepareStatement("INSERT INTO FOLLOW(ACCOUNT_ID,FOLLOWER_ID) VALUES(?,?)");
				statement.setString(1, accountId);
				statement.setString(2, followId);
				// 戻り値として更新した件数が変数countに入る
				count = statement.executeUpdate();
				if(count>=1) {success = true;}
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
		return success;
	}
	public boolean save(Follow followData) throws Exception {
		Follow follow = new Follow();
		// コネクションの確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		//更新件数
		int count=0;
		// 更新結果
		boolean success = false;
		try {
			follow=get(followData.getAccountId(),followData.getFollowId());
			if(follow == null){
				// 存在しなかった場合プリペアードステートメントにINSERT文をセット
				statement=connection.prepareStatement("INSERT INTO FOLLOW(ACCOUNT_ID,FOLLOWER_ID) VALUES(?,?)");
				statement.setString(1, followData.getAccountId());
				statement.setString(2, followData.getFollowId());
				// 戻り値として更新した件数が変数countに入る
				count = statement.executeUpdate();
				if(count>=1) {success = true;}
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
		return success;
	}
	public boolean delete(String accountId,String followId) throws Exception {
		Follow follow = new Follow();
		// コネクションの確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		//更新件数
		int count=0;
		// 更新結果
		boolean success = false;
		try {
			follow=get(accountId,followId);
			if(follow != null){
				// 存在した場合プリペアードステートメントにINSERT文をセット
				statement=connection.prepareStatement("DELETE FROM FOLLOW WHERE ACCOUNT_ID=? and FOLLOWER_ID=?");
				statement.setString(1, accountId);
				statement.setString(2, followId);
				// 戻り値として更新した件数が変数countに入る
				count = statement.executeUpdate();
				if(count>=1) {success = true;}
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
		return success;
	}
}