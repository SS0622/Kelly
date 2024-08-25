package bean;

import java.io.Serializable;

public class Post implements Serializable {
	// とりあえず、現状のpostテーブルを基に作成したものなので変更の可能性あり

	//投稿ID:int
	private int postID;
	
	// アカウントID:String
	private String accID;
	
	// タグ1:String
	private String[] imgTags;
	
	// 透過画像(手描き画像)パス:String
	private String alphaImg;
	
	// 背景画像パス:String
	private String baseImg;
	
	// タイトル
	private String title;
	
	// キャプション
	private String caption;
	
	// アカウント情報
	private Account accData;

	/**
	 * 以下 ゲッター、セッター
	 */
	public int getPostID() {
		return this.postID;
	}

	public void setPostID(int postid) {
		this.postID = postid;
	}
	
	public String getAccID() {
		return this.accID;
	}
	
	public void setAccID(String accid) {
		this.accID = accid;
	}
	
	public String getAlphaImg() {
		return this.alphaImg;
	}
	
	public void setAlphaImg(String alphaimg_path) {
		this.alphaImg = alphaimg_path;
	}
	
	public String getBaseImg() {
		return this.baseImg;
	}
	
	public void setBaseImg(String baseimg_path) {
		this.baseImg = baseimg_path;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCaption() {
		return this.caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	// beanではタグを配列で保管するという案
	public String[] getImgTags() {
		return imgTags;
	}
	public void setImgTags(String[] imgtags) {
		this.imgTags = imgtags;
	}
	
	public Account getAccData() {
		return this.accData;
	}
	
	public void setAccData(Account account) {
		this.accData = account;
	}
}














