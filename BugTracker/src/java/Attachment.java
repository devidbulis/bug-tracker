public class Attachment {
    
    private int id;
    private String fileName;
    private User uploader;
    private String notes;
    private Long createdDateTime;
    
    public Attachment(int id, String fileName, User uploader, String notes){
        this.id = id;
        this.fileName = fileName;
        this.uploader = uploader;
        this.notes = notes;
        this.createdDateTime = System.currentTimeMillis();
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
