package Blog;

import java.awt.BorderLayout;
import java.awt.Color;

import User.*;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

import Status.BlogStatus;

public class BlogFrame extends JFrame {

	/**
	 * 
	 */
	static final long serialVersionUID = 1L;
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
	
	
//	public BlogFrame(Users u, int userid) {
//		this.user = new Users(u);
//		this.UserID = userid;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 645, 510);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JTextArea txtrHello = new JTextArea();
//		txtrHello.setBounds(197, 172, 265, 226);
//		contentPane.add(txtrHello);
//		txtrHello.setText(BlogFrame.this.user.getUsername() + " " + BlogFrame.this.UserID);
//		BlogFrame.this.user.EditBlog(7, "Troi xanh" , "Hom nay la mot ngay dep troi");
//		BlogFrame.this.user.EditCmt(3, "Cmt de len fan cung :v");
//		
////		Blogs b = new Blogs("Nau an", this.user.getUsername(),"Hom nay minh da nau duoc mot vai mon ngon", true,  true,
////				"2021-03-31", true, new BlogStatus());
////		
////		System.out.print(this.user.getUsername() + " " + this.user.getUserID());
////		this.user.PostBlog(b);
//		
//	}
	
	public BlogFrame(Blogs b) {
		blog = b; 
		setSize(600, 800); 
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 250);
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
		
		
		add(contentPane);
		
		//setUndecorated(true);
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

	/**
	 * Create the frame.
	 */
	
}
