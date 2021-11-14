package BackingBean;

import dto.AttachmentDTO;
import facade.TableFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "attachmentBB")
@RequestScoped
public class AttachmentBB
{

    private TableFacade tableFacade = new TableFacade();

    private AttachmentDTO attachment;
    private ArrayList<AttachmentDTO> attachments = new ArrayList<>();

    public AttachmentBB()
    {
    }

    public boolean addAttachment(String name,String notes,String uploadedDateTime,int projectId,int userId){
        return tableFacade.addAttachment(name,notes,uploadedDateTime,projectId,userId);
    }
    public AttachmentDTO getAttachment(int attachmentId)
    {
        attachment = tableFacade.getAttachment(attachmentId);
        return attachment;
    }

    public ArrayList<AttachmentDTO> getAllAttachments(int projectId)
    {
        attachments = tableFacade.getAllAttachments(projectId);
        return attachments;
    }
}