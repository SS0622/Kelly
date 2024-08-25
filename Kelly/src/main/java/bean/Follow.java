package bean;

import java.io.Serializable;

public class Follow extends User implements Serializable{
	private String accountId;
	private String followId;
	// アカウント情報
	private Account accData;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getFollowId() {
		return followId;
	}
	public void setFollowId(String followId) {
		this.followId =followId;
	}
	public Account getAccData() {
		return this.accData;
	}
	
	public void setAccData(Account account) {
		this.accData = account;
	}
}