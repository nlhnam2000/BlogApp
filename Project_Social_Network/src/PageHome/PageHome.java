package PageHome;

import java.time.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import User.Users;
import Blog.Blogs;
import Status.BlogStatus;

import java.util.*;

public class PageHome extends JFrame implements ActionListener {

	JPanel contentPane;
	JLabel logoLabel; 
	JTextField searchBar; 
	JButton postBlogBtn; 
	JButton logoutBtn; 
	JLabel helloUser; 
	static Users user; 
	ArrayList<Blogs> blogList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PageHome frame = new PageHome(user);
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
	public PageHome(Users u) {
		
		user = new Users(u);
		helloUser = new JLabel("Bonjour " + user.getUsername() + " !"); 
		helloUser.setBounds(800, 13, 200, 30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1000, 800);
		setSize(1000, 800); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBackground(new Color(238,238,238));
		
		// set up all panel: 
		JPanel navbarPanel = new JPanel(); // navbar
		JPanel container = new JPanel();
		JPanel scrollPanel = new JPanel(); // contains all blogs with a scrollpane
		JPanel sidebarPanel = new JPanel(); // a sidebar which contains all blog's titles
		
		// set up navbar: 
		navbarPanel.setLayout(null);
		navbarPanel.setBackground(Color.white);
		navbarPanel.setPreferredSize(new Dimension(contentPane.getWidth(), 55));
		logoLabel = new JLabel("VNS Blog");
		logoLabel.setForeground(new Color(225,127,80));
		logoLabel.setBounds(50,12,100,30); 
		
		searchBar = new JTextField("   Search for blog", 20); 
		searchBar.setBounds(200, 12, 350, 30); 
		searchBar.setBackground(new Color(238,238,238));
		searchBar.setForeground(Color.GRAY);
		
		postBlogBtn = new JButton("Create blog"); 
		postBlogBtn.setBounds(600, 13, 150, 30); 
		
		logoutBtn = new JButton("Logout"); 
		logoutBtn.setBounds(800, 13, 100, 30);
		
		navbarPanel.add(logoLabel); 
		navbarPanel.add(searchBar); 
		navbarPanel.add(postBlogBtn); 
		// navbarPanel.add(logoutBtn); 
		navbarPanel.add(helloUser); 
		
		// set up container: 
		container.setPreferredSize(new Dimension(contentPane.getWidth(), contentPane.getHeight() - navbarPanel.getSize().height));
		container.setBackground(contentPane.getBackground());
		container.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		gbc.insets = new Insets(8,8,8,8); 
		
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
		scrollPanel.setBackground(contentPane.getBackground());
		JScrollPane scrollPane = new JScrollPane(scrollPanel); 
		scrollPane.setBorder(null);
		// scrollPane.setPreferredSize(new Dimension(600, 700));
		scrollPane.getViewport().setPreferredSize(new Dimension(600, 700));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		user.getAllBlog();
		blogList = user.getBlog(); 
		
		ArrayList<JPanel> blogPanel = showPost(blogList);
		for (JPanel panel : blogPanel) {
			scrollPanel.add(panel); 
			scrollPanel.add(Box.createRigidArea(new Dimension(0,10))); 
		}
		
		container.add(scrollPane, gbc); 
		
		sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.PAGE_AXIS));
		sidebarPanel.setBackground(Color.white);
		sidebarPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane sidebarScroll = new JScrollPane(sidebarPanel); 
		sidebarScroll.setBorder(null);
		sidebarScroll.setPreferredSize(new Dimension(200, 700));
		sidebarScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		ArrayList<JLabel> titleBlog = showBlogTitle(blogList); 
		for (JLabel title : titleBlog) {
			sidebarPanel.add(title); 
		}
		
//		for (int i = 0; i < 100; i++) {
//			JLabel label = new JLabel("Hello"); 
//			JPanel panel = new JPanel(); 
//			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
//			panel.setBorder(BorderFactory.createLineBorder(Color.black));
//			panel.add(label); 
//			sidebarPanel.add(Box.createRigidArea(new Dimension(0,10))); 
//		}
		
		gbc.gridx = 1; 
		gbc.gridy = 0; 
		container.add(sidebarScroll, gbc); 
		
		// contentPane adding all their child components
		contentPane.add(navbarPanel); 
		contentPane.add(container); 
		
		
		
		
		// add action listener
		postBlogBtn.addActionListener(this);
		
		setContentPane(contentPane);
	}
	
	public ArrayList<JPanel> showPost(ArrayList<Blogs> list) {
		ArrayList<JPanel> blogPanel = new ArrayList<>(); 
		for (Blogs blog : list) {
			JPanel panel = new JPanel(); 
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			// panel.setPreferredSize(new Dimension(400, 100));
			panel.setBackground(Color.white);
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			
			JPanel subPanel = new JPanel(); 
			subPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			subPanel.setBackground(Color.white);
			JLabel titleLabel = new JLabel(blog.get_Title()); 
			JLabel usernameLabel = new JLabel("• Posted by " + blog.get_Username()); 
			subPanel.add(titleLabel); 
			subPanel.add(usernameLabel); 
			
			JPanel bodyPanel = new JPanel();
			bodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			bodyPanel.setBackground(Color.white);
			JLabel bodyPost = new JLabel(blog.get_Body()); 
			bodyPanel.add(bodyPost); 
			
			JPanel buttonPanel = new JPanel(); 
			buttonPanel.setLayout(new FlowLayout());
			buttonPanel.setBackground(panel.getBackground());
			JButton likeButton = new JButton("Like"); 
			JButton commentButton = new JButton("Comment"); 
			buttonPanel.add(likeButton); 
			buttonPanel.add(commentButton); 
			
			panel.add(subPanel); 
			panel.add(bodyPanel); 
			panel.add(buttonPanel); 
			
			
			blogPanel.add(panel); 
		}
		return blogPanel; 
	}
	
	public ArrayList<JLabel> showBlogTitle(ArrayList<Blogs> list) {
		ArrayList<JLabel> titleLabel = new ArrayList<>();
		for (Blogs blog : list) {
			JLabel label = new JLabel(blog.get_Title()); 
			titleLabel.add(label); 
		}
		
		return titleLabel; 
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand(); 
		if (command.equals("Create blog")) {
//			Scanner scanner = new Scanner(System.in); 
//			System.out.print("Title: "); 
//			String title = scanner.nextLine(); 
//			System.out.print("Body: "); 
//			String body = scanner.nextLine();
			
			BlogStatus status = new BlogStatus();
			LocalDate date = LocalDate.now();
			
//			String body = "This is body, This is body, This is body, This is body, This is body This is body "
//					+ "This is body, This is body, This is body, This is body, This is body, This is body " 
//					+ "This is body This is body This is body This is body This is body This is body This is body "
//					+ "This is body This is body This is body This is body This is body This is body This is body"; 
			
			Blogs blog = new Blogs("Post 3", user.getUsername(), "Posting blog 3", true, false, String.valueOf(date), false, status); 
			user.PostBlog(blog); 
		}
	}
	

}
