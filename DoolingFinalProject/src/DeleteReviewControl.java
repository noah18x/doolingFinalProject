
public class DeleteReviewControl {
	private dataManager dm;
//	private LoginControl lc;
	public DeleteReviewControl(dataManager dm, LoginControl lc) {
		this.dm = dm;
		this.lc = lc;
	}
	
	public void processDeletion(Reviews review) {
		//delete review
		System.out.println("to be deleted");
		dm.deleteReview(review);
	}
	
	public String getLogin() {
		String login = lc.checkLoginInfo();
		return login;
	}
}
