package Bean;

import dto.UserDTO;
import facade.UserFacade;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "userBB")
@RequestScoped
public class UserBB
{

    private UserFacade userFacade = new UserFacade();

    private UserDTO user;
    private ArrayList<UserDTO> users = new ArrayList<>();

    public UserBB()
    {
    }

    public UserDTO getUser(String email)
    {
        user = userFacade.getUser(email);
        return user;
    }

    public ArrayList<UserDTO> getUsers()
    {
        users = userFacade.getAllUsers();
        return users;
    }
}
