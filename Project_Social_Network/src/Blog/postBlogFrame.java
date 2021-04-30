package Blog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.time.*;

import User.Users;
import Blog.*;
import Status.BlogStatus; 

public class postBlogFrame extends JFrame implements ActionListener {
	
	JTextField title = new JTextField(20); 
	JTextArea body = new JTextArea();
	static Users user; 
	
	public postBlogFrame(Users u) {
		user = u; 
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(200, 200); 
		setBounds(700, 200, 200, 200); 
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS)); 
		titlePanel.add(new JLabel("Title: ")); 
		titlePanel.add(title); 
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.X_AXIS)); 
		bodyPanel.add(new JLabel("Body: ")); 
		bodyPanel.add(body); 
		
		JButton button = new JButton("OK"); 
		
		button.addActionListener(this);
		
		add(titlePanel); 
		add(bodyPanel); 
		add(button); 
		
		pack();
		setVisible(true); 
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand(); 
		if (command.equals("OK")) {
			String titleText = title.getText(); 
			String bodyText = body.getText(); 
			
			if (!titleText.equals("") || !bodyText.equals("")) {
				LocalDate date = LocalDate.now(); 
				BlogStatus status = new BlogStatus();
				
				Blogs blog = new Blogs(title.getText(), user.getUsername(), body.getText(), true, false, 
										String.valueOf(date), false, status); 
				user.PostBlog(blog); 
				
				// reset field after submission
				title.setText("");
				body.setText("");
			}
			else {
				System.out.println("Missing title or body"); 
			}
		}
	}

}
