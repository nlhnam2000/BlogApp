package Notification;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import AccountManagement.Account;
import Blog.Blogs;
import Profile.BlogQuery;
import Profile.ProfileQuery;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class NotificationManagement extends JFrame {
	private static final String id = "3";
	private ArrayList<Interaction> noticeList;
	private ImageIcon edit = new ImageIcon("src/FrameImages/edit.jpg");
	private JPanel contentPane;
	private JList list;
	private JLabel lblNoticeNumber;
	private JLabel lblOptimize;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotificationManagement frame = new NotificationManagement();
					frame.showInfo();
					frame.showNotification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showInfo() {
		JTextPane usernameProfile = new JTextPane();
		usernameProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameProfile.setBackground(new Color(135, 206, 235));
		usernameProfile.setBounds(155, 5, 350, 35);
		
		JTextPane subInfo = new JTextPane();
		subInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		subInfo.setBackground(new Color(135, 206, 235));
		subInfo.setBounds(150, 35, 500, 60);
		
		ProfileQuery profile = new ProfileQuery();
		Account profileInfo = profile.getAllAccount(this.id);
		System.out.println(profileInfo.getUsername());
		usernameProfile.setText(profileInfo.getFirstName() + " " + profileInfo.getLastName() + " ( " + profileInfo.getUsername() + " )");
		usernameProfile.setEditable(false);
		String subInfoProfile = " Date of birth: " + profileInfo.getDateOfBirth()
					+ "\n Address: " + profileInfo.getAddress()
					+ "\n Email: " + profileInfo.getEmail();
		subInfo.setText(subInfoProfile);
		subInfo.setEditable(false);
		getContentPane().add(usernameProfile);
		getContentPane().add(subInfo);
	}
	
	public void showNotification() {
		InteractionQuery noticeQuery = new InteractionQuery();
		this.noticeList = new ArrayList<Interaction>();
		noticeQuery.getAllNoticeById(NotificationManagement.this.id);
		this.noticeList = noticeQuery.getNotice();
		String[] values = new String[noticeList.size()];
	//	System.out.println(noticeList.get(0).getBlogId());
		int j = 0;
		
		for (int i = noticeList.size() - 1; i >= 0; i--) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");  
			LocalDateTime now = LocalDateTime.now();
			String noticeDate = noticeList.get(i).getDate();
			LocalDateTime past = LocalDateTime.parse(noticeDate, dtf);
			Duration duration = Duration.between(past, now);
			values[j] = "<html>[" + duration.toDays() + " days " + duration.toHoursPart() + " hours " + duration.toMinutesPart()+ " minutes ago]<br/><b>" + String.valueOf(noticeList.get(i).getNotice() + "<hr/>");
			j++;
		}
		this.list.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lblNoticeNumber.setText("You have just received " + noticeList.size() + " notifications");
	}
	
	public void searchNotice() {
		
	}
	public NotificationManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(145, 9, 11, 84);
		contentPane.add(separator);
		
		JPanel body = new JPanel();
		body.setBackground(new Color(245, 245, 245));
		body.setBounds(0, 103, 586, 260);
		contentPane.add(body);
		body.setLayout(null);
		
		JLabel lblNotice = new JLabel("NOTIFICATION");
		lblNotice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNotice.setBounds(240, 15, 116, 13);
		body.add(lblNotice);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setBounds(10, 73, 330, 135);
		body.add(scrollPane_1);
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane_1.setViewportView(list);
		list.setBackground(new Color(245, 245, 245));
		
		lblNoticeNumber = new JLabel();
		lblNoticeNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoticeNumber.setBounds(45, 45, 350, 22);
		body.add(lblNoticeNumber);
		
		lblOptimize = new JLabel("OPTIMIZE SEARCH RESULTS");
		lblOptimize.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOptimize.setBounds(365, 45, 211, 22);
		body.add(lblOptimize);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(350, 52, 5, 198);
		body.add(separator_2);
		
		JButton btnViewBlog = new JButton("View Blog");
		btnViewBlog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewBlog.setBounds(117, 220, 103, 21);
		body.add(btnViewBlog);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(365, 97, 211, 19);
		body.add(textField);
		textField.setColumns(10);
		
		JLabel lblNameSearch = new JLabel("Name:");
		lblNameSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameSearch.setBounds(365, 79, 151, 13);
		body.add(lblNameSearch);
		
		JLabel lblDateFrom = new JLabel("From:");
		lblDateFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateFrom.setBounds(365, 120, 39, 13);
		body.add(lblDateFrom);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(365, 140, 120, 19);
		body.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(510, 140, 60, 19);
		body.add(yearChooser);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(365, 165, 39, 13);
		body.add(lblTo);
		
		JMonthChooser monthChooser_1 = new JMonthChooser();
		monthChooser_1.setBounds(365, 180, 120, 19);
		body.add(monthChooser_1);
		
		JYearChooser yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(510, 180, 60, 19);
		body.add(yearChooser_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(431, 220, 85, 21);
		body.add(btnNewButton);
		
		JButton btnHome = new JButton("Homepage");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setBounds(10, 9, 125, 21);
		contentPane.add(btnHome);
		
		JButton btnActivities = new JButton("Notification");
		btnActivities.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActivities.setBounds(10, 40, 125, 21);
		contentPane.add(btnActivities);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.setBounds(10, 72, 125, 21);
		contentPane.add(btnLogOut);
		
		JButton btnEditImg = new JButton(edit);
		edit.setDescription("Edit profile");
		btnEditImg.setBounds(498, 28, 65, 65);
		contentPane.add(btnEditImg);
		
		
	}
}
