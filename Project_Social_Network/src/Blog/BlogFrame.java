package Blog;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;

import User.*;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import Status.BlogStatus;
import Interactive.Interactives;

public class BlogFrame extends JFrame {

	/**
	 * 
	 */
	JPanel contentPane = new JPanel();
	JLabel titleBlog; 
	JLabel usernameBlog; 
	JLabel datePosted; 
	JLabel bodyBlog; 
	JButton likeButton = new JButton("Like"); 
	JButton commentButton = new JButton("Comment"); 
	
	
	static Users user; 
	static Blogs blog; 
	// int UserID = 0;
	
	
	public BlogFrame(Blogs b) {
		blog = b; 
		// setSize(600, 120); 
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 600, 400);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setBackground(Color.white);
		contentPane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		titleBlog = new JLabel(blog.get_Title()); 
		titleBlog.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameBlog = new JLabel(blog.get_Username()); 
		datePosted = new JLabel(" at " + blog.get_Date());  
		bodyBlog = new JLabel(blog.get_Body()); 
		
		JPanel subPanel = new JPanel(); 
		subPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel.setBackground(Color.white);
		subPanel.add(titleBlog); 
		subPanel.add(usernameBlog); 
		subPanel.add(datePosted); 
		
		JPanel bodyPanel = new JPanel(); 
		bodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		bodyPanel.setBackground(Color.white);
		
		if (blog.get_Body().length() >= 85) {
			String text = "<html>"; 
			for (int i = 0; i < blog.get_Body().length(); i++) {
				text += blog.get_Body().charAt(i); 
				if (text.length() % 85 == 0) {
					text += "<br>"; 
				}
			}
			text += "</html>"; 
			bodyBlog = new JLabel(text); 
			bodyPanel.add(bodyBlog); 
		} 
		else { // just show it otherwise
			bodyBlog = new JLabel(blog.get_Body()); 
			bodyPanel.add(bodyBlog); 
		}
		
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setBackground(Color.white);
		buttonPanel.add(likeButton);
		buttonPanel.add(commentButton); 
		
		contentPane.add(subPanel); 
		contentPane.add(bodyPanel); 
		contentPane.add(buttonPanel); 
		
		// show comment here
		blog.getComments();
		ArrayList<JPanel> cmtPanel = showComment(blog.cmt); 
		for (JPanel panel : cmtPanel) {
			contentPane.add(panel); 
			contentPane.add(Box.createRigidArea(new Dimension(0,10))); 
		}
		
		JScrollPane scrollPane = new JScrollPane(contentPane); 
		
		
		
		add(scrollPane);
		
		//setUndecorated(true);
	}
	
	public ArrayList<JPanel> showComment(ArrayList<Interactives> cmtList) {
		ArrayList<JPanel> cmtPanel = new ArrayList<>(); 
		for (Interactives cmt : cmtList) {
			JPanel panel = new JPanel(); 
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.setBackground(Color.white);
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			
			JPanel subPanel = new JPanel(); 
			subPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			subPanel.setBackground(Color.white);
			JLabel userCmt = new JLabel(cmt.get_Username()); 
			userCmt.setFont(new Font("Tahoma", Font.BOLD, 15));
			JLabel datePosted = new JLabel(" at " + cmt.get_Date()); 
			datePosted.setForeground(Color.gray);
			subPanel.add(userCmt); 
			subPanel.add(datePosted); 
			
			JPanel bodyPanel = new JPanel();
			bodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			bodyPanel.setBackground(Color.white);
			
			if (cmt.get_Body().length() >= 70) {
				String text = "<html>"; 
				for (int i = 0; i < cmt.get_Body().length(); i++) {
					text += cmt.get_Body().charAt(i); 
					if (text.length() % 70 == 0) {
						text += "<br>"; 
					}
				}
				text += "</html>"; 
				JLabel bodyPost = new JLabel(text); 
				bodyPanel.add(bodyPost); 
			}
			else {
				JLabel bodyPost = new JLabel(cmt.get_Body()); 
				bodyPanel.add(bodyPost); 
			}
			
			panel.add(subPanel); 
			panel.add(bodyPanel); 
			
			cmtPanel.add(panel); 
		}
		
		return cmtPanel; 
	}
	
	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BlogFrame frame = new BlogFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
}
