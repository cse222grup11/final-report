/**
 * Comment Class
 * @author mitat
 *
 */
public class Comment {

	private Regular_User user;
	private float rating;
	private String comment_text;
	
	Comment(){
		
	}
	Comment(Regular_User user, float rating, String comment_text){
		this.setUser(user);
		this.setRating(rating);
		this.setComment_text(comment_text);
	}
	boolean equals(Comment com) {
		
		return com.getUser().equals(getUser()) && 
				com.getRating() == getRating() && 
					com.getComment_text().equals(getComment_text());
	}
	
	public Regular_User getUser() {
		return user;
	}
	public void setUser(Regular_User user) {
		this.user = user;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	

}
