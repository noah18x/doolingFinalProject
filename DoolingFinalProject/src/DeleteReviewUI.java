import javax.swing.*;
import java.awt.event.*;
public class DeleteReviewUI {
	private DeleteReviewControl control;
	public DeleteReviewUI(DeleteReviewControl control) {
		this.control = control;
	}
	
	public void deleteReviewUI(Reviews review) {
		//check login
		//check username matches posts
		String username = control.getLogin();
		
		if (username.equals(review.author)) {
			control.processDeletion(review);
		}	
	}
}
