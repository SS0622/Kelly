package bean;

import java.io.Serializable;

public class Post implements Serializable {
	// とりあえず、現状のpostテーブルを基に作成したものなので変更の可能性あり

	//投稿ID:int
	private int postID;
	
	// アカウントID:String
	private String accID;
	
	// タグ1:String
	private String imgTag_01;

	// タグ2:String
	private String imgTag_02;
	
	// タグ3:String
	private String imgTag_03;
	
	// タグ4:String
	private String imgTag_04;
	
	// タグ5:String
	private String imgTag_05;
	
	// 透過画像(手描き画像)パス:String
	private String alphaImg;
	
	// 背景画像パス:String
	private String baseImg;
	
	// タイトル
	private String title;
	
	// キャプション
	private String caption;

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

	public String getImgTag01() {
		return this.imgTag_01;
	}
	
	public void setImgTag01(String imgtag01) {
		this.imgTag_01 = imgtag01;
	}
	
	public String getImgTag02() {
		return this.imgTag_02;
	}
	
	public void setImgTag02(String imgtag02) {
		this.imgTag_02 = imgtag02;
	}
	
	public String getImgTag03() {
		return this.imgTag_03;
	}
	
	public void setImgTag03(String imgtag03) {
		this.imgTag_03 = imgtag03;
	}
	
	public String getImgTag04() {
		return this.imgTag_04;
	}
	
	public void setImgTag04(String imgtag04) {
		this.imgTag_04 = imgtag04;
	}
	
	public String getImgTag05() {
		return this.imgTag_05;
	}
	
	public void setImgTag05(String imgtag05) {
		this.imgTag_05 = imgtag05;
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
	private String[] imgTags;
	public String[] getImgTags() {
		return imgTags;
	}
	public void setImgTags(String[] imgtags) {
		this.imgTags = imgtags;
	}
	
}














