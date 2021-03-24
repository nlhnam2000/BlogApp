package Interactive;


public class Interactives{

    protected String Username;
    protected int BlogID;
    protected int CommentID;
    protected String Body;
    protected boolean DeleteCmt;
    protected boolean EditCmt;
    protected String Date;

    Interactives(){}

    Interactives(String username, int blogid, int cmtid, String body, boolean deletecmt, boolean editcmt, String date){
        this.Username = username;
        this.BlogID = blogid;
        this.CommentID = cmtid;
        this.Body = body;
        this.DeleteCmt = deletecmt;
        this.EditCmt = editcmt;
        this.Date = date;
    }

    Interactives(Interactives i){
        this.Username = i.Username;
        this.BlogID = i.BlogID;
        this.CommentID = i.CommentID;
        this.Body = i.Body;
        this.DeleteCmt = i.DeleteCmt;
        this.EditCmt = i.EditCmt;
        this.Date = i.Date;
    }

    /// Method get

    public String get_Username(){
        return this.Username;
    }

    public int get_BlogID(){
        return this.BlogID;
    }

    public int get_CmtID(){
        return this.CommentID;
    }

    public String get_Body(){
        return this.Body;
    }

    public boolean get_DeleteCmt(){
        return this.DeleteCmt;
    }

    public boolean get_EditCmt(){
        return this.EditCmt;
    }

    public String get_Date(){
        return this.Date;
    }

    /// Method set 

    public void set_Username(String username){
        this.Username = username;
    }

    public void set_BlogID(int blogid){
        this.BlogID = blogid;
    }

    public void set_CmtID(int cmtid){
        this.CommentID = cmtid;
    }

    public void set_Body(String body){
        this.Body = body;
    }

    public void set_DeleteCmt(boolean deletecmt){
        this.DeleteCmt = deletecmt;
    }

    public void set_EditCmt(boolean editcmt){
        this.EditCmt = editcmt;
    }

    public void set_Date(String date){
        this.Date = date;
    }


    /// Method


    public void CommentBlog(){

    }

    public void EditComment(){

    }


    public void DeleteComment(){
        
    }

}