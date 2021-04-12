package PageHome;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PageHome extends JFrame {

	JPanel contentPane;
	JLabel logoLabel; 
	JTextField searchBar; 
	JButton postBlogBtn; 
	JButton logoutBtn; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageHome frame = new PageHome();
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
	public PageHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 300);
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
		navbarPanel.add(logoutBtn); 
		
		// set up container: 
		container.setPreferredSize(new Dimension(contentPane.getWidth(), contentPane.getHeight() - navbarPanel.getSize().height));
		container.setBackground(contentPane.getBackground());
		container.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		scrollPanel.setBackground(contentPane.getBackground());
		JScrollPane scrollPane = new JScrollPane(scrollPanel); 
		scrollPane.setPreferredSize(new Dimension(600, 700));
		
		container.add(scrollPane, gbc); 
		
		sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
		sidebarPanel.setBackground(contentPane.getBackground());
		JScrollPane sidebarScroll = new JScrollPane(sidebarPanel); 
		sidebarScroll.setPreferredSize(new Dimension(300, 700));
		
		gbc.gridx = 1; 
		gbc.gridy = 0; 
		container.add(sidebarScroll, gbc); 
		
		// contentPane adding all their child components
		contentPane.add(navbarPanel); 
		contentPane.add(container); 
		
		setContentPane(contentPane);
	}

}
