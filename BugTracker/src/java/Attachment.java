public class Attachment {
    
    private int num;
    private String fileName;
    private User uploader;
    private String notes;
    private Long createdDateTime;
    
    public Attachment(int num, String fileName, User uploader, String notes){
        this.num = num;
        this.fileName = fileName;
        this.uploader = uploader;
        this.notes = notes;
        this.createdDateTime = System.currentTimeMillis();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
