package Bean;

import dbase.UserGateway;
import facade.UserFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import Bean.CurrentUser;
import java.io.Serializable;
import util.StringHasher;


@Named(value = "login")
@SessionScoped
public class LoginBean implements Serializable
{

    @Inject
    private UserGateway userGateway;
    
    @Inject
    private StringHasher hasher;
    
    @Inject
    CurrentUser user;
    
    private String name;
    private String email;
    private String password;
    private String hashedPassword;
    private String role;
    private String id;
    
    private UserFacade userFacade = new UserFacade();

    public String getName() {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getId() {
        return id;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
        hashedPassword = hasher.hashString(hasher.hashString(password));
        System.out.println("HASHED PASSWORD: " + hashedPassword);
    }

    public String checkCredentials()
    {
        if (userGateway.credentialsAreOK(email, hashedPassword))
        {
            user.logIn(email);
            name = userFacade.getUser(email).getName();
            role = userFacade.getUser(email).getRole();
            id = Integer.toString(userFacade.getUser(email).getId());
            return "secure/main?faces-redirect=true";
        }
        else
        {
            return "index?faces-redirect=true";
        }
    }
}
