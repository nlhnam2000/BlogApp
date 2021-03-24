package User;



public class Users{

    protected String Username;
    protected String Password;
	protected String First_Name;
    protected String Last_Name;
    protected String Date_Of_Birth;
    protected String Adress;
    protected String Email;
    
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





    Users(Users a){
        this.Username = a.Username;
        this.Password = a.Password;
        this.First_Name = a.First_Name;
        this.Last_Name = a.Last_Name;
        this.Date_Of_Birth = a.Date_Of_Birth;
        this.Adress = a.Adress;
        this.Email = a.Email;
    }



    // Method 

    public void Login(){

    }

    public void Logout(){

    }

    public void SignUp(){

    }

    public boolean Validation(){
        return true;
    }

    public void PostBlog(){

    }

    public void ViewsBlog(){

    }

    public void CommentBlog(){

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