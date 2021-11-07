package facade;

import dbase.UserGateway;
import dto.UserDTO;
import java.util.ArrayList;


public class UserFacade
{
    private UserGateway userGateway = new UserGateway();
    
    public boolean addUser(String name,String email,String password)
    {
        UserDTO u = userGateway.getUser(email);
        
        if (u == null)
        {
            userGateway.insertUser(name,email,password);
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public ArrayList<UserDTO> getAllUsers()
    {
        return userGateway.getAllUsers();
    }
    public UserDTO getUser(String email)
    {
        return userGateway.getUser(email);
    }
}
