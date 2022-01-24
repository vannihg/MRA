package dbadapter;

public class MovieRate {

	private int rating;
	private String uid;
	private String mid;
	private String comment;
	
	public MovieRate(int rating,String uid,String mid,String comment) {
		super();
		this.rating = rating;
		this.uid = uid;
		this.mid = mid;
		this.comment = comment;
	}
	
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.uid = mid;
	}
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
