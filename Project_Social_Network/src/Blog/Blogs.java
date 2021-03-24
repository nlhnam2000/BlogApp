package Blog;

import Status.BlogStatus;

public class Blogs{

    protected String Title;
    protected int BlogID;
    protected String Username;
    protected String Body;
    protected boolean CommentEnabled;
    protected boolean DeleteBlog;
    protected String Date;
    protected boolean Edit;
    protected BlogStatus status;

    Blogs(){}

    Blogs(String title, int blogid, String username, String body, boolean cmtEnabled, boolean delete, String
    date, boolean edit, BlogStatus statuss){
        this.Title = title;
        this.BlogID = blogid;
        this.Username = username;
        this.Body = body;
        this.CommentEnabled = cmtEnabled;
        this.DeleteBlog = delete;
        this.Date = date;
        this.Edit = edit;
        this.status = statuss;
    }

    Blogs(Blogs b){
        this.Title = b.Title;
        this.BlogID = b.BlogID;
        this.Username = b.Username;
        this.Body = b.Body;
        this.CommentEnabled = b.CommentEnabled;
        this.DeleteBlog = b.DeleteBlog;
        this.Date = b.Date;
        this.Edit = b.Edit;
        this.status = b.status;
    }

    /// Method get

    public String get_Title(){
        return this.Title;
    }

    public int get_BlogID(){
        return this.BlogID;
    }

    public String get_Username(){
        return this.Username;
    }

    public String get_Body(){
        return this.Body;
    }

    public boolean get_CommentEnabled(){
        return this.CommentEnabled;
    }

    
    public boolean get_DeleteBlog(){
        return this.DeleteBlog;
    }

    public String get_Date(){
        return this.Date;
    }

    public boolean get_Edit(){
        return this.Edit;
    }

    // Method set

    public void set_Title(String title){
        this.Title = title;
    }

    public void set_BlogID(int blogid){
        this.BlogID = blogid;
    }

    public void set_Username(String username){
        this.Username = username;
    }

    public void set_Body(String body){
        this.Body = body;
    }

    public void set_CommentEnabled(boolean cmtEnabled){
        this.CommentEnabled = cmtEnabled;
    }

    
    public void set_DeleteBlog(boolean delete){
        this.DeleteBlog = delete;
    }

    public void set_Date(String date){
        this.Date = date;
    }

    public void set_Edit(boolean edit){
        this.Edit = edit;
    }


    /// Method


    public void PostBlog(){

    }

    public void ViewBlog(){

    }

    public void LikeBlog(){

    }

    public void DeleteBlog(){

    }

    public void EditBlog(){

    }

    public void CommentEnable(){

    }

    public void SetPrivacy(){
        
    }

}