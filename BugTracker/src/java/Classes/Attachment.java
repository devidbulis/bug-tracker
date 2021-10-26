package Classes;


import Classes.User;

public class Attachment {
    
    private int id;
    private String fileName;
    private User uploader;
    private String notes;
    private Long uploadedDateTime;
    
    public Attachment(int id, String fileName, User uploader, String notes){
        this.id = id;
        this.fileName = fileName;
        this.uploader = uploader;
        this.notes = notes;
        this.uploadedDateTime = System.currentTimeMillis();
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

    public Long getUploadedDateTime() {
        return uploadedDateTime;
    }

    public void setUploadedDateTime(Long uploadedDateTime) {
        this.uploadedDateTime = uploadedDateTime;
    }
}
