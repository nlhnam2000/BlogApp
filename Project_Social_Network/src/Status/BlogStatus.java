package Status;


public class BlogStatus{
    protected boolean status;
    
    BlogStatus(){
        this.status = false;
    }

    BlogStatus(BlogStatus b){
        this.status = b.status;
    }

    public boolean get(){
        boolean ans = this.status;
        return ans;
    }

    public void set(boolean a){
        this.status = a;
    }
}