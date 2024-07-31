package bean;

import java.io.Serializable;

public class Follow extends User implements Serializable{
	private String accountId;
	private String followId;
	
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
}
