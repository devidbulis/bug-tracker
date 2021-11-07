package Bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "user")
@SessionScoped
public class CurrentUser implements Serializable
{
    private String email;
    
    private boolean loggedIn = false;

    public String getEmail()
    {
        return email;
    }

    public boolean isLoggedIn()
    {
        return loggedIn;
    }

    public void logIn(String email)
    {
        this.email = email;
        loggedIn = true;
    }

    public String logOut()
    {
        this.email = "";
        this.loggedIn = false;
        return "/index?faces-redirect=true";
    }
}
