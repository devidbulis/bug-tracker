package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="comment")
public class CommentDTO implements Serializable
{
    private int id;
    private String text;
    private String createdDateTime;
    private int projectId;
    private int commenterId;

    public CommentDTO(int id, String name,String createdDateTime,int projectId,int commenterId)
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

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getCommenterId() {
        return commenterId;
    }
    
}
