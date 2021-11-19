package BackingBean;

import dto.UserDTO;
import facade.TableFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "userBB")
@RequestScoped
public class UserBB
{

    private TableFacade tableFacade = new TableFacade();

    private UserDTO user;
    private ArrayList<UserDTO> users = new ArrayList<>();

    public UserBB()
    {
    }

    public boolean addUser(String name,String email,String password){
        return tableFacade.addUser(name, email, password);
    }
    public boolean changeUserRole(String email,String role){
        return tableFacade.changeUserRole(email, role);
    }
    public UserDTO getUser(String email)
    {
        user = tableFacade.getUser(email);
        return user;
    }

    public ArrayList<UserDTO> getUsers()
    {
        users = tableFacade.getAllUsers();
        return users;
    }
}