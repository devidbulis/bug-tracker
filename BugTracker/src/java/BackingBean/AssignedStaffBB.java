package BackingBean;

import dto.AssignedStaffDTO;
import facade.TableFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "assignedStaffBB")
@RequestScoped
public class AssignedStaffBB
{

    private TableFacade tableFacade = new TableFacade();

    private ArrayList<AssignedStaffDTO> assignedStaff = new ArrayList<>();

    public AssignedStaffBB()
    {
    }

    public boolean addAssignedStaff(int projectId,int userId){
        return tableFacade.addAssignedStaff(projectId,userId);
    }

    public ArrayList<AssignedStaffDTO> getAllAssignedStaff(int projectId)
    {
        assignedStaff = tableFacade.getAllAssignedStaff(projectId);
        return assignedStaff;
    }
}