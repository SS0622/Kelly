package bean;

import java.io.Serializable;

public class Post implements Serializable {

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

	/**
	 * 以下 ゲッター、セッター
	 */
	public int getPostID() {
		return postID;
	}

	public void setPostID(int postid) {
		this.postID = postid;
	}
	
	public String getAccID() {
		return accID;
	}
	
	public void setAccID(String accid) {
		this.accID = accid;
	}

	public String getImgTag01() {
		return imgTag_01;
	}
	
	public void setImgTag01(String imgtag01) {
		this.imgTag_01 = imgtag01;
	}
	
	public String getImgTag02() {
		return imgTag_02;
	}
	
	public void setImgTag02(String imgtag02) {
		this.imgTag_02 = imgtag02;
	}
	
	public String getImgTag03() {
		return imgTag_03;
	}
	
	public void setImgTag03(String imgtag03) {
		this.imgTag_03 = imgtag03;
	}
	
	public String getImgTag04() {
		return imgTag_04;
	}
	
	public void setImgTag04(String imgtag04) {
		this.imgTag_04 = imgtag04;
	}
	
	public String getImgTag05() {
		return imgTag_05;
	}
	
	public void setImgTag05(String imgtag05) {
		this.imgTag_05 = imgtag05;
	}
	
	public String getAlphaImg() {
		return alphaImg;
	}
	
	public void setAlphaImg(String alphaimg_path) {
		this.alphaImg = alphaimg_path;
	}
	
	public String getBaseImg() {
		return baseImg;
	}
	
	public void setBaseImg(String baseimg_path) {
		this.baseImg = baseimg_path;
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














