public class Comment {
    
    private String text;
    private User commenter;
    private Long createdDateTime;
    
    public Comment(String text, User commenter){
        this.text = text;
        this.commenter = commenter;
        this.createdDateTime = System.currentTimeMillis();
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
