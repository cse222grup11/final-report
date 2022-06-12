/**
 * Report Class
 * @author mitat
 *
 */
public class Report {
	
	private Regular_User reporting_user;
	private Regular_User reported_user;
	private Comment reported_comment;
	
	Report(){
		
	}
	Report(Regular_User reporting_user, Regular_User reported_user, Comment reported_comment){
		this.setReporting_user(reporting_user);
		this.setReported_user(reported_user);
		this.setReported_comment(reported_comment);
	}

	public Regular_User getReporting_user() {
		return reporting_user;
	}

	public void setReporting_user(Regular_User reporting_user) {
		this.reporting_user = reporting_user;
	}

	public Regular_User getReported_user() {
		return reported_user;
	}

	public void setReported_user(Regular_User reported_user) {
		this.reported_user = reported_user;
	}

	public Comment getReported_comment() {
		return reported_comment;
	}

	public void setReported_comment(Comment reported_comment) {
		this.reported_comment = reported_comment;
	}
}
