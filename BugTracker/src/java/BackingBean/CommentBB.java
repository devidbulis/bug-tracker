package BackingBean;

import dto.CommentDTO;
import facade.TableFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "commentBB")
@RequestScoped
public class CommentBB
{

    private TableFacade tableFacade = new TableFacade();

    private CommentDTO comment;
    private ArrayList<CommentDTO> comments = new ArrayList<>();

    public CommentBB()
    {
    }

    public boolean addComment(String name,String createdDateTime,int projectId,int commenterId){
        return tableFacade.addComment(name,createdDateTime,projectId,commenterId);
    }
    public CommentDTO getComment(int commentId)
    {
        comment = tableFacade.getComment(commentId);
        return comment;
    }

    public ArrayList<CommentDTO> getAllComments(int projectId)
    {
        comments = tableFacade.getAllComments(projectId);
        return comments;
    }
}