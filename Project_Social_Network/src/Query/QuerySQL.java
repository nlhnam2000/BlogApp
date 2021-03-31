package Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Blog.*;
import Interactive.*;
import Status.BlogStatus;

public class QuerySQL{
    ArrayList<Blogs> blog = new ArrayList<Blogs>();
    ArrayList<Interactives> cmt = new ArrayList<Interactives>();
    
    public void getAllBlog() {
    	this.blog.clear();
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();
    		String getAllUser = "Select * From Blog";
    		ResultSet r = stmt.executeQuery(getAllUser);
			while(r.next()) {
					BlogStatus stt = new BlogStatus();
					stt.set(r.getBoolean("Edit"));
					Blogs b = new Blogs(r.getString("Title"),r.getInt("BlogID"), r.getString("Username"),
							r.getString("Body"), r.getBoolean("CommentEnabled"),r.getBoolean("DeleteBlog"),
							r.getString("Date_of_blog"),r.getBoolean("Edit"), stt);
					b.getAllCmnt();
					this.blog.add(b);
			}
			r.close();
    		
    		
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class.");
    		System.exit(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    public void getAllBlog(String username) {
    	this.blog.clear();
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();
    		String getAllUser = "Select * From Blog";
    		ResultSet r = stmt.executeQuery(getAllUser);
			while(r.next()) {
				if(r.getString("Username").equals(username))
				{
					BlogStatus stt = new BlogStatus();
					stt.set(r.getBoolean("Edit"));
					Blogs b = new Blogs(r.getString("Title"),r.getInt("BlogID"), r.getString("Username"),
							r.getString("Body"), r.getBoolean("CommentEnabled"),r.getBoolean("DeleteBlog"),
							r.getString("Date_of_blog"),r.getBoolean("Edit"), stt);
					b.getAllCmnt();
					this.blog.add(b);
				}
				
				
			}
			r.close();
    		
    		
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class.");
    		System.exit(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    
    public void getAllCmnt(int blogid) {
    	this.cmt.clear();
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();
    		String getAllUser = "Select * From Comment";
    		ResultSet r = stmt.executeQuery(getAllUser);
			while(r.next()) {
				if(r.getString("BlogID").equals(blogid))
				{
					Interactives inter = new Interactives(r.getString("Username"), r.getInt("BlogID"), r.getInt("CommentID"),
							r.getString("Body"),r.getBoolean("Deletecmt"), r.getBoolean("Edit"), r.getString("Date_of_Comment"),
							r.getString("UsernameIDBlog"));
					this.cmt.add(inter);
				}
				
				
			}
			r.close();
    		
    		
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class.");
    		System.exit(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

	public ArrayList<Blogs> getBlog() {
		return blog;
	}

	public void setBlog(ArrayList<Blogs> blog) {
		this.blog = blog;
	}

	public ArrayList<Interactives> getCmt() {
		return cmt;
	}

	public void setCmt(ArrayList<Interactives> cmt) {
		this.cmt = cmt;
	}
    
    
    
}