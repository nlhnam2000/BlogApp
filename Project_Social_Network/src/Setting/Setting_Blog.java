package Setting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Blog.Blogs;
import Query.QuerySQL;
import User.Users;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Setting_Blog extends JFrame {

	
	//
	Users user;
	
	//
	
	private JPanel contentPane;
	JList<String> list;
	QuerySQL squery;
	
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNotEdit;
	JRadioButton rdbtnCanComment;
	JRadioButton rdbtnNotComment;
	JRadioButton rdbtnCanDelete;
	JRadioButton rdbtnNotDelete;
	
	Boolean state_Edit;
	Boolean state_Cmt;
	Boolean state_Delete;
	int blog_Id;
	private JTextField textField;
	ArrayList<Blogs> list_Blog = new ArrayList<Blogs>();
	private JTextArea date;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setting_Blog frame = new Setting_Blog();
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
	

	public Setting_Blog() {
		this.setTitle("Setting Blog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 642, 60);
		panel.setBorder(new LineBorder(new Color(0, 255, 255), 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 10, 169, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Page home");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(51, 255, 255));
		btnNewButton.setBounds(204, 5, 114, 40);
		panel.add(btnNewButton);
		
		JButton btnPagePersonnel = new JButton("Page personnel");
		btnPagePersonnel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPagePersonnel.setBackground(new Color(255, 204, 153));
		btnPagePersonnel.setBounds(349, 5, 114, 40);
		panel.add(btnPagePersonnel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBackground(new Color(255, 255, 153));
		btnLogout.setBounds(504, 5, 114, 40);
		panel.add(btnLogout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 112, 204, 253);
		contentPane.add(scrollPane);
		
		squery = new QuerySQL();
		squery.getAllBlog("username");
		list_Blog.clear();
		for(int i = 0; i < squery.getBlog().size(); i++) {
			list_Blog.add(squery.getBlog().get(i));
		}
		
		String[] list_blog = new String[list_Blog.size()];
		for(int i = 0; i < list_Blog.size(); i++) {
			list_blog[i] = list_Blog.get(i).get_Title();
		}
		list = new JList(list_blog);
		list.setBorder(new LineBorder(new Color(152, 251, 152)));
		scrollPane.setViewportView(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(175, 238, 238)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(201, 112, 441, 253);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Edit");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 90, 24);
		panel_1.add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("Can edit");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(77, 37, 103, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnNotEdit = new JRadioButton("Not edit");
		rdbtnNotEdit.setBackground(new Color(255, 255, 255));
		rdbtnNotEdit.setBounds(77, 60, 103, 21);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNotEdit);
		panel_1.add(rdbtnNotEdit);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Comment");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 83, 90, 24);
		panel_1.add(lblNewLabel_1_1);
		
		rdbtnCanComment = new JRadioButton("Can comment");
		rdbtnCanComment.setBackground(Color.WHITE);
		rdbtnCanComment.setBounds(77, 110, 103, 21);
		panel_1.add(rdbtnCanComment);
		
		rdbtnNotComment = new JRadioButton("Not comment");
		rdbtnNotComment.setBackground(Color.WHITE);
		rdbtnNotComment.setBounds(77, 133, 103, 21);
		
		
		ButtonGroup group_cmt = new ButtonGroup();
		group_cmt.add(rdbtnCanComment);
		group_cmt.add(rdbtnNotComment);
		
		
		panel_1.add(rdbtnNotComment);
		
		JLabel lblNewLabel_1_2 = new JLabel("Delete");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(10, 162, 90, 24);
		panel_1.add(lblNewLabel_1_2);
		
		rdbtnCanDelete = new JRadioButton("Can delete");
		rdbtnCanDelete.setBackground(Color.WHITE);
		rdbtnCanDelete.setBounds(77, 189, 103, 21);
		panel_1.add(rdbtnCanDelete);
		
		rdbtnNotDelete = new JRadioButton("Not delete");
		rdbtnNotDelete.setBackground(Color.WHITE);
		rdbtnNotDelete.setBounds(77, 212, 103, 21);
		
		ButtonGroup group_delete = new ButtonGroup();
		group_delete.add(rdbtnCanDelete);
		group_delete.add(rdbtnNotDelete);
		
		panel_1.add(rdbtnNotDelete);
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(173, 216, 230)));
		panel_2.setBounds(0, 59, 642, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Get all blog");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list_Blog.clear();
				for(int i = 0; i < squery.getBlog().size(); i++) {
					list_Blog.add(squery.getBlog().get(i));
				}
				
				String[] list_blog = new String[list_Blog.size()];
				for(int i = 0; i < list_Blog.size(); i++) {
					list_blog[i] = list_Blog.get(i).get_Title();
				}
				list.setListData(list_blog);
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(245, 245, 220));
		btnNewButton_1.setBounds(10, 10, 189, 31);
		panel_2.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(213, 10, 281, 31);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list_Blog.clear();
				if(textField.getText().length() > 0) {
					String s = textField.getText();
					for(int i = 0; i < squery.getBlog().size(); i++) {
						if(squery.getBlog().get(i).get_Title().toLowerCase().contains(s.toLowerCase())) {
							list_Blog.add(squery.getBlog().get(i));
						}
					}
					String[] list_blog = new String[list_Blog.size()];
					for(int i = 0; i < list_Blog.size(); i++) {
						list_blog[i] = list_Blog.get(i).get_Title();
					}
					list.setListData(list_blog);
					
				}
				else {
					list_Blog.clear();
					for(int i = 0; i < squery.getBlog().size(); i++) {
						list_Blog.add(squery.getBlog().get(i));
					}
					
					String[] list_blog = new String[list_Blog.size()];
					for(int i = 0; i < list_Blog.size(); i++) {
						list_blog[i] = list_Blog.get(i).get_Title();
					}
					list.setListData(list_blog);
				}
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.setBounds(504, 10, 112, 31);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
	
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBackground(new Color(135, 206, 250));
		btnNewButton_3.setBounds(386, 369, 85, 44);
		contentPane.add(btnNewButton_3);
		
		
		
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = list.getSelectedIndex();
				blog_Id = list_Blog.get(idx).get_BlogID();
				if (idx != -1)
				{
					Border border = BorderFactory.createTitledBorder(list_Blog.get(idx).get_Date());
					panel_1.setBorder(border);
					if(list_Blog.get(idx).get_Edit()) {
						rdbtnNewRadioButton.setSelected(true);
						state_Edit = true;
					}
					else {
						rdbtnNotEdit.setSelected(true);
						state_Edit = false;
					}
					if(list_Blog.get(idx).get_CommentEnabled()) {
						rdbtnCanComment.setSelected(true);
						state_Cmt = true;
					}
					else {
						rdbtnNotComment.setSelected(true);
						state_Cmt = false;
					}
					if(list_Blog.get(idx).get_DeleteBlog()) {
						rdbtnCanDelete.setSelected(true);
						state_Delete = true;
					}
					else {
						rdbtnNotDelete.setSelected(true);
						state_Delete = false;
					}
				}
				
			}
			
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					if(!state_Edit) {
						squery.SetEditBlog(blog_Id);
					}
				}
				else {
					if(state_Edit) {
						squery.SetEditBlog(blog_Id);
					}
				}
				if(rdbtnCanComment.isSelected()) {
					if(!state_Cmt) {
						squery.SetCmtEnabled(blog_Id);
					}
				}
				else {
					if(state_Cmt) {
						squery.SetCmtEnabled(blog_Id);
					}
				}
				if(rdbtnCanDelete.isSelected()) {
					if(!state_Delete) {
						squery.SetDeleteBlog(blog_Id);
					}
				}
				else {
					if(state_Delete) {
						squery.SetDeleteBlog(blog_Id);
					}
				}
				squery.getAllBlog("username");
				list_Blog.clear();
				for(int i = 0; i < squery.getBlog().size(); i++) {
					list_Blog.add(squery.getBlog().get(i));
				}
				
				String[] list_blog = new String[list_Blog.size()];
				for(int i = 0; i < list_Blog.size(); i++) {
					list_blog[i] = list_Blog.get(i).get_Title();
				}
				list.setListData(list_blog);
				
				
			}
		});
	}
}
