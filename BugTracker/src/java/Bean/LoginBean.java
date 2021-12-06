package Bean;

import BackingBean.UserBB;
import dbase.UserGateway;
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
    
    private UserBB userBB = new UserBB();

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
            name = userBB.getUser(email).getName();
            role = userBB.getUser(email).getRole();
            id = Integer.toString(userBB.getUser(email).getId());
            return "secure/main?faces-redirect=true";
        }
        else
        {
            return "index?faces-redirect=true";
        }
    }
    public boolean checkRole(String role){
        if (this.role.equals(role)){
            return true;
        }
        else{
            return false;
        }
    }
    public String roleFirstPage(){
        if (this.role.equals("Admin")) {
            return "Manage Users";
        }
        else if (this.role.equals("Project Manager")) {
            return "All Projects";
        }
        else if (this.role.equals("Developer")) {
            return "Development plan";
        }
        else if (this.role.equals("Submitter")) {
            return "Submit Bug/Error";
        }
        else{
            return "";
        }
    }
    public String roleSecondPage(){
        if (this.role.equals("Admin")) {
            return "All Projects";
        }
        else if (this.role.equals("Project Manager")) {
            return "Create Project";
        }
        else if (this.role.equals("Developer")) {
            return "Developer Chat";
        }
        else if (this.role.equals("Submitter")) {
            return "Request feature";
        }
        else{
            return "";
        }
    }
}
