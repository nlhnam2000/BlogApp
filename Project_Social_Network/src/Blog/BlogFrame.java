package Blog;

import java.awt.BorderLayout;
import User.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Status.BlogStatus;

import javax.swing.JTextArea;

public class BlogFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Users user = new Users();
	private int UserID = 0;
	
	
	public BlogFrame(Users u, int userid) {
		this.user = new Users(u);
		this.UserID = userid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrHello = new JTextArea();
		txtrHello.setBounds(197, 172, 265, 226);
		contentPane.add(txtrHello);
		txtrHello.setText(BlogFrame.this.user.getUsername() + " " + BlogFrame.this.UserID);
		BlogFrame.this.user.EditBlog(7, "Troi xanh" , "Hom nay la mot ngay dep troi");
		BlogFrame.this.user.EditCmt(3, "Cmt de len fan cung :v");
		
//		Blogs b = new Blogs("Nau an", this.user.getUsername(),"Hom nay minh da nau duoc mot vai mon ngon", true,  true,
//				"2021-03-31", true, new BlogStatus());
//		
//		System.out.print(this.user.getUsername() + " " + this.user.getUserID());
//		this.user.PostBlog(b);
		
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogFrame frame = new BlogFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlogFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrHello = new JTextArea();
		txtrHello.setBounds(197, 172, 265, 226);
		contentPane.add(txtrHello);
		txtrHello.setText("Hello");
		System.out.println(BlogFrame.this.UserID);
		
		//setUndecorated(true);
	}
}
