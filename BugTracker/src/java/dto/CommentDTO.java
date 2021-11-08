package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="comment")
public class CommentDTO implements Serializable
{
    private int id;
    private String text;
    private long createdDateTime;
    private int projectId;
    private int commenterId;

    public CommentDTO(int id, String name,long createdDateTime,int projectId,int commenterId)
    {
        this.id = id;
        this.text = text;
        this.createdDateTime = createdDateTime;
        this.projectId = projectId;
        this.commenterId = commenterId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public long getCreatedDateTime() {
        return createdDateTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getCommenterId() {
        return commenterId;
    }
    
}
