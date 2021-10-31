package Bean;

import dbase.UserGateway;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import Bean.User;
import util.StringHasher;

@Named(value = "login")
@RequestScoped
public class LoginBean
{

    @Inject
    private UserGateway userGateway;
    
    @Inject
    private StringHasher hasher;
    
    @Inject
    User user;
    
    private String email;
    private String password;
    private String hashedPassword;

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
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
            return "secure/main?faces-redirect=true";
        }
        else
        {
            return "index?faces-redirect=true";
        }
    }
}
