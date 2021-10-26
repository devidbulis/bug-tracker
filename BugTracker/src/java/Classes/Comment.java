package Classes;


import Classes.User;

public class Comment {
    
    private int id;
    private String text;
    private User commenter;
    private Long createdDateTime;
    
    public Comment(int id, String text, User commenter){
        this.id = id;
        this.text = text;
        this.commenter = commenter;
        this.createdDateTime = System.currentTimeMillis();
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public Long getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
