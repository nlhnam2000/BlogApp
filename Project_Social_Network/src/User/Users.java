package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Blog.*;
import Interactive.*;
import LoginDesign.FrameLogin;
import HashPw.BCrypt;
import Status.*;

public class Users{

    protected String Username;
    protected String Password;
	protected String First_Name;
    protected String Last_Name;
    protected String Date_Of_Birth;
    protected String Adress;
    protected String Email;
    protected ArrayList<Blogs> blog = new ArrayList<Blogs>();
    protected ArrayList<Interactives> cmt = new ArrayList<Interactives>();
    protected int UserID;
    
    public Users() {
    	
    }
    
    public Users(String username, String password, String first_Name, String last_Name, String date_Of_Birth,
			String adress, String email) {
		super();
		Username = username;
		Password = password;
		First_Name = first_Name;
		Last_Name = last_Name;
		Date_Of_Birth = date_Of_Birth;
		Adress = adress;
		Email = email;
	}



	public String getUsername() {
		return Username;
	}



	public void setUsername(String username) {
		Username = username;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getFirst_Name() {
		return First_Name;
	}



	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}



	public String getLast_Name() {
		return Last_Name;
	}



	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}



	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}



	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}



	public String getAdress() {
		return Adress;
	}



	public void setAdress(String adress) {
		Adress = adress;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}





    public Users(Users a){
        this.Username = a.Username;
        this.Password = a.Password;
        this.First_Name = a.First_Name;
        this.Last_Name = a.Last_Name;
        this.Date_Of_Birth = a.Date_Of_Birth;
        this.Adress = a.Adress;
        this.Email = a.Email;
    }



    // Method 

    public boolean Login(String username, String password){
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();
    		String getAllUser = "Select * From User_Social";
    		ResultSet r = stmt.executeQuery(getAllUser);
			while(r.next()) {
				if(r.getString("Username").equals(username) && BCrypt.checkpw(password, r.getString("Passwork"))) {
					this.UserID = r.getInt("UserID");
					this.Username = r.getString("Username");
					this.Password = r.getString("Passwork");
					this.First_Name = r.getString("First_Name");
					this.Last_Name = r.getString("Last_Name");
					this.Date_Of_Birth = r.getString("Date_of_birth");
					this.Adress = r.getString("Adress");
					this.Email = r.getString("Email");
					return true;
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
		
		
		return false;
    }

    public void Logout(){
    	this.UserID = 0;
    	this.Username = "";
    	this.Password = "";
    	this.First_Name = "";
    	this.Last_Name = "";
    	this.Date_Of_Birth = "";
    	this.Adress ="";
    	this.Email = "";
    	this.blog.clear();
    	this.cmt.clear();
    }

    public void SignUp(){
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();
    	
    		String insert = "Insert Into User_Social Values('" + this.getFirst_Name() + "','"
    				+ this.getLast_Name() + "','" + this.getUsername() + "','" + this.getPassword() + "','" + this.getDate_Of_Birth() + "','" + 
    				this.getAdress() + "','" + this.getEmail() + "')";
    		stmt.executeUpdate(insert);
    		conn.commit();
 
    		
    		
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class.");
    		System.exit(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    

    public boolean Validation(){
        return true;
    }

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
				if(r.getString("Username").equals(this.Username))
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
    
    public void getAllCmt() {
    	this.cmt.clear();
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();
    		String getAllUser = "Select * From Comment";
    		ResultSet r = stmt.executeQuery(getAllUser);
			while(r.next()) {
				if(r.getString("Username").equals(this.Username))
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
    
    public boolean PostBlog(Blogs b){
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();
    		int Hitcmt = 0;
    		int HitLike = 0;
    		String insert = "Insert Into Blog Values('" + this.getFirst_Name() + "','"
    				+ this.getLast_Name() + "','" + this.UserID + "','" + this.getUsername() + "','" + b.get_Title() + "','" + 
    				b.get_Body() + "','" + b.get_CommentEnabled() + "','" + b.get_DeleteBlog() + "','" + b.get_Edit()
    				+ "','" + b.get_Date() + "','" + Hitcmt + "','" + HitLike + "')";
    		stmt.executeUpdate(insert);
    		conn.commit();
    		return true;
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class.");
    		System.exit(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return false;
    }

    public void ViewsBlog(){
    	
    }

    public boolean PostCmnt(Interactives inter){
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String DB_URL = "jdbc:sqlserver://localhost:62673;databaseName=Social_Network;integratedSecurity=true;";
    		Connection conn = DriverManager.getConnection(DB_URL);
    		Statement stmt = conn.createStatement();

    		String insert = "Insert Into Comment Values('" + this.UserID + "','"
    				+ this.getUsername() + "','" + inter.getUsernameBlog() + "','" + inter.get_BlogID() + "','" + inter.get_Body() + "','" + 
    				inter.get_DeleteCmt() + "','" + inter.get_EditCmt() + "','" + inter.get_Date() + "')";
    		stmt.executeUpdate(insert);
    		conn.commit();
    		return true;
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class.");
    		System.exit(1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return false;
    }

    public void EditComment(){

    }

    public void DeleteComment(){

    }

    public void LikeBlog(){

    }

    public void DeleteBlog(){

    }

    public void EditBlog(){

    }

    public void SetPrivacy(){
        
    }
}