import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
public class AddReviewUI {
	private AddReviewControl control;
	
	public AddReviewUI(AddReviewControl control) {
		this.control = control;
	}
	
	public void createReviewUI() {
//		
		//if login fails return
		String username = control.getLogin(); //from login
		if (username.isEmpty()) {
			System.out.println("login failed");
			return;
		}
		
		JFrame frame = new JFrame("Review Creation Form");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Title:");
		JLabel score = new JLabel("Score:");
		JLabel text = new JLabel("Text:");
		JTextField titleField = new JTextField(50);
		JTextField scoreField = new JTextField(20);
		JTextField textField = new JTextField(1);
		JButton createButton = new JButton("Create Review");
		
		title.setBounds(10,20,50,25);
        panel.add(title);
        titleField.setBounds(60, 20, 100, 25);
        panel.add(titleField);
        
        score.setBounds(200,20,50,25);
        panel.add(score);
        scoreField.setBounds(260, 20, 100, 25);
        panel.add(scoreField);
        
        text.setBounds(10,80,80,25);
        panel.add(text);
        textField.setBounds(10, 100, 200, 100);
        panel.add(textField);
        
        createButton.setBounds(10, 300, 150, 25);
        panel.add(createButton);
		frame.setVisible(true);
		
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userScore = getScore(scoreField.getText());
				String userTitle = titleField.getText();
				String userText = textField.getText();
				
				
				if (userScore > -1 && userScore < 11) {
					if (!userTitle.isEmpty() && !userText.isEmpty()) {
						Date date = new Date();
						control.processAddReview(userTitle, username, userScore, date, userText);
						frame.dispose();
					    displayConfirmation();					    
					}
				}
				else {
					System.out.println("invalid form submission");
				}
			}
		});
	}
	
	public static boolean isDigit(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch(NumberFormatException exception){
			return false;
		}
	}
	
	public static int getScore(String s) {
		if (isDigit(s)) {
			return Integer.parseInt(s);
		}
		else return -1;
	}
		
	
	public static void displayConfirmation() {
		JFrame frame = new JFrame("Post Confirmation");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel postCreated = new JLabel("Review has been created");
		postCreated.setBounds(60, 20, 250, 25);
		panel.add(postCreated);
		frame.setVisible(true);
	}
	
}
