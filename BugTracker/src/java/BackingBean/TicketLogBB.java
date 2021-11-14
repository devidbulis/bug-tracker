package BackingBean;

import dto.TicketLogDTO;
import facade.TableFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "ticketLogBB")
@RequestScoped
public class TicketLogBB
{

    private TableFacade tableFacade = new TableFacade();

    private TicketLogDTO ticketLog;
    private ArrayList<TicketLogDTO> ticketLogs = new ArrayList<>();

    public TicketLogBB()
    {
    }

    public boolean addTicketLog(String property,String oldValue,String newValue,String changedDateTime,int projectId,int devId){
        return tableFacade.addTicketLog(property,oldValue,newValue,changedDateTime,projectId,devId);
    }
    public TicketLogDTO getTicketLog(int ticketLogId)
    {
        ticketLog = tableFacade.getTicketLog(ticketLogId);
        return ticketLog;
    }

    public ArrayList<TicketLogDTO> getAllTicketLogs(int projectId)
    {
        ticketLogs = tableFacade.getAllTicketLogs(projectId);
        return ticketLogs;
    }
}