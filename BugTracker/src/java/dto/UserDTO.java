package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="user")
public class UserDTO implements Serializable
{
    private int id;
    private String name;
    private String email;
    private String role;
    private String hashedPassword;

    public UserDTO(int id, String name,String email,String role,String hashedPassword)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
