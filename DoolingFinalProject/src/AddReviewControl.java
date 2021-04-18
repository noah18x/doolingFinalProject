import java.util.Date;
public class AddReviewControl {
	private dataManager dm;
//	private LoginControl control;
	
	public AddReviewControl(dataManager dm) {
		this.dm = dm;
//		this.control = control;
	}
	
	public void processAddReview(String title, String author, int score, Date date, String text) {
		//pass all info to datamanager
		dm.createReview(score, date, text, score, 1, title, author);
	}
	
	public String getLogin() {
//		String login = control.checkLoginInfo();
		String login = null;
		return login;
	}
}
