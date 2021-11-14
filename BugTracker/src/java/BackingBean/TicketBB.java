package BackingBean;

import dto.TicketDTO;
import facade.TableFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "ticketBB")
@RequestScoped
public class TicketBB
{

    private TableFacade tableFacade = new TableFacade();

    private TicketDTO ticket;
    private ArrayList<TicketDTO> tickets = new ArrayList<>();

    public TicketBB()
    {
    }

    public boolean addTicket(String title,String description,String priority,String status,String type,String createdDateTime,
            String updatedDateTime,int projectId,int assignedDevId,int submitterId){
        
        return tableFacade.addTicket(title,description,priority,status,type,createdDateTime,
            updatedDateTime,projectId,assignedDevId,submitterId);
    }
    public TicketDTO getTicket(int ticketId)
    {
        ticket = tableFacade.getTicket(ticketId);
        return ticket;
    }

    public ArrayList<TicketDTO> getAllTickets(int projectId)
    {
        tickets = tableFacade.getAllTickets(projectId);
        return tickets;
    }
}