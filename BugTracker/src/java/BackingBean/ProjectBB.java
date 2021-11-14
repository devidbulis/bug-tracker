package BackingBean;

import dto.ProjectDTO;
import facade.TableFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "projectBB")
@RequestScoped
public class ProjectBB
{

    private TableFacade tableFacade = new TableFacade();

    private ProjectDTO project;
    private ArrayList<ProjectDTO> projects = new ArrayList<>();

    public ProjectBB()
    {
    }

    public boolean addProject(String name,String description){
        return tableFacade.addProject(name,description);
    }
    public ProjectDTO getProject(int projectId)
    {
        project = tableFacade.getProject(projectId);
        return project;
    }

    public ArrayList<ProjectDTO> getAllProjects()
    {
        projects = tableFacade.getAllProjects();
        return projects;
    }
}