package Bean;

import facade.UserFacade;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import util.StringHasher;

@Named(value = "register")
@RequestScoped
public class RegisterBean
{

    @Inject
    private StringHasher hasher;
    
    private UserFacade userFacade = new UserFacade();

    private String name;
    private String email;
    private String password;
    private String hashedPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
        hashedPassword = hasher.hashString(hasher.hashString(password));
    }

    public String registerUser()
    {
        if (userFacade.addUser(name, email, hashedPassword))
        {
            return "index?faces-redirect=true";
        }
        else
        {
            return "register?faces-redirect=true";
        }
    }
}
