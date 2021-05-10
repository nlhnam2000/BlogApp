package PageHome;

import java.time.*;



import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import User.Users;
import Blog.Blogs;
import Blog.postBlogFrame;
import Blog.BlogFrame;
import Status.BlogStatus;
import Notification.NotificationManagement;

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
		// scrollPanel.setPreferredSize(new Dimension(600, 700));
		JScrollPane scrollPane = new JScrollPane(scrollPanel); 
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(600, 700));
		// scrollPane.getViewport().setPreferredSize(new Dimension(600, 700));
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
		sidebarScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); 
 		
		sidebarPanel.add(Box.createRigidArea(new Dimension(0, 15))); 
		JLabel text = new JLabel("MOST RECENT BLOG"); 
		text.setFont(new Font("Tahoma", Font.BOLD, 15));
		sidebarPanel.add(text);
		sidebarPanel.add(Box.createRigidArea(new Dimension(30, 20))); 
		
		ArrayList<JLabel> titleBlog = showBlogTitle(blogList); 
		for (JLabel title : titleBlog) {
			sidebarPanel.add(title); 
			sidebarPanel.add(Box.createRigidArea(new Dimension(0,10)));
		}
		
//		for (int i = 0; i < 100; i++) {
//			JLabel label = new JLabel("Hello"); 
//			JPanel panel = new JPanel(); 
//			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
//			panel.setBorder(BorderFactory.createLineBorder(Color.black));
//			panel.add(label); 
//			sidebarPanel.add(Box.createRigidArea(new Dimension(0,10))); 
//			sidebarPanel.add(panel);
//		}
		
		gbc.gridx = 1; 
		gbc.gridy = 0; 
		container.add(sidebarScroll, gbc); 
		
		// contentPane adding all their child components
		contentPane.add(navbarPanel); 
		contentPane.add(container); 
		
		
		
		
		// add action listener
		postBlogBtn.addActionListener(this);
		helloUser.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				NotificationManagement frame = new NotificationManagement();
				frame.showInfo(user);
				frame.showNotification();
				frame.setVisible(true);
			}
			
		});
		
		logoLabel.addMouseListener(new MouseAdapter() { // reload and update the home page
			public void mouseClicked(MouseEvent e) {
				dispose(); 
				PageHome newPageHome = new PageHome(user); 
				newPageHome.setVisible(true);
			}
		});
		
		setContentPane(contentPane);
	}
	
	public ArrayList<JPanel> showPost(ArrayList<Blogs> list) {
		ArrayList<JPanel> blogPanel = new ArrayList<>(); 
		for (Blogs blog : list) {
			JPanel panel = new JPanel(); 
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			// panel.setPreferredSize(new Dimension(590, 100));
			panel.setBackground(Color.white);
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			
			JPanel subPanel = new JPanel(); 
			subPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			subPanel.setBackground(Color.white);
			JLabel titleLabel = new JLabel(blog.get_Title()); 
			titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			JLabel usernameLabel = new JLabel("• Posted by " + blog.get_Username()); 
			JLabel datePosted = new JLabel(" at " + blog.get_Date()); 
			datePosted.setForeground(Color.gray);
			subPanel.add(titleLabel); 
			subPanel.add(usernameLabel); 
			subPanel.add(datePosted); 
			
			
			JPanel bodyPanel = new JPanel();
			bodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			bodyPanel.setBackground(Color.white);
			
			// if the body is too long, break the lines
			if (blog.get_Body().length() >= 80) {
				String text = "<html>"; 
				for (int i = 0; i < blog.get_Body().length(); i++) {
					text += blog.get_Body().charAt(i); 
					if (text.length() % 80 == 0) {
						text += "<br>"; 
					}
				}
				text += "</html>"; 
				JLabel bodyPost = new JLabel(text); 
				bodyPanel.add(bodyPost); 
			} 
			else { // just show it otherwise
				JLabel bodyPost = new JLabel(blog.get_Body()); 
				bodyPanel.add(bodyPost); 
			}
			
			JPanel buttonPanel = new JPanel(); 
			buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			buttonPanel.setBackground(panel.getBackground());
			JButton likeButton = new JButton("Like"); 
			JButton commentButton = new JButton("Comment"); 
			
			buttonPanel.add(likeButton); 
			buttonPanel.add(commentButton); 
			
			if (blog.get_Username().equals(user.getUsername())) {
				JButton editButton = new JButton("Setting"); 
				buttonPanel.add(editButton);
			}
			
			panel.add(subPanel); 
			panel.add(bodyPanel); 
			panel.add(buttonPanel); 
			
			
			blogPanel.add(panel); 
			
			// add mouse listener for this whole panel
			panel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					BlogFrame blogFrame = new BlogFrame(blog); 
					blogFrame.setVisible(true);
				}
			});
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
			postBlogFrame pbf = new postBlogFrame(user); 
			pbf.setVisible(true);
		}
	}
}
