public class Comment {
    
    private int num;
    private String text;
    private User commenter;
    private Long createdDateTime;
    
    public Comment(String text, User commenter){
        this.num = num;
        this.text = text;
        this.commenter = commenter;
        this.createdDateTime = System.currentTimeMillis();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
